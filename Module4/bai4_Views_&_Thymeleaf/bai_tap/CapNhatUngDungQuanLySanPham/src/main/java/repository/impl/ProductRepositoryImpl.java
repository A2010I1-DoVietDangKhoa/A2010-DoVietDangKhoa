package repository.impl;

import model.Product;
import org.springframework.stereotype.Repository;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Product 1", "AAAAAA", 100000));
        productList.add(new Product(2, "Product 2", "AAAAAAAAA", 2000000));
        productList.add(new Product(3, "Product 3", "BBBBBBBB", 30000));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    public void removeProduct(int id){
        productList.removeIf(p -> p.getProductId() == id);
    }

    public Product findById(int id){
        for(Product p : productList){
            if (p.getProductId() == id){
                return p;
            }
        }
        return null;
    }

    public void addNew(Product product){
        productList.add(product);
    }

    public void updateProduct(int id, Product product){
        for (int i = 0; i < productList.size(); i++){
            if(productList.get(i).getProductId() == id){
                productList.get(i).setProductName(product.getProductName());
                productList.get(i).setProductDesc(product.getProductDesc());
                productList.get(i).setProductPrice(product.getProductPrice());
            }
        }
    }
}
