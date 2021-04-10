package Controllers;

import Models.Customer.Customer;
import Models.Employee.Employee;
import Models.Employee.FileFolder;
import Models.Services.House;
import Models.Services.Room;
import Models.Services.Villa;

import java.io.*;
import java.util.*;

public class MainController {

    public static void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose what you want to do: \n" +
                "1. Add New Services.\n" +
                "2. Show Services.\n" +
                "3. Add New Customer.\n" +
                "4. Show Information of Customer.\n" +
                "5. Add New Booking.\n" +
                "6. Show Information of Employee.\n" +
                "7. Buy movie ticket.\n" +
                "8. Check viewers.\n" +
                "9. Restock movie ticket.\n" +
                "10. Search employee info.\n" +
                "11. Exit.\n");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                ServiceController.addNewServices();
                break;
            case 2:
                ServiceController.showServices();
                break;
            case 3:
                CustomerController.addNewCustomer();
                break;
            case 4:
                Customer.showCustomerInfo();
                break;
            case 5:
                CustomerController.addNewBooking();
                break;
            case 6:
                Employee.showEmployee();
                break;
            case 7:
                CustomerController.buyMovieTicket();
                break;
            case 8:
                CustomerController.viewerQueueCheck();
                break;
            case 9:
                CustomerController.ticketRestock();
                break;
            case 10:
                FileFolder.searchEmployee();
                break;
            case 11:
                Villa.villaArrayList.clear();
                House.houseArrayList.clear();
                Room.roomArrayList.clear();
                Customer.customerArrayList.clear();
                System.exit(0);

            default:
                System.out.println("Invalid choice.");
                displayMainMenu();
        }
    }


    public static void main(String[] args){
        Villa.readVilla();
        House.readHouse();
        Room.readRoom();
        Customer.readCustomer();
        while (true) {
            MainController.displayMainMenu();
        }
    }
}
