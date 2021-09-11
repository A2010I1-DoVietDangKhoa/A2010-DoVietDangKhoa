package vn.codegym.casestudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import vn.codegym.casestudy.model.People.Customer.CustomerEntity;
import vn.codegym.casestudy.repository.Customer.CustomerRepository;
import vn.codegym.casestudy.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    private CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public void addNew(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
    }

    @Override
    public void update(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
    }

    @Override
    public Page<CustomerEntity> getList(String keyword, Pageable pageable) {
        return customerRepository.findCustomerEntitiesByNameContainingIgnoreCase(keyword, pageable);
    }

    @Override
    public CustomerEntity getOne(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void validateExistingCode(CustomerEntity customerEntity, Errors errors) {
        customerRepository.findByCustomerCode(customerEntity.getCustomerCode())
                .ifPresent(cus -> errors.rejectValue("customerCode", "duplicate.customer.id"));
    }
}
