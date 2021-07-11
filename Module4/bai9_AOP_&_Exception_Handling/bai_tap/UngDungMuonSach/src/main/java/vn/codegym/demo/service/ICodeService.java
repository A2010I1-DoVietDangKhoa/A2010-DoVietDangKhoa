package vn.codegym.demo.service;

import vn.codegym.demo.model.Book;
import vn.codegym.demo.model.Code;

import java.util.List;

public interface ICodeService {
    List<Code> findAll();
    Code findById(Integer id);

    void save(Code code);

    List<Code> findAllCodeByBookId(Integer id);

    List<Code> findAvailableCodeByBookId(Integer id);

    List<Code> findUsedCodeByBookId(Integer id);

    void returnBookByCode(Book book, Integer returnCode);




}
