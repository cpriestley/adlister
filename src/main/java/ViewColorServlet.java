import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ViewColorServlet", urlPatterns = {"/viewcolor"})
public class ViewColorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bgColor = request.getParameter("color");
        request.setAttribute("bgColor", bgColor);
        request.getRequestDispatcher("/WEB-INF/viewColor.jsp").forward(request, response);
    }
}
