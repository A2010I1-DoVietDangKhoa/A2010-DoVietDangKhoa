import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", urlPatterns = "/display-discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDesc = request.getParameter("productDescript");
        int productPrice = Integer.parseInt(request.getParameter("productPrice"));
        int discountRate = Integer.parseInt(request.getParameter("discountPercent"));

        double discountAmount = productPrice * discountRate * 0.01;

        request.setAttribute("productDesc", productDesc);
        request.setAttribute("productPrice", productPrice);
        request.setAttribute("discountRate", discountRate);
        request.setAttribute("discountAmount", discountAmount);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
