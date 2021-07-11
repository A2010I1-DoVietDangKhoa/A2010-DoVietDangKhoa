package vn.codegym.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.demo.model.Book;
import vn.codegym.demo.exception.NotAvailableException;
import vn.codegym.demo.exception.WrongCodeException;
import vn.codegym.demo.repository.IBookRepository;
import vn.codegym.demo.service.IBookService;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public boolean isAvailable(Book book) {
        return book.getQuantity() > 0;
    }

    @Override
    public void borrowBook(String id) throws NotAvailableException {
        Book book = bookRepository.getOne(id);
        if (isAvailable(book)) {
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);
        } else {
            throw new NotAvailableException();
        }
    }

    @Override
    public void returnBook(String id) throws WrongCodeException {
        Book book = findById(id);
        if (book != null) {
            book.setQuantity(book.getQuantity() + 1);
            bookRepository.save(book);
        } else {
            throw new WrongCodeException();
        }
    }
}
