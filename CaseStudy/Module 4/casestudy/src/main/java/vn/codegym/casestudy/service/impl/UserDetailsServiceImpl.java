package vn.codegym.casestudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.codegym.casestudy.model.People.Employee.UserEntity;
import vn.codegym.casestudy.model.People.Employee.UserRoleEntity;
import vn.codegym.casestudy.repository.Employee.UserRepository;
import vn.codegym.casestudy.repository.Employee.UserRoleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    private UserDetailsServiceImpl(UserRepository userRepository,
                                   UserRoleRepository userRoleRepository){
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findByUsername(username).orElse(null);

        if (userEntity == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        System.out.println("Found user: " + userEntity.getUsername() + " " + userEntity.getPassword());

        // [ROLE_USER, ROLE_ADMIN,..]
        List<UserRoleEntity> userRoles = this.userRoleRepository.findAllByUserEntity(userEntity);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (userRoles != null) {
            for (UserRoleEntity userRole : userRoles) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getRoleEntity().getName());
                grantList.add(authority);
            }
        }

        return (UserDetails) new User(userEntity.getUsername(), userEntity.getPassword(), grantList);
    }
}
