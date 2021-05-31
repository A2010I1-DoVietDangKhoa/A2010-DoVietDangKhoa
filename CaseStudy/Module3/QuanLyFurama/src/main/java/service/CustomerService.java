package service;

import model.Customer;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerService {
    void insertCustomer(Customer customer);

    Customer selectCustomer(int id) throws SQLException;

    ArrayList<Customer> selectAllCustomer() throws SQLException;

    boolean deleteCustomer(int id) throws SQLException;

    boolean updateCustomer(Customer customer) throws SQLException;

    ArrayList<Customer> searchCustomers(String name) throws SQLException;
    ArrayList<Customer> sortCustomers() throws SQLException;

}
