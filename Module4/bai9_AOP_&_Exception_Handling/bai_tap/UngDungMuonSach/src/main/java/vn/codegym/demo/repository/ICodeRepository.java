package vn.codegym.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.demo.model.Code;

import java.util.List;

public interface ICodeRepository extends JpaRepository<Code, Integer> {
    List<Code> findCodeByBook_Id(Integer id);
    List<Code> findCodeByBook_IdAndStatus_Id(Integer bookId, Integer statusId);


}
