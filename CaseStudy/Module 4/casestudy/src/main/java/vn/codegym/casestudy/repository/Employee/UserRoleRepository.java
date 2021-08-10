package vn.codegym.casestudy.repository.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.casestudy.model.People.Employee.UserEntity;
import vn.codegym.casestudy.model.People.Employee.UserRoleEntity;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {
    List<UserRoleEntity> findAllByUserEntity(UserEntity userEntity);
}
