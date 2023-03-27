import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "ParameterTestServlet", urlPatterns = {"/parameterTest"})
public class ParameterTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String word = request.getParameter("word");
        out.println("<h1>You entered " + word + "!</h1>");
    }
}