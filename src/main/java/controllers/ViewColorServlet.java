package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "controllers.ViewColorServlet", urlPatterns = {"/viewcolor"})
public class ViewColorServlet extends HttpServlet {

    private final String VIEW_COLOR_JSP = "/WEB-INF/viewColor.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bgColor = request.getParameter("color");
        request.setAttribute("bgColor", bgColor);
        request.getRequestDispatcher(VIEW_COLOR_JSP).forward(request, response);
    }
}
