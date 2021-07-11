package vn.codegym.demo.service;

public interface LogService {
    long getSize();

    void initialize();

    int getVisitorNumber(Integer id);

    void addVisitor(Integer id);
}