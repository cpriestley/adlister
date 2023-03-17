package controllers;

import models.Ad;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.User;
import data.DaoFactory;

import java.io.IOException;

import static services.AdlisterConstants.CREATE_JSP;

@WebServlet(name = "controllers.CreateAdServlet", value = "/ads/create")
public class CreateAdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher(CREATE_JSP).forward(request, response);
            return;
        }
        request.getSession().setAttribute("intended-redirect", request.getRequestURI());
        response.sendRedirect("/login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description")
        );
        long id = DaoFactory.getAdsDao().insert(ad);
        System.out.printf("Inserted Ad with ID: %d%n", id);
        response.sendRedirect("/ads");
    }
}
