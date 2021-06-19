package service.impl;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void remove(int id){
        productRepository.removeProduct(id);
    }

    public Product findById(int id){
        return productRepository.findById(id);
    }

    public void updateProduct(int id, Product product){
        productRepository.updateProduct(id, product);
    }

    public void addNew(Product product){
        productRepository.addNew(product);
    }
}
