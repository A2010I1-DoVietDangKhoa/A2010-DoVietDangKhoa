package service;

import model.Product;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> getAllProduct();

    void addNewProduct(Product product);

    Product findById(int id);

    void updateProduct(int id, Product product);

    void removeProduct(int id);

    Product findByName(String name);
}
