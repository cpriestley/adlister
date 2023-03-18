package controllers;

import com.mysql.cj.util.StringUtils;
import data.DaoFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.User;
import services.PasswordManager;

import java.io.IOException;

import static services.AdlisterConstants.PROFILE_JSP;

@WebServlet(name = "UserUpdateServlet", value = "/user/update")
public class UserUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }
        req.setAttribute("edit", true);
        req.setAttribute("buttonText", "Save");
        req.getRequestDispatcher(PROFILE_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirmation");
        if (StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(email) ||
                StringUtils.isNullOrEmpty(password) || StringUtils.isNullOrEmpty(passwordConfirm)) {
            req.setAttribute("edit", true);
            req.setAttribute("buttonText", "Save");
            req.setAttribute("error", "All fields are required");
            req.getRequestDispatcher(PROFILE_JSP).forward(req, resp);
            return;
        }
        if (!password.equals(passwordConfirm)) {
            req.setAttribute("edit", true);
            req.setAttribute("buttonText", "Save");
            req.setAttribute("error", "Passwords do not match");
            req.getRequestDispatcher(PROFILE_JSP).forward(req, resp);
            return;
        }
        PasswordManager passwordManager = new PasswordManager();
        String hash = passwordManager.hashPassword(password);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hash);
        int rowsAffected = DaoFactory.getUsersDao().update(user);
        if (rowsAffected == 1) {
            req.getSession().setAttribute("user", user);
        }
        resp.sendRedirect("/user/profile");
    }
}
