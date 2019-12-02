import quiz.Quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QuizServlet")
public class QuizServlet extends HttpServlet {


    private static final String INDEX_COOKIE = "indexcookie";
    private static final String SCORE_COOKIE = "scorecookie";
    private static final String ANSWER_COOKIE = "answercookie";

    private int userScore = 0;
    private int questionAnswerCount = 0;
    private int questionIndex = 0;

    private Cookie cookieIndex, cookieScore, cookieAnswer;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (cookieIndex == null) {
            cookieIndex = new Cookie(INDEX_COOKIE, "0");
            response.addCookie(cookieIndex);
        }
        if (cookieScore == null) {
            cookieScore = new Cookie(SCORE_COOKIE, "0");
            response.addCookie(cookieScore);
        }

        if (cookieAnswer == null) {
            cookieAnswer = new Cookie(ANSWER_COOKIE, "0");
            response.addCookie(cookieAnswer);
        }

        /*getting stored cookie value*/
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(INDEX_COOKIE)) {
                questionIndex = Integer.parseInt(cookie.getValue());
            } else if (cookie.getName().equals(SCORE_COOKIE)) {
                userScore = Integer.parseInt(cookie.getValue());
            } else if (cookie.getName().equals(ANSWER_COOKIE)) {
                questionAnswerCount = Integer.parseInt(cookie.getValue());
            }
        }

        /*adding data in jsp page */

        if (Quiz.questions.length > questionIndex) {
            request.setAttribute("question1", Quiz.questions[questionIndex]);
            request.setAttribute("question2", Quiz.questions[questionIndex + 1]);
            request.setAttribute("question3", Quiz.questions[questionIndex + 2]);
            request.setAttribute("question4", Quiz.questions[questionIndex + 3]);
            request.setAttribute("question5", Quiz.questions[questionIndex + 4]);
        } else {
            finalPage(request, response);
        }


        if (request.getParameter("answer") != null) {
            try {
                if (request.getParameter("answer") != null && Quiz.answers[questionAnswerCount] != null && request.getParameter("answer").equals(Quiz.answers[questionAnswerCount])) {
                    userScore = userScore + 1;
                    questionAnswerCount++;

                } else {
                    questionAnswerCount++;

                }
            } catch (Exception e) {
                finalPage(request, response);

                return;
            }
        }
        /* for next question*/
        if (Quiz.questions.length <= questionIndex && Quiz.answers.length <= questionAnswerCount) {

            request.setAttribute("score", userScore + "");
            request.getRequestDispatcher("/final.jsp").forward(request, response);
            return;
        } else {

            nextQuestionPage(request, response);
//            questionIndex = questionIndex + 5;
//            cookieIndex = new Cookie(INDEX_COOKIE, questionIndex + "");
//            response.addCookie(cookieIndex);
//
//            cookieScore = new Cookie(SCORE_COOKIE, userScore + "");
//            response.addCookie(cookieScore);
//
//            cookieAnswer = new Cookie(ANSWER_COOKIE, questionAnswerCount + "");
//            response.addCookie(cookieAnswer);
//
//            request.setAttribute("score", userScore + "");
//
//            request.getRequestDispatcher("/questions.jsp").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }

    private void finalPage(HttpServletRequest request, HttpServletResponse response) {

        cookieIndex = new Cookie(INDEX_COOKIE, "0");
        response.addCookie(cookieIndex);

        cookieScore = new Cookie(SCORE_COOKIE, "0");
        response.addCookie(cookieScore);

        cookieAnswer = new Cookie(ANSWER_COOKIE, "0");
        response.addCookie(cookieAnswer);

        request.setAttribute("score", userScore+1 + "");
        try {
            request.getRequestDispatcher("/final.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void nextQuestionPage(HttpServletRequest request, HttpServletResponse response) {
        questionIndex = questionIndex + 5;
        cookieIndex = new Cookie(INDEX_COOKIE, questionIndex + "");
        response.addCookie(cookieIndex);

        cookieScore = new Cookie(SCORE_COOKIE, userScore + "");
        response.addCookie(cookieScore);

        cookieAnswer = new Cookie(ANSWER_COOKIE, questionAnswerCount + "");
        response.addCookie(cookieAnswer);

        request.setAttribute("score", userScore + "");

        try {
            request.getRequestDispatcher("/questions.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
