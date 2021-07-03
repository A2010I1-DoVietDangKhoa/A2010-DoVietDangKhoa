package vn.codegym.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.blog.model.Category;
import vn.codegym.blog.repository.CategoryRepository;
import vn.codegym.blog.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void editCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> getAll(Pageable pageable){
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category getById(Integer id){
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAll(){
        return new ArrayList<>(categoryRepository.findAll());
    }
}
