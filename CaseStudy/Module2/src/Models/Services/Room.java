package Models.Services;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Room extends Service{
    private String freeServices;
    public static ArrayList<Room> roomArrayList = new ArrayList<Room>();
    private Pattern patternRoom = Pattern.compile("(SVRO)(-)[\\d]{4}");
    private Scanner scanner = new Scanner(System.in);

    public Room(){

    }

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room(String id, String name, double area, long fee, int maxPeople, String rentType, String freeServices) {
        super(id, name, area, fee, maxPeople, rentType);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return this.freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    public void setFreeServicesChoices() {
        System.out.println("Pick one of the following services: " +
                "\n1. Massage." +
                "\n2. Karaoke" +
                "\n3. Food." +
                "\n4. Drink." +
                "\n5. Car.");
        int choice = scanner.nextInt();
        boolean check = false;
        while (!check){
            switch (choice){
                case 1:
                    this.setFreeServices("Massage");
                    check = true;
                    break;
                case 2:
                    this.setFreeServices("Karaoke");
                    check = true;
                    break;
                case 3:
                    this.setFreeServices("Food");
                    check = true;
                    break;
                case 4:
                    this.setFreeServices("Drink");
                    check = true;
                    break;
                case 5:
                    this.setFreeServices("Car");
                    check = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    check = false;
            }
        }
    }

    public static void writeRoom(Room room){
        try {
            FileWriter myWriter =
                    new FileWriter("D:/A2010-DoVietDangKhoa/CaseStudy/Module2/src/Data/Room.csv", true);
            myWriter.write(room.toString());

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readRoom() {
        //roomArrayList.clear();
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader =
                    new FileReader("D:/A2010-DoVietDangKhoa/CaseStudy/Module2/src/Data/Room.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if(!list.isEmpty()) {
            String[] arrayRoom = null;
            for (String i : list) {
                arrayRoom = i.split(",");
                Room room = new Room();
                room.setId(arrayRoom[0]);
                room.setName(arrayRoom[1]);
                room.setArea(Double.parseDouble(arrayRoom[2]));
                room.setFee(Long.parseLong(arrayRoom[3]));
                room.setMaxPeople(Integer.parseInt(arrayRoom[4]));
                room.setRentType(arrayRoom[5]);
                room.setFreeServices(arrayRoom[6]);
                roomArrayList.add(room);
            }
        }
        else {
            System.out.println();
        }
        Room.sortRoomList();
    }

    public void setId(String id){
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        while (!check){
            matcher = patternRoom.matcher(id);
            if(!matcher.matches()) {
                System.out.println("Input ID (format: SVRO-XXXX): ");
                id = scanner.nextLine();
            }
            else {
                check = true;
            }
        }
        this.id = id;
    }

    @Override
    public String showInfo() {
        return "Room info:" +
                "\n1. ID:" + this.getId() +
                "\n2. Name: " + this.getName() +
                "\n3. Area: " + this.getArea() +
                "\n4. Fee: " + this.getFee() +
                "\n5. Max capacity: " + this.getMaxPeople() +
                "\n6. Rent type: " + this.getRentType() +
                "\n7. Free services: " + this.freeServices;
    }

    public static void sortRoomList(){
        Collections.sort(roomArrayList, new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                if (o1.getName().compareTo(o2.getName()) != 0) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    int id01 = Integer.parseInt(o1.getId().substring(4));
                    int id02 = Integer.parseInt(o2.getId().substring(4));
                    return id02 - id01;
                }
            }
        });
    }

    @Override
    public String toString() {
        return this.getId() +
                "," + this.getName() +
                "," + this.getArea() +
                "," + this.getFee() +
                "," + this.getMaxPeople() +
                "," + this.getRentType() +
                "," + this.freeServices + "\n";
    }
}
