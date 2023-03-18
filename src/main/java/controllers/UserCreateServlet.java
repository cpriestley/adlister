package controllers;

import com.mysql.cj.util.StringUtils;
import data.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import services.PasswordManager;

import java.io.IOException;

import static services.AdlisterConstants.REGISTER_JSP;

@WebServlet(name = "RegisterServlet", value = "/user/register")
public class UserCreateServlet extends HttpServlet {
    private final PasswordManager passwordManager = new PasswordManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("buttonText", "Register");
        request.getRequestDispatcher(REGISTER_JSP)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("passwordConfirmation");

        if (StringUtils.isNullOrEmpty(username) ||
                StringUtils.isNullOrEmpty(email) ||
                StringUtils.isNullOrEmpty(password) ||
                StringUtils.isNullOrEmpty(passwordConfirmation)) {
            response.sendRedirect("/user/register");
            return;
        }

        if (DaoFactory.getUsersDao().findByUsername(username) != null ||
                DaoFactory.getUsersDao().findByEmail(username) != null ||
                !password.equals(passwordConfirmation)) {
            response.sendRedirect("/user/register");
            return;
        }
        String hash = passwordManager.hashPassword(password);
        User user = new User(username, email, hash);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/user/profile");
    }
}
