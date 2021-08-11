package vn.codegym.casestudy.repository.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.casestudy.model.People.Customer.CustomerEntity;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    Page<CustomerEntity> findCustomerEntitiesByNameContainingIgnoreCase(String keyword, Pageable pageable);

    @Query("select c from CustomerEntity c where c.customerCode = :code")
    Optional<CustomerEntity> findByCustomerCode(@Param("code") String code);

    @Transactional
    @Modifying
    @Query("delete from CustomerEntity c where c.customerCode = :code")
    void deleteByCode(@Param("code") String code);
}
