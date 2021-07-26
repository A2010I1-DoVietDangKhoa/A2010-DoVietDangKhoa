package vn.codegym.demo.service;

import vn.codegym.demo.model.Category;

import java.util.List;

public interface CategoryService{
    List<Category> getAll();

    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Integer id);
}
