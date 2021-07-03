package vn.codegym.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.blog.model.Blog;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    Page<Blog> findByCategory(Integer categoryId, Pageable pageable);

    Page<Blog> searchBlogByName(String name, Pageable pageable);
}

