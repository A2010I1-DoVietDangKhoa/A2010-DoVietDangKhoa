package vn.codegym.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.demo.model.Book;

public interface IBookRepository extends JpaRepository<Book, String> {
    Book findByTitle(String title);
}
