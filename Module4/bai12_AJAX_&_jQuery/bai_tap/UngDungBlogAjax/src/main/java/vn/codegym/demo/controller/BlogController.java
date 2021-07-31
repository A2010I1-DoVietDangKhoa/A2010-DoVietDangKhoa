package vn.codegym.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.demo.model.Blog;
import vn.codegym.demo.service.BlogService;
import vn.codegym.demo.service.CategoryService;

import java.util.List;

@Controller(value = "/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String categoryList(@RequestParam String categoryName, Model model){
        if (categoryName == null){
            model.addAttribute("blogs", blogService.getAll());
        }
        else {
            model.addAttribute("blogs", blogService.getByCategory(categoryName));
        }
        model.addAttribute("categories", categoryService.getAll());
        return "blogs/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("blogs/create", "blog", new Blog());
    }

    @PostMapping("/create")
    public void addNewBlog(Blog blog){
        blogService.addBlog(blog);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showCreateForm(@PathVariable Integer id){
        if (blogService.findById(id) != null) {
            return new ModelAndView("blogs/edit", "blog", blogService.findById(id));
        }
        else
            return new ModelAndView("error");
    }

    @PostMapping("/edit")
    public void updateBlog(Blog blog){
        blogService.updateBlog(blog);
    }

    @GetMapping("/delete/{id}")
    public void deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
    }
}
