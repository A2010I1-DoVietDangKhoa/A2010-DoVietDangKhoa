package Controllers;

import Models.Services.House;
import Models.Services.Room;
import Models.Services.Service;
import Models.Services.Villa;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceController {
    private static Pattern patternName = Pattern.compile("^[A-Z].*");

    public static void checkName(String name){
        Scanner scanner = new Scanner(System.in);
        Matcher matcher;
        boolean check = false;
        while(!check){
            matcher = patternName.matcher(name);
            if(!matcher.matches()) {
                System.out.println("Input service name (capitalize the first letter): ");
                name = scanner.nextLine();
            }
            else {
                check = true;
            }
        }
        //return name;
    }

    public static void addNewServices(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose an option: \n" +
                "1. Add New Villa.\n" +
                "2. Add New House.\n" +
                "3. Add New Room.\n" +
                "4. Back to main menu.\n" +
                "5. Exit.\n");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                Villa villa = new Villa();
                System.out.println("Input ID (format: SVVL-XXXX): ");
                scanner.nextLine();
                villa.setId(scanner.nextLine());
                System.out.println("Input service name (capitalize the first letter): ");
                String villaNameInput = scanner.nextLine();
                checkName(villaNameInput);
                villa.setName(villaNameInput);
                System.out.println("Input area (must be a number >= 30): ");
                String areaVilla = scanner.nextLine();
                while (!Service.checkArea(areaVilla)){
                    System.out.println("Area must be a number and >= 30: ");
                    areaVilla = scanner.nextLine();
                }
                villa.setArea(Double.parseDouble(areaVilla));
                System.out.println("Input fee: ");
                villa.setFee(scanner.nextLong());
                System.out.println("Input max people: ");
                villa.setMaxPeople(scanner.nextInt());
                System.out.println("Input rent type: ");
                scanner.nextLine();
                villa.setRentType(scanner.nextLine());
                System.out.println("Input villa quality: ");
                //scanner.nextLine();
                villa.setVillaQuality(scanner.nextLine());
                System.out.println("Input additional services: ");
                //scanner.nextLine();
                villa.setVillaAdditionalServices(scanner.nextLine());
                System.out.println("Input pool's area (must be a number >= 30): ");
                String areaPool = scanner.nextLine();
                while (!Service.checkArea(areaPool)){
                    System.out.println("Pool's area must be a number and >= 30: ");
                    areaPool = scanner.nextLine();
                }
                villa.setPoolArea(Double.parseDouble(areaPool));
                System.out.println("Input number of floors: ");
                String floorsVilla = scanner.nextLine();
                while (!Service.checkFloors(floorsVilla)){
                    System.out.println("Floors must be a number and >= 0: ");
                    floorsVilla = scanner.nextLine();
                }
                villa.setVillaFloors(Integer.parseInt(floorsVilla));
                Villa.writeVilla(villa);
                break;

            case 2:
                House house = new House();
                System.out.println("Input ID (format: SVHO-XXXX): ");
                scanner.nextLine();
                house.setId(scanner.nextLine());
                System.out.println("Input service name (capitalize the first letter): ");
                String houseNameInput = scanner.nextLine();
                checkName(houseNameInput);
                house.setName(houseNameInput);
                System.out.println("Input area (must be a number >= 30): ");
                String areaHouse = scanner.nextLine();
                while (!Service.checkArea(areaHouse)){
                    System.out.println("Area must be a number and >= 30: ");
                    areaHouse = scanner.nextLine();
                }
                house.setArea(Double.parseDouble(areaHouse));
                System.out.println("Input fee: ");
                house.setFee(scanner.nextLong());
                System.out.println("Input max people: ");
                house.setMaxPeople(scanner.nextInt());
                System.out.println("Input rent type: ");
                scanner.nextLine();
                house.setRentType(scanner.nextLine());
                System.out.println("Input house quality: ");
                house.setHouseQuality(scanner.nextLine());
                System.out.println("Input additional services: ");
                house.setHouseAdditionalServices(scanner.nextLine());
                System.out.println("Input number of floors: ");
                String floorsHouse = scanner.nextLine();
                while (!Service.checkFloors(floorsHouse)){
                    System.out.println("Floors must be a number and >= 0: ");
                    floorsHouse = scanner.nextLine();
                }
                house.setHouseFloors(Integer.parseInt(floorsHouse));
                House.writeHouse(house);
                break;

            case 3:
                Room room = new Room();
                System.out.println("Input ID (format: SVRO-XXXX): ");
                scanner.nextLine();
                room.setId(scanner.nextLine());
                System.out.println("Input service name (capitalize the first letter): ");
                String roomNameInput = scanner.nextLine();
                checkName(roomNameInput);
                room.setName(roomNameInput);
                System.out.println("Input area (must be a number >= 30): ");
                String areaRoom = scanner.nextLine();
                while (!Service.checkArea(areaRoom)){
                    System.out.println("Area must be a number and >= 30: ");
                    areaRoom = scanner.nextLine();
                }
                room.setArea(Double.parseDouble(areaRoom));
                System.out.println("Input fee: ");
                room.setFee(scanner.nextLong());
                System.out.println("Input max people: ");
                room.setMaxPeople(scanner.nextInt());
                System.out.println("Input rent type: ");
                scanner.nextLine();
                room.setRentType(scanner.nextLine());
                room.setFreeServicesChoices();
                Room.writeRoom(room);
                break;
            case 4:
                MainController.displayMainMenu();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
                addNewServices();
        }
    }

    public static void showServices(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose what you want to do: \n" +
                "1. Show all Villa.\n" +
                "2. Show all House.\n" +
                "3. Show all Room.\n" +
                "4. Show all Villa not Duplicate.\n" +
                "5. Show all House not Duplicate.\n" +
                "6. Show all Room not Duplicate.\n" +
                "7. Back to main menu.\n" +
                "8. Exit\n");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                //Villa.readVilla();
                if (Villa.villaArrayList.size() == 0) {
                    System.out.println("No data available.");
                } else {
                    for (Villa i : Villa.villaArrayList) {
                        System.out.println(i.showInfo());
                        System.out.println("-------------------------------------------------");
                    }
                }
                break;

            case 2:
                //House.readHouse();
                if (House.houseArrayList.size() == 0) {
                    System.out.println("No data available.");
                }
                else {
                    for (House i : House.houseArrayList) {
                        System.out.println(i.showInfo());
                        System.out.println("-------------------------------------------------");
                    }
                }
                break;

            case 3:
                //Room.readRoom();
                if(Room.roomArrayList.size() == 0){
                    System.out.println("No data available.");
                }
                else {
                    for (Room i : Room.roomArrayList) {
                        System.out.println(i.showInfo());
                        System.out.println("-------------------------------------------------");
                    }
                }
                break;

            case 4:
                TreeSet<String> treeSetVilla = new TreeSet<String>();
                //Villa.readVilla();
                System.out.println("List of unique Villa names: ");
                for (Villa i : Villa.villaArrayList){
                    treeSetVilla.add(i.getName());
                }
                for (String i : treeSetVilla){
                    System.out.println(i);
                }
                break;

            case 5:
                TreeSet<String> treeSetHouse = new TreeSet<String>();
                //House.readHouse();
                System.out.println("List of unique House names: ");
                for (House i : House.houseArrayList){
                    treeSetHouse.add(i.getName());
                }
                for (String i : treeSetHouse){
                    System.out.println(i);
                }
                break;

            case 6:
                TreeSet<String> treeSetRoom = new TreeSet<String>();
                //House.readHouse();
                System.out.println("List of unique Room names: ");
                for (Room i : Room.roomArrayList){
                    treeSetRoom.add(i.getName());
                }
                for (String i : treeSetRoom){
                    System.out.println(i);
                }
                break;

            case 7:
                MainController.displayMainMenu();
                break;

            case 8:
                System.exit(0);

            default:
                System.out.println("Invalid choice.");
                showServices();
        }
    }
}
