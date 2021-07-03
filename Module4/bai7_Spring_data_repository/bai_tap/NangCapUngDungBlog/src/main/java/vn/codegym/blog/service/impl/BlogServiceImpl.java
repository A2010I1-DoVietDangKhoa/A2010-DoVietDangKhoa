package vn.codegym.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.repository.BlogRepository;
import vn.codegym.blog.service.BlogService;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        if(blogRepository.findById(id).isPresent()) {
            return blogRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteBlogById(id);
    }

    @Override
    public Page<Blog> findByCategory(Integer categoryId, Pageable pageable){
        return blogRepository.findBlogsByCategory_Id(categoryId, pageable);
    }

    @Override
    public Page<Blog> searchBlogByName(String name, Pageable pageable){
        return blogRepository.findBlogsByTitleContainsIgnoreCase(name, pageable);
    }
}
