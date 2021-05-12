package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer, Product> productDB;

    static {
        productDB = new HashMap<>();
        productDB.put(1, new Product(1, "Dien thoai", "Dien thoai Samsung",
                2000000));
        productDB.put(2, new Product(2, "Laptop", "Laptop ASUS",
                4000000));
        productDB.put(3, new Product(3, "Sac du phong", "Sac du phong dien thoai",
                200000));
        productDB.put(4, new Product(4, "Man hinh", "Man hinh laptop",
                1000000));
        productDB.put(5, new Product(5, "May tinh bang", "May tinh bang Apple",
                3000000));
    }


    @Override
    public ArrayList<Product> getAllProduct() {
        return new ArrayList<>(productDB.values());
    }

    @Override
    public void addNewProduct(Product product) {
        productDB.put(product.getProductId(), product);
    }

    @Override
    public Product findById(int id) {
        return productDB.get(id);
    }

    @Override
    public ArrayList<Integer> findByName(String name) {
        ArrayList<Integer> idList = new ArrayList<>();
        String searchName = name.toLowerCase();
        int id;
        for(Product p : productDB.values()){
            if(p.getProductName().toLowerCase().equals(searchName)){
                id = p.getProductId();
                idList.add(id);
            }
        }
        return idList;
    }

    @Override
    public void updateProduct(int id, Product product) {
        productDB.put(id, product);
    }

    @Override
    public void removeProduct(int id) {
        productDB.remove(id);
    }
}
