package vn.codegym.casestudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.casestudy.model.People.Customer.CustomerEntity;
import vn.codegym.casestudy.model.People.Customer.CustomerTypeEntity;
import vn.codegym.casestudy.repository.Customer.CustomerTypeRepository;
import vn.codegym.casestudy.service.CustomerTypeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    private final CustomerTypeRepository customerTypeRepository;

    @Autowired
    private CustomerTypeServiceImpl(CustomerTypeRepository customerTypeRepository){
        this.customerTypeRepository = customerTypeRepository;
    }

    @Override
    public List<CustomerTypeEntity> getList() {
        return new ArrayList<>(customerTypeRepository.findAll());
    }
}
