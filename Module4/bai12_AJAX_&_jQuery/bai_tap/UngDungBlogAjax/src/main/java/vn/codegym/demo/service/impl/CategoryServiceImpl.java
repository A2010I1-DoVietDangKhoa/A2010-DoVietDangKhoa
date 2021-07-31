package vn.codegym.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.demo.model.Category;
import vn.codegym.demo.repository.CategoryRepository;
import vn.codegym.demo.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
