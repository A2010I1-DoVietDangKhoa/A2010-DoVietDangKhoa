package vn.codegym.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import vn.codegym.demo.exception.DuplicateEmailException;
import vn.codegym.demo.model.Customer;
import vn.codegym.demo.model.Province;
import vn.codegym.demo.repository.CustomerRepository;
import vn.codegym.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) throws DuplicateEmailException {
        try {
            customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }

    @Override
    public Customer findOne(Long id) throws Exception {
        Customer target = customerRepository.findById(id).get();
        if (target == null) {
            throw new Exception("customer not found!");
        }
        return target;
    }
}
