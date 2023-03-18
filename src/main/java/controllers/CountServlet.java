package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "controllers.CountServlet", urlPatterns = {"/count"})
public class CountServlet extends HttpServlet {

    private final String COUNT_JSP = "/WEB-INF/non-ads/count.jsp";
    private int counter = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        counter = "true".equalsIgnoreCase(req.getParameter("reset"))
                ? 0
                : counter;

        req.setAttribute("counter", ++counter);
        req.getRequestDispatcher(COUNT_JSP).forward(req, res);
    }
}
