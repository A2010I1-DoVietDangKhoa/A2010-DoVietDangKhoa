package vn.codegym.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.demo.model.Book;
import vn.codegym.demo.model.Code;
import vn.codegym.demo.exception.NotAvailableException;
import vn.codegym.demo.exception.WrongCodeException;
import vn.codegym.demo.service.IBookService;
import vn.codegym.demo.service.ICodeService;
import vn.codegym.demo.service.IStatusService;

import java.util.List;

@Controller
public class CodeBorrowController {
    @Autowired
    IBookService bookService;

    @Autowired
    ICodeService codeService;

    @Autowired
    IStatusService statusService;

    @GetMapping("/viewborrow")
    public String view(Model model) {
        List<Code> codeBorrowList = codeService.findAll();
        model.addAttribute("codeBorrowList", codeBorrowList);
        return "code/view_code_borrow";
    }

    @GetMapping("/returnCode")
    public String returnPage(Model model, @RequestParam Integer id) {

        Code code=codeService.findById(id);
        Book book=code.getBook();

        model.addAttribute("book", book);
        model.addAttribute("code",code);
        return "code/returnbook";
    }
    @PostMapping("/returnCode")
    public String returnBook(Model model,@ModelAttribute Book book,@ModelAttribute Code code) throws WrongCodeException, NotAvailableException {

        bookService.returnBook(book,code.getCode());
        return "redirect:books";
    }


}