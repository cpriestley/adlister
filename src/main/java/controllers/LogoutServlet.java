package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "controllers.LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {

    private final String LOGIN_JSP = "/WEB-INF/login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
    }
}
