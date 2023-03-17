package controllers;

import data.DaoFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Ad;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "")
public class IndexServlet extends HttpServlet {

    private final String ALL_ADS_JSP = "/WEB-INF/index.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ad> ads = DaoFactory.getAdsDao().all();
        request.getSession().setAttribute("ads", ads);
        request.getRequestDispatcher(ALL_ADS_JSP).forward(request, response);
    }

}
