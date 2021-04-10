package Models.Services;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class House extends Service{
    private String houseQuality;
    private String houseAdditionalServices;
    private int houseFloors;
    public static ArrayList<House> houseArrayList = new ArrayList<House>();
    private Pattern patternHouse = Pattern.compile("(SVHO)(-)[\\d]{4}");
    private Pattern patternName = Pattern.compile("^[A-Z].*");
    Scanner scanner = new Scanner(System.in);

    public House(){

    }

    public House(String name, String houseQuality, String houseAdditionalServices, int houseFloors, String id, double area, long fee,
                 int maxPeople, String rentType) {
        super(id, name, area, fee, maxPeople, rentType);
        this.houseQuality = houseQuality;
        this.houseAdditionalServices = houseAdditionalServices;
        this.houseFloors = houseFloors;
    }

    public String getHouseQuality() {
        return this.houseQuality;
    }

    public void setHouseQuality(String houseQuality) {
        Matcher matcher;
        boolean check = false;
        while (!check){
            matcher = patternName.matcher(houseQuality);
            if(!matcher.matches()) {
                System.out.println("Input house quality (capitalize the first letter): ");
                houseQuality = scanner.nextLine();
            }
            else {
                check = true;
            }
        }
        this.houseQuality = houseQuality;
    }

    public String getHouseAdditionalServices() {
        return this.houseAdditionalServices;
    }

    public void setHouseAdditionalServices(String houseAdditionalServices) {
        this.houseAdditionalServices = houseAdditionalServices;
    }

    public int getHouseFloors() {
        return this.houseFloors;
    }

    public void setHouseFloors(int houseFloors) {
        this.houseFloors = houseFloors;
    }

    public static void writeHouse(House house){
        try {
            FileWriter myWriter =
                    new FileWriter("D:/A2010-DoVietDangKhoa/CaseStudy/Module2/src/Data/House.csv", true);
            myWriter.write(house.toString());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readHouse() {
        //houseArrayList.clear();
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader =
                    new FileReader("D:/A2010-DoVietDangKhoa/CaseStudy/Module2/src/Data/House.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if(!list.isEmpty()) {
            String[] arrayHouse = null;
            for (String i : list) {
                arrayHouse = i.split(",");
                House house = new House();
                house.setId(arrayHouse[0]);
                house.setName(arrayHouse[1]);
                house.setArea(Double.parseDouble(arrayHouse[2]));
                house.setFee(Long.parseLong(arrayHouse[3]));
                house.setMaxPeople(Integer.parseInt(arrayHouse[4]));
                house.setRentType(arrayHouse[5]);
                house.setHouseQuality(arrayHouse[6]);
                house.setHouseAdditionalServices(arrayHouse[7]);
                house.setHouseFloors(Integer.parseInt(arrayHouse[8]));
                houseArrayList.add(house);
            }
        }
        else {
            System.out.println();
        }
        House.sortHouselist();
    }

    public void setId(String id){
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        while (!check){
            matcher = patternHouse.matcher(id);
            if(!matcher.matches()) {
                System.out.println("Input ID (format: SVHO-XXXX): ");
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
        return "House info:" +
                "\n1. ID:" + this.getId() +
                "\n2. Name: " + this.getName() +
                "\n3. Area: " + this.getArea() +
                "\n4. Fee: " + this.getFee() +
                "\n5. Max capacity: " + this.getMaxPeople() +
                "\n6. Rent type: " + this.getRentType() +
                "\n7. House quality: " + this.houseQuality +
                "\n8. Additional services: " + this.houseAdditionalServices +
                "\n9. Number of floors: " + this.houseFloors;
    }

    public static void sortHouselist(){
        Collections.sort(houseArrayList, new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
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
                "," + this.houseQuality +
                "," + this.houseAdditionalServices +
                "," + this.houseFloors + "\n";
    }
}