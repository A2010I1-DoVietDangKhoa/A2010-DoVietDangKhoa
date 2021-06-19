package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    void remove(int id);

    void updateProduct(int id, Product product);

    void addNew(Product product);
}
