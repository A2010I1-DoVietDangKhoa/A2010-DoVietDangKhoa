package bai12_Java_Collection_Framework.bai_tap.LuyenTapSuDungArrayListLinkedListTrongJavaCollectionFramework.phanArrayList;
import bai12_Java_Collection_Framework.bai_tap.LuyenTapSuDungArrayListLinkedListTrongJavaCollectionFramework.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want to do?: " +
                    "\n1. Add new product(s)." +
                    "\n2. Search a product." +
                    "\n3. Delete a product." +
                    "\n4. Check a product." +
                    "\n5. Show all product." +
                    "\n6. Sort product list." +
                    "\n7. Exit.");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Input product's name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Input product's ID: ");
                    int id = scanner.nextInt();
                    System.out.println("Input product's price: ");
                    long price = scanner.nextLong();
                    productManager.addProduct(new Product(name, id, price));
                    break;

                case 2:
                    System.out.println("Input the product's name you want to search: ");
                    scanner.nextLine();
                    String targetSearch = scanner.nextLine();
                    productManager.searchProduct(targetSearch);
                    break;

                case 3:
                    System.out.println("Input the product's name you want to delete: ");
                    scanner.nextLine();
                    String targetDelete = scanner.nextLine();
                    productManager.removeProduct(targetDelete);
                    break;

                case 4:
                    productManager.displayAllProductName();
                    System.out.println("Input the index of the product you want to check: ");
                    int index = scanner.nextInt() - 1;
                    productManager.displayProduct(index);
                    break;

                case 5:
                    productManager.displayAllProduct();
                    break;

                case 6:
                    System.out.println("Before sorting: ");
                    productManager.displayAllProduct();
                    System.out.println("After sorting: ");
                    productManager.sortProduct();
                    productManager.displayAllProduct();
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}
