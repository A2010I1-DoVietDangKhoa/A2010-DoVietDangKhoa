package service;

import model.Customer;
import repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService{

    private BaseRepository baseRepository = new BaseRepository();
    private Connection connection = baseRepository.getConnection();

    private static final String SELECT_ALL_CUSTOMER_INFO = " select customer_id, customer_firstname, customer_lastname," +
            " customer_birthday, customer_card, customer_phone,\n" +
            " customer_email, customer_address, customer_gender, customer_type_name from customer c \n" +
            " inner join customer_type ct\n" +
            " on c.fk_customer_type_id = ct.customer_type_id";

    private static final String SELECT_CUSTOMER_BY_ID = "select customer_id, customer_firstname, customer_lastname," +
            " customer_birthday, customer_card, customer_phone,\n" +
            " customer_email, customer_address, customer_gender, customer_type_name from customer c \n" +
            " inner join customer_type ct\n" +
            " on c.fk_customer_type_id = ct.customer_type_id\n" +
            " where c.customer_id = ?";

    private static final String INSERT_CUSTOMER = "insert into customer(fk_customer_type_id, customer_firstname," +
            " customer_lastname, customer_birthday, customer_card, customer_phone,\n" +
            " customer_email, customer_address, customer_gender)\n" +
            " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String DELETE_CUSTOMER = "delete from customer where customer_id = ?";

    private static final String UPDATE_CUSTOMER = "UPDATE customer\n" +
            "SET fk_customer_type_id = ?, customer_firstname = ?, customer_lastname = ?, customer_birthday = ?," +
            " customer_card = ?, customer_phone = ?,\n" +
            " customer_email = ?, customer_address = ?, customer_gender = ?\n" +
            "WHERE customer_id = ?";

    public CustomerServiceImpl() {
    }

    @Override
    public void insertCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
            if(customer.getCustomerType().equals("Diamond")){
                preparedStatement.setInt(1, 1);
            }
            else if(customer.getCustomerType().equals("Platinum")){
                preparedStatement.setInt(1, 2);
            }
            else if(customer.getCustomerType().equals("Gold")){
                preparedStatement.setInt(1, 3);
            }
            else if(customer.getCustomerType().equals("Silver")){
                preparedStatement.setInt(1, 4);
            }
            else if(customer.getCustomerType().equals("Member")){
                preparedStatement.setInt(1, 5);
            }
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
//            Date birthday = customer.getDateOfBirth();
//            String pattern = "yyyy-MM-dd";
//            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
//            String mysqlDateString = formatter.format(birthday);
            preparedStatement.setString(4, customer.getDateOfBirth());
            preparedStatement.setString(5, customer.getPersonalID());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            if (customer.getGender().equals("Female")){
                preparedStatement.setByte(9, (byte) 0);
            }
            else if(customer.getGender().equals("Male")){
                preparedStatement.setByte(9, (byte) 1);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Customer selectCustomer(int id){
        Customer customer = new Customer();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                createCustomerFromDB(resultSet, customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    private void createCustomerFromDB(ResultSet resultSet, Customer customer) {
        try {
            customer.setId(resultSet.getInt("customer_id"));
            customer.setFirstName(resultSet.getString("customer_firstname"));
            customer.setLastName(resultSet.getString("customer_lastname"));
            customer.setPersonalID(resultSet.getString("customer_card"));
            customer.setPhoneNumber(resultSet.getString("customer_phone"));
            customer.setAddress(resultSet.getString("customer_address"));
            customer.setEmail(resultSet.getString("customer_email"));
            customer.setCustomerType(resultSet.getString("customer_type_name"));
            //Date birthday = resultSet.getDate("customer_birthday");
            customer.setDateOfBirth(resultSet.getString("customer_birthday"));
            if(resultSet.getByte("customer_gender") == 0){
                customer.setGender("Female");
            }
            else {
                customer.setGender("Male");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ArrayList<Customer> selectAllCustomer(){
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_INFO);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = new Customer();
            while (resultSet.next()){
                createCustomerFromDB(resultSet, customer);
                customers.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            //Connection connection = baseRepository.getConnection();
            //PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
            PreparedStatement preparedStatement = connection.prepareCall(DELETE_CUSTOMER);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated = false;
        try {
            PreparedStatement preparedStatement = connection.prepareCall(UPDATE_CUSTOMER);
            //PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);
            if(customer.getCustomerType().equals("Diamond")){
                preparedStatement.setInt(1, 1);
            }
            else if(customer.getCustomerType().equals("Platinum")){
                preparedStatement.setInt(1, 2);
            }
            else if(customer.getCustomerType().equals("Gold")){
                preparedStatement.setInt(1, 3);
            }
            else if(customer.getCustomerType().equals("Silver")){
                preparedStatement.setInt(1, 4);
            }
            else if(customer.getCustomerType().equals("Member")){
                preparedStatement.setInt(1, 5);
            }
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getDateOfBirth());
            preparedStatement.setString(5, customer.getPersonalID());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            if (customer.getGender().equals("Female")){
                preparedStatement.setByte(9, (byte) 0);
            }
            else if(customer.getGender().equals("Male")){
                preparedStatement.setByte(9, (byte) 1);
            }
            preparedStatement.setInt(10, customer.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }   catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public ArrayList<Customer> searchCustomers(String name) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Customer> sortCustomers() throws SQLException {
        return null;
    }
}
