package service;

import model.Customer;

import java.util.List;

public interface CustomerService {


    List<Customer> findAll();

    Customer save(Customer customer);

    Customer findOne(int id);

    void update(int id, Customer customer);

    void remove(int id);

    List<Customer> save(List<Customer> customers);

    boolean exists(int id);

    List<Customer> findAll(List<Integer> ids);

    long count();

    void delete(int id);

    void delete(Customer customer);

    void delete(List<Customer> customers);

    void deleteAll();
}
