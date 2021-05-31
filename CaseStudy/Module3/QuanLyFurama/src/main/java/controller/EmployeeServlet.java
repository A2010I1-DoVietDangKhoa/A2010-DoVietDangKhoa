package controller;

import common.InputChecker;
import model.Customer;
import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeService employeeService;
    private InputChecker inputChecker = new InputChecker();

    public void init() {
        employeeService = new EmployeeServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request, response);
                    break;
////                case "sort":
////                    sortUsers(request, response);
////                    break;
                default:
                    listEmployee(request, response);
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
                    deleteEmployee(request, response);
                    break;
                case "search":
                    searchEmployee(request, response);
                    break;
//                case "sort":
//                    sortUsers(request, response);
//                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        ArrayList<Employee> listEmployees = employeeService.selectAllEmployees();
        request.setAttribute("listEmployee", listEmployees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.selectEmployee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String personalID = request.getParameter("cmnd");
        String division = request.getParameter("division");
        String position = request.getParameter("position");
        String education = request.getParameter("education");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String salaryText = request.getParameter("salary");
        double salary;
        if (salaryText == null){
            salary = 0;
        }
        else {
            salary = Double.parseDouble(salaryText);
        }
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setDivision(division);
        employee.setDateOfBirth(birthday);
        employee.setEducation(education);
        employee.setPosition(position);
        employee.setPersonalID(personalID);
        employee.setPhoneNumber(phone);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setSalary(salary);
        request.setAttribute("employee", employee);
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
        if(salary <= 0 || !inputChecker.isDouble(salaryText)){
            request.setAttribute("salaryMessage", "Salary must be greater than 0");
            //dispatcher.forward(request, response);
        }
        else {
            checkColumn++;
        }
        dispatcher.forward(request, response);
        if(checkColumn == 6) {
            employeeService.insertEmployee(employee);
            request.getRequestDispatcher("employee/create.jsp");
            dispatcher.forward(request, response);
            response.sendRedirect("/employees");
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        ArrayList<Employee> employees = employeeService.selectAllEmployees();
        request.setAttribute("listEmployee", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String personalID = request.getParameter("cmnd");
        String division = request.getParameter("division");
        String position = request.getParameter("position");
        String education = request.getParameter("education");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String salaryText = request.getParameter("salary");
        double salary;
        if (salaryText == null){
            salary = 0;
        }
        else {
            salary = Double.parseDouble(salaryText);
        }
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setDivision(division);
        employee.setDateOfBirth(birthday);
        employee.setEducation(education);
        employee.setPosition(position);
        employee.setPersonalID(personalID);
        employee.setPhoneNumber(phone);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setSalary(salary);
//        request.setAttribute("firstname", firstName);
//        request.setAttribute("lastname", lastName);
//        request.setAttribute("email", email);
//        request.setAttribute("phone", firstName);
//        request.setAttribute("address", address);
//        request.setAttribute("salary", salary);
//        request.setAttribute("cmnd", personalID);
        request.setAttribute("employee", employee);
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
        if(salary <= 0 || !inputChecker.isDouble(salaryText)){
            request.setAttribute("salaryMessage", "Salary must be greater than 0");
            //dispatcher.forward(request, response);
        }
        else {
            checkColumn++;
        }
        dispatcher.forward(request, response);
        if(checkColumn == 6) {
            employeeService.updateEmployee(employee);
            request.getRequestDispatcher("employee/edit.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String searchName = request.getParameter("key").toLowerCase();
        ArrayList<Employee> searchResult = employeeService.searchEmployees(searchName);
        request.setAttribute("searchResult", searchResult);
        request.getRequestDispatcher("employee/result.jsp").forward(request, response);
    }
}
