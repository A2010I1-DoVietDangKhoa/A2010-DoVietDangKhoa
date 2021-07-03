package vn.codegym.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.blog.model.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);

    void editCategory(Category category);

    void deleteCategory(Integer id);

    Page<Category> getAll(Pageable pageable);

    List<Category> getAll();

    Category getById(Integer id);
}
