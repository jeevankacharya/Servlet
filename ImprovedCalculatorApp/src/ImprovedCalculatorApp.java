import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ImprovedCalculatorApp")
public class ImprovedCalculatorApp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        if(request.getParameter("add1")!=null&&request.getParameter("add2")!=null){
            float add1 = Float.parseFloat(request.getParameter("add1"));
            float add2 = Float.parseFloat(request.getParameter("add2"));
//            writer.println("Add : "+ add1+ " +"+ add2+" = "+(add1+add2));
            request.setAttribute("addvalue", add1+add2);

        }

        if(request.getParameter("mul1")!=null&&request.getParameter("mul2")!=null){
            float mul1 = Float.parseFloat(request.getParameter("mul1"));
            float mul2 = Float.parseFloat(request.getParameter("mul2"));

            request.setAttribute("mulvalue", mul1*mul2);

//            writer.println("Mul : "+ mul1+ " +"+ mul2+" = "+(mul1* mul2));
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
