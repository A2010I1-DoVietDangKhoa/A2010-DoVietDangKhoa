package vn.codegym.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.demo.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
