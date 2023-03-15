package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import org.mindrot.jbcrypt.BCrypt;
import data.DaoFactory;

import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = DaoFactory.getUsersDao().findByUsername(username);

        if (user != null && BCrypt.checkpw(request.getParameter("password"), user.getPassword())) {
            request.getSession().setAttribute("user", user);
            String intendedRedirect = (String) request.getSession().getAttribute("intended-redirect");
            if (intendedRedirect == null) {
                intendedRedirect = "/WEB-INF/profile.jsp";

            } else {
                request.getSession().removeAttribute("intended-redirect");
            }
            request.getRequestDispatcher(intendedRedirect).forward(request, response);
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
