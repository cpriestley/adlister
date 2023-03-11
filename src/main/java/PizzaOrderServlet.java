import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PizzaOrderServlet", value = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pizzaOrder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.printf("Pizza Order Submitted%n" +
                        "- Crust:            %s%n" +
                        "- Sauce:            %s%n" +
                        "- Size:             %s%n" +
                        "- Toppings:         %s%n" +
                        "- Delivery Address: %s%n",
                request.getParameter("crust"),
                request.getParameter("sauce"),
                request.getParameter("size"),
                request.getParameter("toppings"),
                request.getParameter("delivery-address")
        );
        request.getRequestDispatcher("WEB-INF/pizzaOrder.jsp").forward(request, response);
    }
}
