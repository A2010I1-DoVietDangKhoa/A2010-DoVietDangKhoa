package bai12_Java_Collection_Framework.bai_tap.LuyenTapSuDungArrayListLinkedListTrongJavaCollectionFramework.phanLinkedList;
import bai12_Java_Collection_Framework.bai_tap.LuyenTapSuDungArrayListLinkedListTrongJavaCollectionFramework.PriceComparatorAscend;
import bai12_Java_Collection_Framework.bai_tap.LuyenTapSuDungArrayListLinkedListTrongJavaCollectionFramework.PriceComparatorDescend;
import bai12_Java_Collection_Framework.bai_tap.LuyenTapSuDungArrayListLinkedListTrongJavaCollectionFramework.Product;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        productManager.addProduct(new Product("p1", 5, 22000));
        productManager.addProduct(new Product("p2", 6, 16000));
        productManager.addProduct(new Product("p3", 3, 32000));
        productManager.addProduct(new Product("p4", 1, 82000));


        while (true) {
            System.out.println("What do you want to do?: " +
                    "\n1. Add new product(s)." +
                    "\n2. Search a product." +
                    "\n3. Delete a product." +
                    "\n4. Check a product." +
                    "\n5. Edit a product." +
                    "\n6. Show all product." +
                    "\n7. Sort product list." +
                    "\n8. Exit.");
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
                    productManager.displayAllProductName();
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
                    productManager.displayAllProductName();
                    System.out.println("Input the index of the product you want to check: ");
                    int indexEdit = scanner.nextInt() - 1;
                    productManager.displayProduct(indexEdit);
                    System.out.println("Which attribute do you want to edit?: " +
                            "\n1. ID." +
                            "\n2. Name." +
                            "\n3. Price." +
                            "\n4. Go back.");
                    int choiceEdit = scanner.nextInt();
                    switch (choiceEdit){
                        case 1:
                            System.out.println("Input new ID: ");
                            ProductManager.productList.get(indexEdit).setId(scanner.nextInt());
                            break;

                        case 2:
                            System.out.println("Input new name: ");
                            scanner.nextLine();
                            ProductManager.productList.get(indexEdit).setName(scanner.nextLine());
                            break;

                        case 3:
                            System.out.println("Input new price: ");
                            ProductManager.productList.get(indexEdit).setPrice(scanner.nextLong());
                            break;

                        case 4:
                            break;

                        default:
                            System.out.println("Invalid choice");
                    }
                    break;


                case 6:
                    productManager.displayAllProduct();
                    break;

                case 7:
                    System.out.println("Choose sorting type: " +
                            "\n1. Ascending." +
                            "\n2. Descending." +
                            "\n3. Go back.");
                    int choiceSort = scanner.nextInt();
                    switch (choiceSort){
                        case 1:
                            System.out.println("Before sorting: ");
                            productManager.displayAllProduct();
                            PriceComparatorAscend ascend = new PriceComparatorAscend();
                            Collections.sort(ProductManager.productList, ascend);
                            System.out.println("After sorting: ");
                            productManager.displayAllProduct();
                            break;

                        case 2:
                            System.out.println("Before sorting: ");
                            productManager.displayAllProduct();
                            PriceComparatorDescend descend = new PriceComparatorDescend();
                            Collections.sort(ProductManager.productList, descend);
                            System.out.println("After sorting: ");
                            productManager.displayAllProduct();
                            break;

                        case 3:
                            break;

                            default:
                            System.out.println("Invalid choice");
                    }
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}
