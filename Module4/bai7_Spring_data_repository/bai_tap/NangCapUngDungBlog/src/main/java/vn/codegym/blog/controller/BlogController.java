package vn.codegym.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.service.BlogService;
import vn.codegym.blog.service.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/blogs/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("blogs/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categories", categoryService.getAll());
        return modelAndView;
    }

    @PostMapping("/blogs/create")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blogs/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;

    }

    @GetMapping("/blogs")
    public String listBlogs(Optional<String> name, Optional<Integer> categoryId,
                                  @PageableDefault Pageable pageable, Model model){
        Iterable<Blog> blogs = blogService.findAll();
        List<Blog> blogList = new ArrayList<>();
        blogs.iterator().forEachRemaining(blogList::add);
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("blogs", blogList);
        if (!name.isPresent()){
            if (categoryId.isPresent()){
                Page<Blog> blog = blogService.findByCategory(categoryId.get(), pageable);
                model.addAttribute("blogs", blog);
                model.addAttribute("categoryId", categoryId.get());
                return "blogs/list";
            }
            model.addAttribute("blogs", blogService.findAll(pageable));
            return "blogs/list";
        } else {
            model.addAttribute("name", name.get());
            model.addAttribute("blogs", blogService.searchBlogByName(name.get(), pageable));
            return "blogs/list";
        }
    }

    @GetMapping("/blogs")
    public ModelAndView searchResult(@RequestParam String name, @PageableDefault Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/blogs/list");
        modelAndView.addObject("blogs", blogService.searchBlogByName(name, pageable));
        return modelAndView;
    }

    @GetMapping("/blogs")
    public ModelAndView listBlogsOfCategory(@PageableDefault Pageable pageable, @RequestParam Integer categoryId){
        return new ModelAndView("blogs/list", "blogs",blogService.findByCategory(categoryId, pageable));
    }

    @GetMapping("/blogs/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("blogs/edit");
            modelAndView.addObject("blog", blog);
            modelAndView.addObject("categories", categoryService.getAll());
            return modelAndView;

        }else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/blogs/edit")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blogs/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/blogs/delete/{id}")
    public String showDeleteForm(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("blogs", blogService.findAll());
        return "redirect:/";
    }

    @GetMapping("/blogs/detail/{id}")
    public ModelAndView showBlogDetail(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("blogs/detail");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            return new ModelAndView("/error");
        }
    }
}
