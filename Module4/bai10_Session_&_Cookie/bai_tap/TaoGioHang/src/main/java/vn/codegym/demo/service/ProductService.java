package vn.codegym.demo.service;

import vn.codegym.demo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    void saveProduct(Product product);
}
