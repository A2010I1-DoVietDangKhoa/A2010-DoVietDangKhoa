package vn.codegym.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.demo.model.Customer;
import vn.codegym.demo.model.Province;

import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);

    Optional<Customer> findById(Long id);
}
