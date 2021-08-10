package vn.codegym.casestudy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;
import vn.codegym.casestudy.model.People.Customer.CustomerEntity;

import java.util.List;

public interface CustomerService {
    void addNew(CustomerEntity customerEntity);
    void update(CustomerEntity customerEntity);
    Page<CustomerEntity> getList(String keyword, Pageable pageable);
    CustomerEntity getOne(Integer id);
    void delete(Integer id);
    void validateExistingCode(CustomerEntity customerEntity, Errors errors);
}
