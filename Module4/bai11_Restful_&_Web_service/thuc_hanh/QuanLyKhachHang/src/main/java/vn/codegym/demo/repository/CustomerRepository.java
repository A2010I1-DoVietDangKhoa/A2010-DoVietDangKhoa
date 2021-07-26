package vn.codegym.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
