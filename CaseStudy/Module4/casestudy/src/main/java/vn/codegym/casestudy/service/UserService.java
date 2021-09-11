package vn.codegym.casestudy.service;

import vn.codegym.casestudy.model.People.Employee.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAll();

    UserEntity findByUsername(String username);

    void save(UserEntity userEntity);
}
