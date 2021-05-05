import Beans.ZeroDivideException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculateServlet", urlPatterns = "/calculate")
public class CalculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstNum = request.getParameter("numOne");
        String secondNum = request.getParameter("numTwo");
        String operator = request.getParameter("ops");
        int result = 0;
        if (!isInteger(firstNum) || !isInteger(secondNum)){
            response.sendRedirect("inputNum.jsp");
        }
        else {
            int num1 = Integer.parseInt(firstNum);
            int num2 = Integer.parseInt(secondNum);
            if (operator.equals("div")) {
                try {
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        throw new ZeroDivideException();
                    }
                } catch (ZeroDivideException e) {
                    response.sendRedirect("divideByZero.jsp");
                }
            }
            else if (operator.equals("add")){
                result = num1 + num2;
            }
            else if (operator.equals("sub")){
                result = num1 - num2;
            }
            else if (operator.equals("mul")){
                result = num1 * num2;
            }
        }
        request.setAttribute("numOne", firstNum);
        request.setAttribute("numTwo", secondNum);
        if (operator.equals("add")){
            operator = "+";
        }
        else if (operator.equals("sub")){
            operator = "-";
        }
        else if (operator.equals("mul")){
            operator = "*";
        }
        else if (operator.equals("div")){
            operator = "/";
        }
        request.setAttribute("operator", operator);
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
