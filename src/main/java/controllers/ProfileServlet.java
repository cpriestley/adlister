package controllers;

import com.mysql.cj.util.StringUtils;
import data.DaoFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Ad;
import models.User;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.ProfileServlet", value = {"/profile","/edit", "/save"})
public class ProfileServlet extends HttpServlet {

    private final String PROFILE_JSP = "/WEB-INF/profile.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        User user = (User) request.getSession().getAttribute("user");
        List<Ad> ads = DaoFactory.getAdsDao().findAdsByUserId(user.getId());
        request.getSession().setAttribute("ads", ads);
        request.setAttribute("edit", "/edit".equals(request.getRequestURI()));
        request.setAttribute("buttonText", "Save");
        request.getRequestDispatcher(PROFILE_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/save".equals(req.getRequestURI())) {
            User user = (User) req.getSession().getAttribute("user");
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String passwordConfirm = req.getParameter("passwordConfirmation");
            if (StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(email) ||
                    StringUtils.isNullOrEmpty(password) || StringUtils.isNullOrEmpty(passwordConfirm)) {
                req.setAttribute("edit", true);
                req.setAttribute("error", "All fields are required");
                req.getRequestDispatcher(PROFILE_JSP).forward(req, resp);
                return;
            }
            if (!password.equals(passwordConfirm)) {
                req.setAttribute("edit", true);
                req.setAttribute("error", "Passwords do not match");
                req.getRequestDispatcher(PROFILE_JSP).forward(req, resp);
                return;
            }
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            boolean success = DaoFactory.getUsersDao().update(user);
            if (success) {
                req.getSession().setAttribute("user", user);
            }
            resp.sendRedirect("/profile");
        }
    }
}
