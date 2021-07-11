package vn.codegym.demo.service;

import vn.codegym.demo.model.Book;
import vn.codegym.demo.model.Code;
import vn.codegym.demo.exception.NotAvailableException;
import vn.codegym.demo.exception.WrongCodeException;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(String id);

    boolean isAvailable(Book book);

    void borrowBook(String id) throws NotAvailableException;

    void returnBook(String id) throws WrongCodeException;
}
