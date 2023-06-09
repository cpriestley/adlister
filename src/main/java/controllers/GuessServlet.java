package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.random.RandomGenerator;

@WebServlet(name = "controllers.GuessServlet", value = "/guess")
public class GuessServlet extends HttpServlet {

    private final String GUESS_JSP = "/WEB-INF/non-ads/guess.jsp";
    private String answer = getRandom();
    boolean inProgress = true;

    private String getRandom() {
        return String.valueOf(RandomGenerator.getDefault().nextInt(3) + 1);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!inProgress) {
            answer = getRandom();
            inProgress = true;
        }
        request.getRequestDispatcher(GUESS_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guess = request.getParameter("guess");
        List<String> possibles = List.of("1", "2", "3");

        if (!possibles.contains(guess)){
            request.getRequestDispatcher(GUESS_JSP).forward(request, response);
            return;
        }

        if (answer.equals(guess)) {
            request.setAttribute("outcome", "You guessed correctly!");
            inProgress = false;
        } else {
            request.setAttribute("outcome", "You guessed incorrectly!");
        }
        request.getRequestDispatcher("/WEB-INF/non-ads/guessOutcome.jsp").forward(request, response);
    }
}
