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

import static services.AdlisterConstants.EDIT_JSP;

@WebServlet(name = "UpdateAdServlet", value = "/ad/update/*")
public class AdUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String adId = uri.substring(uri.lastIndexOf("/") + 1);
        System.out.println("adId = " + adId);
        Ad ad = DaoFactory.getAdsDao().findAdById(Long.parseLong(adId));
        request.setAttribute("edit", true);
        request.getSession().setAttribute("ad", ad);
        request.getRequestDispatcher(EDIT_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        String adId = uri.substring(uri.lastIndexOf("/") + 1);
        Ad ad = DaoFactory.getAdsDao().findAdById(Long.parseLong(adId));
        List<Ad> ads = (List<Ad>) request.getSession().getAttribute("userAds");
        int index = ads.indexOf(ad);
        //TODO: Make sure that the ad actually has different values
        ad.setTitle(request.getParameter("title"));
        ad.setDescription(request.getParameter("description"));
        DaoFactory.getAdsDao().update(ad);
        ads.set(index, ad);
        request.getSession().setAttribute("userAds", ads);
        response.sendRedirect("/user/profile");
    }
}
