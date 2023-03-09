import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = {"/hello"})
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = "World";
        if(req.getParameterMap().containsKey("name")) {
            name = req.getParameter("name");
        }
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println(String.format("<h1>Hello, %s!</h1>", name));
    }
}
