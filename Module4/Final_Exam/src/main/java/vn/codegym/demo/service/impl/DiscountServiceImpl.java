package vn.codegym.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.demo.model.DiscountEntity;
import vn.codegym.demo.repository.DiscountRepository;
import vn.codegym.demo.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;

    @Autowired
    private DiscountServiceImpl(DiscountRepository discountRepository){
        this.discountRepository = discountRepository;
    }

    @Override
    public void addNew(DiscountEntity discountEntity) {
        discountRepository.save(discountEntity);
    }

    @Override
    public void update(DiscountEntity discountEntity) {
        discountRepository.save(discountEntity);
    }

    @Override
    public Page<DiscountEntity> getList(Pageable pageable) {
        return discountRepository.findAll(pageable);
    }

    @Override
    public Page<DiscountEntity> getListWithParam(Integer keyword, Pageable pageable) {
        return discountRepository.findAllByDiscountRate(keyword, pageable);
    }


    @Override
    public DiscountEntity getOne(Integer id) {
        return discountRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        discountRepository.deleteById(id);
    }
}
