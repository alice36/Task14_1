import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/metryka")
public class CalcMetricsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String metry = request.getParameter("metry");
        String centymetry = request.getParameter("centymetry");
        String milimetry = request.getParameter("milimetry");
        double metr=0, centymetr=0, milimetr=0;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if (checkInput(metry, centymetry, milimetry)) {

            try {
                if (!metry.equals("")){
                    metr = Double.valueOf(metry);
                    centymetr = metr * 100;
                    milimetr = metr * 1000000;
                }
                if (!centymetry.equals("")){
                    centymetr = Double.valueOf(centymetry);
                    metr = centymetr/100;
                    milimetr = metr * 1000000;
                }
                if (!milimetry.equals("")){
                    milimetr =Double.valueOf(milimetry);
                    metr = milimetr/1000000;
                    centymetr = metr * 100;
                }

                writer.println(metry + " metry to: " + centymetr + " centymetry i " + milimetr + " milimetry");

            } catch (NumberFormatException e) {
                writer.println("Niepoprawne liczby!");
            }

        }else {
            writer.println("Wypelnij tylko jedna rubryke!");
        }
    }

    private boolean checkInput(String metry, String centymetry, String milimetry){
        Set<String> list = new HashSet<>();
        if (!metry.equals("")) list.add(metry);
        if (!centymetry.equals("")) list.add(centymetry);
        if (!milimetry.equals("")) list.add(milimetry);

        boolean answer = false;
        if (list.size() == 1) answer = true;
        return answer;

    }
}
