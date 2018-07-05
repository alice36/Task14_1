import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/waga")
public class CalcWeighServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kilogramy = request.getParameter("kilogramy");
        String gramy = request.getParameter("gramy");
        String miligramy = request.getParameter("miligramy");
        double kilogram=0, gram=0, miligram=0;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if (checkInput(kilogramy,gramy,miligramy)){

            try {
                if (!kilogramy.equals("")){
                    kilogram = Double.valueOf(kilogramy);
                    gram = kilogram * 100;
                    miligram = kilogram * 1000000;
                }
                if (!gramy.equals("")){
                    gram = Double.valueOf(gramy);
                    kilogram = gram/100;
                    miligram = kilogram * 1000000;
                }
                if (!miligramy.equals("")){
                    miligram =Double.valueOf(miligramy);
                    kilogram = miligram/1000000;
                    gram = kilogram * 100;
                }
                writer.println(kilogram + " kilogramy to: " + gram + " gramy i " + miligram + " miligramy");

            } catch (NumberFormatException e) {
                writer.println("Niepoprawne liczby!");
            }

        } else {
            writer.println("Wypelnij tylko jedna rubryke!");
        }
    }

    private boolean checkInput(String kilogramy, String gramy, String miligramy){
        Set<String> list = new HashSet<>();
        if (!kilogramy.equals("")) list.add(kilogramy);
        if (!gramy.equals("")) list.add(gramy);
        if (!miligramy.equals("")) list.add(miligramy);

        boolean answer = false;
        if (list.size() == 1) answer = true;
        return answer;

    }

}
