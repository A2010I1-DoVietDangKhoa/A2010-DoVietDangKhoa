package vn.codegym.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.demo.model.Province;

public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}
