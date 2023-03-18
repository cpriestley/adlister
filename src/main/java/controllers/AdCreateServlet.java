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

import static services.AdlisterConstants.CREATE_JSP;

@WebServlet(name = "controllers.CreateAdServlet", value = "/ad/create")
public class AdCreateServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        String title = request.getParameter("title");

        if (isNullEmptyOrWhiteSpaceOnly(title)) {
            request.getRequestDispatcher(CREATE_JSP).forward(request, response);
            return;
        }

        String description = request.getParameter("description");

        Ad ad = new Ad(
                user.getId(),
                title,
                description
        );
        long id = DaoFactory.getAdsDao().insert(ad);
        System.out.printf("Inserted Ad with ID: %d%n", id);
        response.sendRedirect("/ad");
    }

    private boolean isNullEmptyOrWhiteSpaceOnly(String str) {
        return str == null || str.trim().isBlank();
    }
}
