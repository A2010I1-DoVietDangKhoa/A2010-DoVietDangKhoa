package vn.codegym.casestudy.service;

import vn.codegym.casestudy.model.People.Customer.CustomerEntity;
import vn.codegym.casestudy.model.People.Customer.CustomerTypeEntity;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerTypeEntity> getList();
}
