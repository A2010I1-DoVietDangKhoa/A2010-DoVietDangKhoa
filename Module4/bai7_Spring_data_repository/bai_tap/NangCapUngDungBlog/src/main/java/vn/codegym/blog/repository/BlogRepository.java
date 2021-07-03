package vn.codegym.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.blog.model.Blog;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    void deleteBlogById(Integer id);

    Page<Blog> findBlogsByCategory_Id(Integer categoryId, Pageable pageable);

    @Override
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findBlogsByTitleContainsIgnoreCase(String name, Pageable pageable);
}

