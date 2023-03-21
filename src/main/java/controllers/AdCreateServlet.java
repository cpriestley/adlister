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
import java.util.Map;

import static services.AdlisterConstants.CREATE_JSP;

@WebServlet(name = "controllers.CreateAdServlet", value = "/ads/create")
public class AdCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            List<String> categories = DaoFactory.getCategoriesDao().getCategories();
            Map<String, List<String>> subCategories = DaoFactory.getCategoriesDao().getAllSubCategories();
            request.getSession().setAttribute("categories", categories);
            request.getSession().setAttribute("subCategoryMap", subCategories);
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
        String category = request.getParameter("category");
        String[] subCategories = request.getParameterValues("subcategory");

        if (isNullEmptyOrWhiteSpaceOnly(title) || isNullEmptyOrWhiteSpaceOnly(category)) {
            request.getRequestDispatcher(CREATE_JSP).forward(request, response);
            return;
        }

        String description = request.getParameter("description");

        Ad ad = new Ad(
                user.getId(),
                title,
                description
        );
        long adId = DaoFactory.getAdsDao().insert(ad);
        ad.setId(adId);
        System.out.println("DaoFactory.getAdsDao().insert(ad): " + adId);
        long categoryId = DaoFactory.getCategoriesDao().insertAdCategory(adId, category);
        System.out.println("DaoFactory.getCategoriesDao().insertAdCategory(ad, category): " + categoryId);
        List<Long> ids = DaoFactory.getCategoriesDao().insertAdSubategories(adId, categoryId, subCategories);
        System.out.println("DaoFactory.getCategoriesDao().insertAdSubategories(ad, subCategories): " + ids);
        System.out.printf("Inserted Ad with ID: %d%n",  adId);
        response.sendRedirect("/ads");
    }

    private boolean isNullEmptyOrWhiteSpaceOnly(String str) {
        return str == null || str.trim().isBlank();
    }
}
