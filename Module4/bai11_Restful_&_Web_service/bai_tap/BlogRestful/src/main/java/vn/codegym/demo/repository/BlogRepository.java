package vn.codegym.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.demo.model.Blog;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query("select b from Blog b where b.category.name = :categoryName")
    List<Blog> selectBlogsFromCategory(@Param("categoryName") String categoryName);
}
