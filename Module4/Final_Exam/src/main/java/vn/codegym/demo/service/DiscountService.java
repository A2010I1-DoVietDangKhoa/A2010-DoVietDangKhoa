package vn.codegym.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.demo.model.DiscountEntity;

public interface DiscountService {
    void addNew(DiscountEntity discountEntity);
    void update(DiscountEntity discountEntity);
    Page<DiscountEntity> getList(Pageable pageable);
    Page<DiscountEntity> getListWithParam(Integer keyword, Pageable pageable);
    DiscountEntity getOne(Integer id);
    void delete(Integer id);
}
