package Controllers;

import Models.Customer.Customer;
import Models.Services.House;
import Models.Services.Room;
import Models.Services.Villa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CustomerController {
    private static InputCheck ipCheck = new InputCheck();
    private static int ticketQuantity = 10;
    private static Queue<String> movieQueue = new LinkedList<String>();

    public static void addNewCustomer(){
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Input name: ");
        customer.setName(scanner.nextLine());
        System.out.println("Input date of birth: ");
        customer.setDateOfBirth(scanner.nextLine());
        System.out.println("Input gender: ");
        customer.setGender(scanner.nextLine());
        System.out.println("Input personal ID numbers: ");
        customer.setPersonalID(scanner.nextLine());
        System.out.println("Input phone number: ");
        customer.setPhoneNumber(scanner.nextLine());
        System.out.println("Input email: ");
        customer.setEmail(scanner.nextLine());
        System.out.println("Input customer type: ");
        customer.setCustomerType(scanner.nextLine());
        System.out.println("Input address: ");
        customer.setAddress(scanner.nextLine());
        Customer.writeCustomer(customer);
    }

    public static void addNewBooking(){
        Scanner scanner = new Scanner(System.in);
        Customer.readCustomer();
        int index = 1;
        for(Customer c : Customer.customerArrayList){
            System.out.println("Customer no." + index);
            c.showCustomerDetail();
            System.out.println("-------------------------------------------------");
            index++;
        }
        System.out.println("Please choose the index of the customer you want to add booking: ");
        String choice = scanner.nextLine();
        while (!ipCheck.isValidIndex(choice, Customer.customerArrayList.size())){
            System.out.println("Please input a valid index: ");
            choice = scanner.nextLine();
        }
        int customerIndex = Integer.parseInt(choice) - 1;
        boolean checkBook = false;
        while (!checkBook) {
            System.out.println("Which service do you want to book: " +
                    "\n1. Villa." +
                    "\n2. House." +
                    "\n3. Room." +
                    "\n4. Back to main menu.");
            int choiceBook = scanner.nextInt();
            switch (choiceBook){
                case 1:
                    //Villa.readVilla();
                    int indexVillaDisplay = 1;
                    for(Villa i : Villa.villaArrayList){
                        System.out.println("Villa no." + indexVillaDisplay);
                        System.out.println(i.showInfo());
                        System.out.println("-------------------------------------------------");
                        indexVillaDisplay++;
                    }
                    System.out.println("Please choose the index of the villa you want to book for this customer: ");
                    String choiceVilla = scanner.nextLine();
                    while (!ipCheck.isValidIndex(choiceVilla, Villa.villaArrayList.size())){
                        System.out.println("Please input a valid index: ");
                        choiceVilla = scanner.nextLine();
                    }
                    int villaIndex = Integer.parseInt(choiceVilla) - 1;
                    Customer.customerArrayList.get(customerIndex).setServiceUse(
                            Villa.villaArrayList.get(villaIndex));
                    checkBook = true;
                    clearCSV();
                    updateCSV();
                    break;

                case 2:
                    //House.readHouse();
                    int indexHouseDisplay = 1;
                    for(House i : House.houseArrayList){
                        System.out.println("House no." + indexHouseDisplay);
                        System.out.println(i.showInfo());
                        System.out.println("-------------------------------------------------");
                        indexHouseDisplay++;
                    }
                    System.out.println("Please choose the index of the house you want to book for this customer: ");
                    String choiceHouse = scanner.nextLine();
                    while (!ipCheck.isValidIndex(choiceHouse, House.houseArrayList.size())){
                        System.out.println("Please input a valid index: ");
                        choiceHouse = scanner.nextLine();
                    }
                    int houseIndex = Integer.parseInt(choiceHouse) - 1;
                    Customer.customerArrayList.get(customerIndex).setServiceUse(
                            House.houseArrayList.get(houseIndex));
                    clearCSV();
                    updateCSV();
                    checkBook = true;
                    break;

                case 3:
                    //Room.readRoom();
                    int indexRoomDisplay = 1;
                    for(Room i : Room.roomArrayList){
                        System.out.println("Room no." + indexRoomDisplay);
                        System.out.println(i.showInfo());
                        System.out.println("-------------------------------------------------");
                        indexRoomDisplay++;
                    }
                    System.out.println("Please choose the index of the room you want to book for this customer: ");
                    String choiceRoom = scanner.nextLine();
                    while (!ipCheck.isValidIndex(choiceRoom, Room.roomArrayList.size())){
                        System.out.println("Please input a valid index: ");
                        choiceRoom = scanner.nextLine();
                    }
                    int roomIndex = Integer.parseInt(choiceRoom) - 1;
                    Customer.customerArrayList.get(customerIndex).setServiceUse(
                            House.houseArrayList.get(roomIndex));
                    checkBook = true;
                    clearCSV();
                    updateCSV();
                    break;

                case 4:
                    MainController.displayMainMenu();
                    checkBook = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
                    checkBook = false;
            }
        }
    }

    public static void buyMovieTicket(){
        Scanner scanner = new Scanner(System.in);
        Customer.readCustomer();
        int index = 1;
        for(Customer c : Customer.customerArrayList){
            System.out.println("Customer no." + index);
            c.showCustomerDetail();
            System.out.println("-------------------------------------------------");
            index++;
        }
        System.out.println("Please choose the index of the customer you want to buy ticket for: ");
        String choice = scanner.nextLine();
        while (!ipCheck.isValidIndex(choice, Customer.customerArrayList.size())){
            System.out.println("Please input a valid index: ");
            choice = scanner.nextLine();
        }
        int customerIndex = Integer.parseInt(choice) - 1;
        if(ticketQuantity > 0) {
            movieQueue.offer(Customer.customerArrayList.get(customerIndex).getName());
            System.out.println("Purchased ticket successfully.");
            ticketQuantity--;
            System.out.println("Number of tickets left: " + ticketQuantity);
        }
        else {
            System.out.println("No ticket left.");
        }
    }

    public static void ticketRestock(){
        movieQueue.clear();
        System.out.println("Tickets restocked, current quantity: 10.");
        ticketQuantity = 10;
    }

    public static void viewerQueueCheck(){
        int queueNum = 1;
        if(movieQueue.isEmpty()){
            System.out.println("No viewer yet.");
        }
        else {
            for (String c : movieQueue) {
                System.out.println("Viewer no." + queueNum);
                System.out.println(c);
                queueNum++;
            }
        }
    }

    public static void updateCSV(){
        try {
            FileWriter fileWriter = new FileWriter(
                    "D:/A2010-DoVietDangKhoa/CaseStudy/Module2/src/Data/Customer.csv", true);
            for(Customer c : Customer.customerArrayList){
                fileWriter.write(c.toString());
            }
            //fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void clearCSV(){
        try {
            FileWriter fileWriter = new FileWriter(
                    "D:/A2010-DoVietDangKhoa/CaseStudy/Module2/src/Data/Customer.csv");
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//    public static void checkViewers(){
//        System.out.println(movieQueue);
//    }
}
