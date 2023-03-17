package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "controllers.PizzaOrderServlet", value = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {

    private final String PIZZA_ORDER_JSP = "/WEB-INF/pizzaOrder.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(PIZZA_ORDER_JSP).forward(request, response);
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
        request.getRequestDispatcher(PIZZA_ORDER_JSP).forward(request, response);
    }
}
