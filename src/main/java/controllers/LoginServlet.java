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

@WebServlet(name = "controllers.LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private final String LOGIN_JSP = "/WEB-INF/login.jsp";
    private final PasswordManager passwordManager = new PasswordManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = DaoFactory.getUsersDao().findByUsername(username);
        if (user != null) {
            boolean isPassword = passwordManager.checkPassword(request.getParameter("password"), user.getPassword());
            if (!isPassword) {
                request.setAttribute("error", "Invalid credentials.");
                request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
                return;
            }
        }
        request.getSession().setAttribute("user", user);
        String intendedRedirect = (String) request.getSession().getAttribute("intended-redirect");
        if (StringUtils.isNullOrEmpty(intendedRedirect)) {
            intendedRedirect = "/profile";
        }
        response.sendRedirect(intendedRedirect);

    }
}
