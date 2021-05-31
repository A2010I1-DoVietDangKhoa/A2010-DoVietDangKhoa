package controller;

import common.InputChecker;
import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerService customerService;
    private InputChecker inputChecker = new InputChecker();

    public void init() {
        customerService = new CustomerServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertCustomer(request, response);
                    break;
                case "edit":
                    updateCustomer(request, response);
                    break;
//                case "sort":
//                    sortUsers(request, response);
//                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
//                case "search":
//                    searchUser(request, response);
//                    break;
//                case "sort":
//                    sortUsers(request, response);
//                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        ArrayList<Customer> listCustomer = customerService.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String personalID = request.getParameter("cmnd");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String type = request.getParameter("type");
        String gender = request.getParameter("gender");

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setDateOfBirth(birthday);
        customer.setPersonalID(personalID);
        customer.setPhoneNumber(phone);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setCustomerType(type);
        customer.setGender(gender);
        request.setAttribute("customer", customer);
        int checkColumn = 0;
        if(!inputChecker.emailCheck(email) || email == null){
            request.setAttribute("emailMessage", "Wrong email format");
            //dispatcher.forward(request, response);
        }
        else {
            checkColumn++;
        }
        if(!inputChecker.nameCheck(firstName) || firstName == null){
            request.setAttribute("nameMessage1", "Wrong name format");
            //dispatcher.forward(request, response);
        }
        else {
            checkColumn++;
        }
        if(!inputChecker.nameCheck(lastName) || lastName == null){
            request.setAttribute("nameMessage2", "Wrong name format");
            //dispatcher.forward(request, response);
        }
        else {
            checkColumn++;
        }
        if(!inputChecker.idCheck(personalID) || personalID == null){
            request.setAttribute("cardMessage", "Wrong ID format");
            //dispatcher.forward(request, response);
        }
        else {
            checkColumn++;
        }
        if(!inputChecker.phoneCheck(phone) || phone == null){
            request.setAttribute("phoneMessage", "Wrong phone format");
            //dispatcher.forward(request, response);
        }
        else {
            checkColumn++;
        }
        if(checkColumn == 5) {
            customerService.insertCustomer(customer);
            request.getRequestDispatcher("customer/create.jsp");
            response.sendRedirect("/employees");
        }
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(id);
        ArrayList<Customer> customers = customerService.selectAllCustomer();
        request.setAttribute("listCustomer", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String personalID = request.getParameter("cmnd");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String type = request.getParameter("type");
        String gender = request.getParameter("gender");

        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setDateOfBirth(birthday);
        customer.setPersonalID(personalID);
        customer.setPhoneNumber(phone);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setCustomerType(type);
        customer.setGender(gender);
        request.setAttribute("customer", customer);
        int checkColumn = 0;
        if(!inputChecker.emailCheck(email) || email == null){
            request.setAttribute("emailMessage", "Wrong email format");
            //dispatcher.forward(request, response);
        }
        else {
            checkColumn++;
        }
        if(!inputChecker.nameCheck(firstName) || firstName == null){
            request.setAttribute("nameMessage1", "Wrong name format");
            //dispatcher.forward(request, response);
        }
        else {
            checkColumn++;
        }
        if(!inputChecker.nameCheck(lastName) || lastName == null){
            request.setAttribute("nameMessage2", "Wrong name format");
            //dispatcher.forward(request, response);
        }
        else {
            checkColumn++;
        }
        if(!inputChecker.idCheck(personalID) || personalID == null){
            request.setAttribute("cardMessage", "Wrong ID format");
            //dispatcher.forward(request, response);
        }
        else {
            checkColumn++;
        }
        if(!inputChecker.phoneCheck(phone) || phone == null){
            request.setAttribute("phoneMessage", "Wrong phone format");
            //dispatcher.forward(request, response);
        }
        else {
            checkColumn++;
        }
        if(checkColumn == 5) {
            customerService.updateCustomer(customer);
            request.getRequestDispatcher("customer/edit.jsp");
            response.sendRedirect("/customers");
        }
        dispatcher.forward(request, response);
    }
}
