import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = {"/count"})
public class CountServlet extends HttpServlet {
    private int counter = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        counter = "true".equalsIgnoreCase(req.getParameter("reset"))
                ? 0
                : counter;

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println(String.format("<h1>Count: %d</h1>", ++counter));
    }
}
