package vn.codegym.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.demo.model.Category;
import vn.codegym.demo.service.CategoryService;

import java.util.List;

@Controller(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String categoryList(Model model){
        model.addAttribute("categories", categoryService.getAll());
        return "categories/list";
    }

    @PostMapping("/create")
    public void addNewCategory(Category category){
        categoryService.addCategory(category);
    }

    @PostMapping("/edit")
    public void updateCategory(Category category){
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
    }
}
