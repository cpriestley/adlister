package controllers;

import data.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Ad;
import models.User;

import java.io.IOException;
import java.util.List;

import static services.AdlisterConstants.PROFILE_JSP;

@WebServlet(name = "controllers.ProfileServlet", value = {"/user/profile"})
public class UserReadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        User user = (User) request.getSession().getAttribute("user");
        List<Ad> ads = (List<Ad>) request.getSession().getAttribute("userAds");
        if (ads == null) {
            ads = DaoFactory.getAdsDao().findAdsByUserId(user.getId());
            request.getSession().setAttribute("userAds", ads);
        }
        request.setAttribute("edit", "/user/update".equals(request.getRequestURI()));
        request.setAttribute("buttonText", "Save");
        request.getRequestDispatcher(PROFILE_JSP).forward(request, response);
    }

}
