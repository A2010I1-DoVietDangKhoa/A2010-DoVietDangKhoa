package vn.codegym.casestudy.repository.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.casestudy.model.People.Customer.CustomerTypeEntity;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerTypeEntity, Integer> {
}
