package vn.codegym.demo.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.demo.service.LogService;

@Aspect
public class Logger {
    @Autowired
    private LogService logService;

    @Before("execution(* vn.codegym.demo.controller.BookController.listBooks(..))")
    public void initializeLog(JoinPoint joinPoint) {
        logService.initialize();
    }

    @After("execution(* vn.codegym.demo.controller.BookController.listBooks(..))")
    public void afterLoad(JoinPoint joinPoint) {
        logService.addVisitor(1);
        System.err.println("[System] There is a new visit. Total number of visitors is " + logService.getVisitorNumber(1) + ".");
    }

    @AfterReturning("execution(* vn.codegym.demo.service.impl.BookService.borrowBook(..))")
    public void afterBorrowBook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.err.println("[System] Book with id " + args[0] + " have been borrowed.");
    }

    @AfterThrowing("execution(* vn.codegym.demo.service.impl.BookService.borrowBook(..))")
    public void afterOutOfBook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.err.println("[System] Quantity = 0. Books with id " + args[0] + " have been fully borrowed.");
    }

    @AfterReturning("execution(* vn.codegym.demo.service.impl.BookService.returnBook(..))")
    public void afterReturnBook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.err.println("[System] Book with id " + args[0] + " have been returned.");
    }
}
