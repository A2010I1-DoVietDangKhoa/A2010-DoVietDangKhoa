package vn.codegym.demo.repository;

import org.springframework.data.repository.CrudRepository;
import vn.codegym.demo.model.Smartphone;

public interface SmartphoneRepository extends CrudRepository<Smartphone, Integer> {
}
