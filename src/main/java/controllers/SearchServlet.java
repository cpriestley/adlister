package controllers;

import data.DaoFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Ad;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/ads/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTerms = request.getParameter("searchTerms");
        String[] terms = searchTerms.split(" ");
        List<Ad> ads =  DaoFactory.getAdsDao().search(terms);
        request.getSession().setAttribute("ads", ads);
        request.getRequestDispatcher("/WEB-INF/index.jsp")
                .forward(request, response);
    }
}
