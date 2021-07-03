package vn.codegym.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.model.Category;

import java.util.List;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
    @Override
    List<Category> findAll();
}
