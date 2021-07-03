package vn.codegym.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.model.Category;
import vn.codegym.blog.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ModelAndView getAllCategories(@PageableDefault Pageable pageable){
        return new ModelAndView("categories/list", "categories", categoryService.getAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("categories/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveBlog(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        ModelAndView modelAndView = new ModelAndView("categories/create");
        modelAndView.addObject("category", new Blog());
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        Category category = categoryService.getById(id);
        if(category != null) {
            ModelAndView modelAndView = new ModelAndView("categories/edit");
            modelAndView.addObject("category", category);
            return modelAndView;

        }else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("category") Category category){
        categoryService.editCategory(category);
        ModelAndView modelAndView = new ModelAndView("categories/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PageableDefault Pageable pageable, @PathVariable Integer id, RedirectAttributes redirectAttributes){
        categoryService.deleteCategory(id);
        redirectAttributes.addFlashAttribute("categories", categoryService.getAll(pageable));
        return "redirect:/categories/";
    }
}
