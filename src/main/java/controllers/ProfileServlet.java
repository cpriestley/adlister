package controllers;

import data.DaoFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Ad;
import models.User;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        User user = (User) request.getSession().getAttribute("user");
        List<Ad> ads = DaoFactory.getAdsDao().findAdsByUserId(user.getId());
        request.setAttribute("ads", ads);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
