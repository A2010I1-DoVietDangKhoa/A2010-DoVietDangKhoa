package bai12_Java_Collection_Framework.bai_tap.LuyenTapSuDungArrayListLinkedListTrongJavaCollectionFramework.phanLinkedList;
import bai12_Java_Collection_Framework.bai_tap.LuyenTapSuDungArrayListLinkedListTrongJavaCollectionFramework.Product;

import java.util.Collections;
import java.util.LinkedList;

public class ProductManager {
    public static LinkedList<Product> productList = new LinkedList<Product>();
    public void addProduct(Product p){
        productList.add(p);
        System.out.println("Product added.");
    }

    public void removeProduct(String name){
        String searchName = name.toLowerCase();
        int count = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().toLowerCase().equals(searchName)) {
                productList.remove(productList.get(i));
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Can't find the specified product.");
        }
    }

    public void displayProduct(int index){
        if(index < productList.size() && index >= 0) {
            System.out.println(productList.get(index).toString());
        }
        else {
            System.out.println("Invalid index.");
        }
    }

    public void displayAllProduct(){
        for(int i = 0; i < productList.size(); i++){
            System.out.println(productList.get(i).toString());
        }
    }

    public void displayAllProductName(){
        for(int i = 0; i < productList.size(); i++){
            System.out.println((i+1) + ". " + productList.get(i).getName());
        }
    }

    public void searchProduct(String name){
        String searchName = name.toLowerCase();
        int count = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().toLowerCase().equals(searchName)) {
                System.out.println(productList.get(i).toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Can't find the specified product.");
        }
    }

    public static LinkedList<Product> getProductList(){
        return productList;
    }

    public void sortProduct(){
        Collections.sort(productList);
    }
}


