package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.User;
import org.mindrot.jbcrypt.BCrypt;
import services.DaoFactory;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ads/register.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("passwordConfirmation");

        if (DaoFactory.getUsersDao().findByUsername(username) != null ||
                DaoFactory.getUsersDao().findByEmail(username) != null ||
                !password.equals(passwordConfirmation)) {
            response.sendRedirect("/register");
            return;
        }

        User user = new User(username, email, BCrypt.hashpw(password, BCrypt.gensalt()));
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/profile");
    }
}
