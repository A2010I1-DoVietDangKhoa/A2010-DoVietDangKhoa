package vn.codegym.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.demo.exception.NotAvailableException;
import vn.codegym.demo.exception.WrongCodeException;
import vn.codegym.demo.service.impl.BookService;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ModelAndView listBooks() {
        return new ModelAndView("list", "books", bookService.findAll());
    }

    @GetMapping("/detail")
    public ModelAndView viewDetail(@RequestParam String id) {
        return new ModelAndView("detail", "book", bookService.findById(id));
    }

    @GetMapping("/borrow")
    public String borrowBook(@RequestParam String id, RedirectAttributes redirect) throws NotAvailableException {
        bookService.borrowBook(id);
        redirect.addFlashAttribute("message", "Borrowed successfully!");
        return "redirect:/";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam String id, RedirectAttributes redirect) throws WrongCodeException {
        bookService.returnBook(id);
        redirect.addFlashAttribute("message", "Returned successfully!");
        return "redirect:/";
    }

    @ExceptionHandler({NotAvailableException.class, WrongCodeException.class})
    public ModelAndView catchBorrowException(Exception e) {
        return new ModelAndView("error", "message", e.getMessage());
    }
}
