package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "controllers.PickColorServlet", urlPatterns = {"/pickcolor"})
public class PickColorServlet extends HttpServlet {

    private final String PICK_COLOR_JSP = "/WEB-INF/non-ads/pickColor.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(PICK_COLOR_JSP).forward(request, response);
    }
}
