package controllers;

import models.Ad;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import data.DaoFactory;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.AdsServlet", urlPatterns = {"", "/ads", "/ad/*"})
public class AdsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String[] pathParts = uri.split("/");
        if (pathParts.length < 3) {
            List<Ad> ads = DaoFactory.getAdsDao().all();
            request.getSession().setAttribute("ads", ads);
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
            return;
        }
        String adId = pathParts[pathParts.length - 1];
        Ad ad = DaoFactory.getAdsDao().findAdById(Long.parseLong(adId));
        request.setAttribute("ad", ad);
        request.getRequestDispatcher("/WEB-INF/ads/ad.jsp").forward(request, response);
    }
}
