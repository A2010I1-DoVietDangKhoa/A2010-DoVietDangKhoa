package vn.codegym.demo.service;


import vn.codegym.demo.exception.DuplicateEmailException;
import vn.codegym.demo.model.Customer;
import vn.codegym.demo.model.Province;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    Customer findOne(Long id) throws Exception;

    void save(Customer customer) throws DuplicateEmailException;

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
