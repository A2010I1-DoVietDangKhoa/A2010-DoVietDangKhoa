package vn.codegym.demo.exception;

public class NotBorrowException extends Exception {
    @Override
    public String getMessage() {
        return "No book is borrowed";
    }
}
