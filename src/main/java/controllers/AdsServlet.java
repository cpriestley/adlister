package controllers;

import models.Ad;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.DaoFactory;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.AdsServlet", urlPatterns = {"", "/ads"})
public class AdsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ad> ads = DaoFactory.getAdsDao().all();
        request.setAttribute("ads", ads);
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}
