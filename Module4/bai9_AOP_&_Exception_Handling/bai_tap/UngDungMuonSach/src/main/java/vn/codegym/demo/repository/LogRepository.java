package vn.codegym.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.demo.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
}
