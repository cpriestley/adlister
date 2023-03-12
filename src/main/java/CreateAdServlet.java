import beans.Ad;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.DaoFactory;

import java.io.IOException;

@WebServlet(name = "CreateAdServlet", value = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Ad ad = new Ad(
                1, // for now we'll hardcode the user id
                request.getParameter("title"),
                request.getParameter("description")
        );
        long id = DaoFactory.getAdsDao().insert(ad);
        System.out.printf("Inserted Ad with ID: %d%n", id);
        response.sendRedirect("/ads");
    }
}
