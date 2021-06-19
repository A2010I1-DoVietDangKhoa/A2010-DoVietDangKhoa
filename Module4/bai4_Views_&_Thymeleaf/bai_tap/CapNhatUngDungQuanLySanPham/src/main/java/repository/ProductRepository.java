package repository;

import model.Product;

import java.util.List;

public interface ProductRepository{
    List<Product> findAll();

    Product findById(int id);

    void removeProduct(int id);

    void updateProduct(int id, Product product);

    void addNew(Product product);
}
