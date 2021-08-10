package vn.codegym.casestudy.repository.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.casestudy.model.People.Customer.CustomerEntity;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    Page<CustomerEntity> findCustomerEntitiesByNameContainingIgnoreCase(String keyword, Pageable pageable);

    Optional<CustomerEntity> findByCustomerCode(String code);
}
