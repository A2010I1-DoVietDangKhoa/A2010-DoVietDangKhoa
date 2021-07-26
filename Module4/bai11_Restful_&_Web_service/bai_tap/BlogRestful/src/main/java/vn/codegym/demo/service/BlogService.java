package vn.codegym.demo.service;

import vn.codegym.demo.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getAll();

    List<Blog> getByCategory(String categoryName);

    void addBlog(Blog blog);

    void updateBlog(Blog blog);

    void deleteBlog(Integer id);
}
