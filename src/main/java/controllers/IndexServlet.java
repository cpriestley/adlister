package controllers;

import data.DaoFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Ad;

import java.io.IOException;
import java.util.List;

import static services.AdlisterConstants.ALL_ADS_JSP;

@WebServlet(name = "IndexServlet", value = "")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ad> ads = (List<Ad>) request.getSession().getAttribute("ads");
        if (ads == null) {
            ads = DaoFactory.getAdsDao().all();
            request.getSession().setAttribute("ads", ads);
        }

        request.getRequestDispatcher(ALL_ADS_JSP).forward(request, response);
    }

}
