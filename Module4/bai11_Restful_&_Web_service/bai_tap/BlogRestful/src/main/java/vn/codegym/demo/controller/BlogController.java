package vn.codegym.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.codegym.demo.model.Blog;
import vn.codegym.demo.service.BlogService;

import java.util.List;

@RestController(value = "/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public List<Blog> categoryList(@RequestParam String categoryName){
        if (categoryName == null){
            return blogService.getAll();
        }
        else {
            return blogService.getByCategory(categoryName);
        }
    }

    @PostMapping("/create")
    public void addNewBlog(Blog blog){
        blogService.addBlog(blog);
    }

    @PostMapping("/edit")
    public void updateBlog(Blog blog){
        blogService.updateBlog(blog);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
    }
}
