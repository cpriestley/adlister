package controllers;

import data.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import models.UserRegistration;
import models.ValidationResult;
import services.PasswordManager;
import services.ValidationService;

import java.io.IOException;

import static services.AdlisterConstants.REGISTER_JSP;

@WebServlet(name = "RegisterServlet", value = "/users/register")
public class UserCreateServlet extends HttpServlet {
    private final PasswordManager passwordManager = new PasswordManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("buttonText", "Register");
        request.getRequestDispatcher(REGISTER_JSP)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        boolean isValid = passwordManager.checkPasswordsAreValid(
                request.getParameter("password"),
                request.getParameter("passwordConfirmation"));
        String hash = passwordManager.hashPassword(request.getParameter("password"));

        if (!isValid) {
            response.sendRedirect("/user/register");
            return;
        }

        UserRegistration registration = new UserRegistration(
                request.getParameter("username"),
                request.getParameter("email"),
                request.getParameter("password"),
                request.getParameter("passwordConfirmation")
        );


        ValidationResult vResult = ValidationService.validate(registration);
        if(!vResult.isValid()) {
            response.sendRedirect("/user/register");
            return;
        }

        User user = new User(registration.getUsername(), registration.getEmail(), hash);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/users/profile");
    }
}
