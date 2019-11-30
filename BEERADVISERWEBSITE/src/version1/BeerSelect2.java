package version1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "BeerSelect2")
public class BeerSelect2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color = request.getParameter("color");
        BeerExpert expert = new BeerExpert();
        List result = expert.getBrands(color);


        response.setContentType("text/html");
        PrintWriter out1 = response.getWriter();
        out1
                .println("Beer Selection Advice <br>");
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            out1.println("<br> try :" + iterator.next());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
