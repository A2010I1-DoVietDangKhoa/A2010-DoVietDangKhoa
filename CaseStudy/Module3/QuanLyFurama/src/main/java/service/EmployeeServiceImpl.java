package service;

import model.Employee;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService{
    private BaseRepository baseRepository = new BaseRepository();
    private Connection connection = baseRepository.getConnection();

    private static final String SELECT_ALL_EMPLOYEES = "select employee_id, employee_firstname, employee_lastname, position_name," +
            " education_level, division_name, employee_birthday,\n" +
            "employee_card, employee_salary, employee_phone, employee_email, employee_address from employee e\n" +
            "inner join position p on e.fk_position_id = p.position_id\n" +
            "inner join education ed on e.fk_education_id = ed.education_id\n" +
            "inner join division dv on e.fk_division_id = dv.division_id";

    private static final String SELECT_EMPLOYEE_BY_ID = "select employee_id, employee_firstname, employee_lastname, position_name," +
            " education_level, division_name, employee_birthday,\n" +
            "employee_card, employee_salary, employee_phone, employee_email, employee_address from employee e\n" +
            "inner join position p on e.fk_position_id = p.position_id\n" +
            "inner join education ed on e.fk_education_id = ed.education_id\n" +
            "inner join division dv on e.fk_division_id = dv.division_id where e.employee_id = ?";

    private static final String INSERT_EMPLOYEE = "insert into employee(employee_firstname, employee_lastname," +
            " fk_position_id, fk_education_id, fk_division_id, employee_birthday,\n" +
            "employee_card, employee_salary, employee_phone, employee_email, employee_address)\n" +
            "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String DELETE_EMPLOYEE = "delete from employee where employee_id = ?";

    private static final String UPDATE_EMPLOyEE = "update employee" +
            " set  employee_firstname = ?, employee_lastname = ?, fk_position_id = ?, fk_education_id = ?, fk_division_id = ?," +
            " employee_birthday = ?,\n" +
            " employee_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?" +
            "where employee_id = ?";

    private static final String SEARCH_EMPLOYEE_BY_NAME = "select * from employee where employee_lastname =" + '%' + '?' + '%';

    @Override
    public void insertEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            if(employee.getPosition().equals("Le tan")){
                preparedStatement.setInt(3, 1);
            }
            else if(employee.getPosition().equals("Phuc vu")){
                preparedStatement.setInt(3, 2);
            }
            else if(employee.getPosition().equals("Chuyen vien")){
                preparedStatement.setInt(3, 3);
            }
            else if(employee.getPosition().equals("Giam sat")){
                preparedStatement.setInt(3, 4);
            }
            else if(employee.getPosition().equals("Quan ly")){
                preparedStatement.setInt(3, 5);
            }
            else if(employee.getPosition().equals("Giam doc")){
                preparedStatement.setInt(3, 6);
            }
            if(employee.getEducation().equals("Trung cap")){
                preparedStatement.setInt(4, 1);
            }
            else if(employee.getEducation().equals("Cao dang")){
                preparedStatement.setInt(4, 2);
            }
            else if(employee.getEducation().equals("Dai hoc")){
                preparedStatement.setInt(4, 3);
            }
            else if(employee.getEducation().equals("Sau dai hoc")){
                preparedStatement.setInt(4, 4);
            }
            if(employee.getDivision().equals("Marketing")){
                preparedStatement.setInt(5, 1);
            }
            else if(employee.getDivision().equals("Hanh chinh")){
                preparedStatement.setInt(5, 2);
            }
            else if(employee.getDivision().equals("Quan ly")){
                preparedStatement.setInt(5, 3);
            }
            else if(employee.getDivision().equals("Phuc vu")){
                preparedStatement.setInt(5, 4);
            }
            preparedStatement.setString(6, employee.getDateOfBirth());
            preparedStatement.setString(7, employee.getPersonalID());
            preparedStatement.setDouble(8, employee.getSalary());
            preparedStatement.setString(9, employee.getPhoneNumber());
            preparedStatement.setString(10, employee.getEmail());
            preparedStatement.setString(11, employee.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = new Employee();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                createEmployeeFromDB(employee, resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    private void createEmployeeFromDB(Employee employee, ResultSet resultSet) throws SQLException {
        employee.setId(resultSet.getInt("employee_id"));
        employee.setFirstName(resultSet.getString("employee_firstname"));
        employee.setLastName(resultSet.getString("employee_lastname"));
        employee.setPersonalID(resultSet.getString("employee_salary"));
        employee.setPosition(resultSet.getString("position_name"));
        employee.setDivision(resultSet.getString("division_name"));
        employee.setEducation(resultSet.getString("education_level"));
        employee.setPhoneNumber(resultSet.getString("employee_phone"));
        employee.setDateOfBirth(resultSet.getString("employee_birthday"));
        employee.setAddress(resultSet.getString("employee_address"));
        employee.setEmail(resultSet.getString("employee_email"));
        employee.setSalary(resultSet.getDouble("employee_salary"));
    }

    @Override
    public ArrayList<Employee> selectAllEmployees() throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = new Employee();
                createEmployeeFromDB(employee, resultSet);
//                employee.setId(resultSet.getInt("employee_id"));
//                employee.setFirstName(resultSet.getString("employee_firstname"));
//                employee.setLastName(resultSet.getString("employee_lastname"));
//                employee.setPersonalID(resultSet.getString("employee_salary"));
//                employee.setPosition(resultSet.getString("position_name"));
//                employee.setDivision(resultSet.getString("division_name"));
//                employee.setEducation(resultSet.getString("education_level"));
//                employee.setPhoneNumber(resultSet.getString("employee_phone"));
//                employee.setDateOfBirth(resultSet.getString("employee_birthday"));
//                employee.setAddress(resultSet.getString("employee_address"));
//                employee.setEmail(resultSet.getString("employee_email"));
//                employee.setSalary(resultSet.getDouble("employee_salary"));
                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            PreparedStatement preparedStatement = connection.prepareCall(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOyEE);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            if(employee.getPosition().equals("Le tan")){
                preparedStatement.setInt(3, 1);
            }
            else if(employee.getPosition().equals("Phuc vu")){
                preparedStatement.setInt(3, 2);
            }
            else if(employee.getPosition().equals("Chuyen vien")){
                preparedStatement.setInt(3, 3);
            }
            else if(employee.getPosition().equals("Giam sat")){
                preparedStatement.setInt(3, 4);
            }
            else if(employee.getPosition().equals("Quan ly")){
                preparedStatement.setInt(3, 5);
            }
            else if(employee.getPosition().equals("Giam doc")){
                preparedStatement.setInt(3, 6);
            }
            if(employee.getEducation().equals("Trung cap")){
                preparedStatement.setInt(4, 1);
            }
            else if(employee.getEducation().equals("Cao dang")){
                preparedStatement.setInt(4, 2);
            }
            else if(employee.getEducation().equals("Dai hoc")){
                preparedStatement.setInt(4, 3);
            }
            else if(employee.getEducation().equals("Sau dai hoc")){
                preparedStatement.setInt(4, 4);
            }
            if(employee.getDivision().equals("Marketing")){
                preparedStatement.setInt(5, 1);
            }
            else if(employee.getDivision().equals("Hanh chinh")){
                preparedStatement.setInt(5, 2);
            }
            else if(employee.getDivision().equals("Quan ly")){
                preparedStatement.setInt(5, 3);
            }
            else if(employee.getDivision().equals("Phuc vu")){
                preparedStatement.setInt(5, 4);
            }
            preparedStatement.setString(6, employee.getDateOfBirth());
            preparedStatement.setString(7, employee.getPersonalID());
            preparedStatement.setDouble(8, employee.getSalary());
            preparedStatement.setString(9, employee.getPhoneNumber());
            preparedStatement.setString(10, employee.getEmail());
            preparedStatement.setString(11, employee.getAddress());
            preparedStatement.setInt(12, employee.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public ArrayList<Employee> searchEmployees(String searchName) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE_BY_NAME);
        preparedStatement.setString(1, searchName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Employee employee = new Employee();
            createEmployeeFromDB(employee, resultSet);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public ArrayList<Employee> sortEmployees() throws SQLException {
        return null;
    }
}
