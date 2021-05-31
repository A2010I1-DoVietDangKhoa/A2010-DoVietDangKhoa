package service;

import model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeService {
    void insertEmployee(Employee employee);

    Employee selectEmployee(int id);

    ArrayList<Employee> selectAllEmployees() throws SQLException;

    boolean deleteEmployee(int id) throws SQLException;

    boolean updateEmployee(Employee employee) throws SQLException;

    ArrayList<Employee> searchEmployees(String name) throws SQLException;
    ArrayList<Employee> sortEmployees() throws SQLException;
}
