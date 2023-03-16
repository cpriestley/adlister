package controllers;

import data.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import services.PasswordManager;

import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private final PasswordManager passwordManager = new PasswordManager();

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
        if (user != null) {
            boolean isPassword = passwordManager.checkPassword(request.getParameter("password"), user.getPassword());
            if (!isPassword) {
                request.setAttribute("error", "Invalid credentials.");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
        }
        request.getSession().setAttribute("user", user);
        String intendedRedirect = "" + request.getSession().getAttribute("intended-redirect");
        if (intendedRedirect.isEmpty()) {
            intendedRedirect = "/WEB-INF/profile.jsp";
        }
        request.getRequestDispatcher(intendedRedirect).forward(request, response);

    }
}
