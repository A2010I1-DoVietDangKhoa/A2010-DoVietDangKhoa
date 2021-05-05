import Beans.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/","/customer"})
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        customerArrayList.add(new Customer("Nguyen Van A", "01-01-1996", "123 Dinh Tien Hoang",
                "https://cdn0.tnwcdn.com/wp-content/blogs.dir/1/files/2020/01/q3V3Xe3.jpg"));
        customerArrayList.add(new Customer("Nguyen Van B", "02-02-1996", "124 Dinh Tien Hoang",
                "https://d3bzyjrsc4233l.cloudfront.net/news/Harold.jpg"));
        customerArrayList.add(new Customer("Nguyen Van C", "03-03-1996", "125 Dinh Tien Hoang",
                "https://hungarytoday.hu/wp-content/uploads/2020/06/Hide-the-Pain-Harold-prof..jpg"));

        request.setAttribute("customerList", customerArrayList);
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }
}
