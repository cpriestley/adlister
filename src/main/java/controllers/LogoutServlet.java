package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static services.AdlisterConstants.ALL_ADS_JSP;

@WebServlet(name = "controllers.LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("user", null);
        request.getSession().setAttribute("userAds", null);
        request.getRequestDispatcher(ALL_ADS_JSP).forward(request, response);
    }
}
