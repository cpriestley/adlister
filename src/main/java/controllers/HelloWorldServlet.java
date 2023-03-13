package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "controllers.HelloWorldServlet", urlPatterns = {"/hello"})
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String name = req.getParameter("name");
        if( name == null) {
            name = "World";
        } else if ( "bgates".equalsIgnoreCase(name) ) {
            res.sendRedirect("https://www.microsoft.com");
            return;
        }
        req.setAttribute("name", name);
        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, res);
    }
}
