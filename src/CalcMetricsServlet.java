import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/metryka")
public class CalcMetricsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String metry = request.getParameter("metry");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try {
            double metr = Double.valueOf(metry);
            double centymetr = metr * 100;
            double milimetr = metr * 10000;

            writer.println(metry + " metry to: " + centymetr + " centymetry i " + milimetr + " milimetry");

        } catch (NumberFormatException e) {
            writer.println("Niepoprawne liczby!");
        }

    }
}
