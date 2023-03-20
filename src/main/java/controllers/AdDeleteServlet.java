package controllers;

import data.DaoFactory;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Ad;
import models.User;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteAdServlet", value = "/ads/delete/*")
public class AdDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        String[] pathParts = uri.split("/");
        int rowsAffected = DaoFactory.getAdsDao().delete(Long.parseLong(pathParts[pathParts.length - 1]));
        if (rowsAffected != 1) {
            throw new RuntimeException("Unable to delete ad");
        }
        User user = (User) request.getSession().getAttribute("user");
        List<Ad> ads = DaoFactory.getAdsDao().findAdsByUserId(user.getId());
        request.getSession().setAttribute("userAds", ads);
        response.sendRedirect("/users/profile");
    }
}
