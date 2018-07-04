import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/waga")
public class CalcWeighServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kilogramy = request.getParameter("kilogramy");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try {
            double kilogram = Double.valueOf(kilogramy);
            double gram = kilogram * 100;
            double miligram = kilogram * 1000000;

            writer.println(kilogram + " kilogramy to: " + gram + " gramy i " + miligram + " miligramy");

        } catch (NumberFormatException e) {
            writer.println("Niepoprawne liczby!");
        }
    }
}
