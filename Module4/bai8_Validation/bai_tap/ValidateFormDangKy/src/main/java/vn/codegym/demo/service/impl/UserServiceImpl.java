package vn.codegym.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.demo.model.User;
import vn.codegym.demo.repository.UserRepository;
import vn.codegym.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addNewUser(User user){
        userRepository.save(user);
    }
}
