package vn.codegym.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.demo.model.Status;

public interface IStatusRepository extends JpaRepository<Status, Integer> {
}
