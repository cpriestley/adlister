package controllers;

import data.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Ad;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.AdsServlet", urlPatterns = {"", "/ads", "/ad/*"})
public class AdsServlet extends HttpServlet {

    public final String SINGLE_AD_JSP = "/WEB-INF/ads/ad.jsp";
    public final String ALL_ADS_JSP = "/WEB-INF/ads/index.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String[] pathParts = uri.split("/");
        if (pathParts.length < 3) {
            displayAllAds(request, response);
            return;
        }
        displaySingleAd(request, response, pathParts[pathParts.length - 1]);
    }

    private void displaySingleAd(HttpServletRequest request, HttpServletResponse response, String adId) throws ServletException, IOException {
        Ad ad = DaoFactory.getAdsDao().findAdById(Long.parseLong(adId));
        request.setAttribute("ad", ad);
        request.getRequestDispatcher(SINGLE_AD_JSP).forward(request, response);
    }

    private void displayAllAds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ad> ads = DaoFactory.getAdsDao().all();
        request.getSession().setAttribute("ads", ads);
        request.getRequestDispatcher(ALL_ADS_JSP).forward(request, response);
    }
}
