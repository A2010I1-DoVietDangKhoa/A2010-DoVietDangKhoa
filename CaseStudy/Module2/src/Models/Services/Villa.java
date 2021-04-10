package Models.Services;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Villa extends Service {
    private String villaQuality;
    private String villaAdditionalServices;
    private double poolArea;
    private int villaFloors;
    public static ArrayList<Villa> villaArrayList = new ArrayList<Villa>();
    private Pattern patternVilla = Pattern.compile("(SVVL)(-)[\\d]{4}");
    private Pattern patternName = Pattern.compile("^[A-Z].*");
    Scanner scanner = new Scanner(System.in);

    public Villa(){

    }

    public Villa(String villaQuality, String villaAdditionalServices, double poolArea, int villaFloors) {
        this.villaQuality = villaQuality;
        this.villaAdditionalServices = villaAdditionalServices;
        this.poolArea = poolArea;
        this.villaFloors = villaFloors;
    }

    public Villa(String id, String name, double area, long fee, int maxPeople, String rentType,
                 String villaQuality, String villaAdditionalServices, double poolArea, int villaFloors) {
        super(id, name, area, fee, maxPeople, rentType);
        this.villaQuality = villaQuality;
        this.villaAdditionalServices = villaAdditionalServices;
        this.poolArea = poolArea;
        this.villaFloors = villaFloors;
    }

    public String getVillaQuality() {
        return this.villaQuality;
    }

    public void setVillaQuality(String villaQuality) {
        Matcher matcher;
        boolean check = false;
        while (!check){
            matcher = patternName.matcher(villaQuality);
            if(!matcher.matches()) {
                System.out.println("Input villa quality (capitalize the first letter): ");
                villaQuality = scanner.nextLine();
            }
            else {
                check = true;
            }
        }
        this.villaQuality = villaQuality;
    }

    public String getVillaAdditionalServices() {
        return this.villaAdditionalServices;
    }

    public void setVillaAdditionalServices(String villaAdditionalServices) {
        this.villaAdditionalServices = villaAdditionalServices;
    }

    public double getPoolArea() {
        return this.poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getVillaFloors() {
        return this.villaFloors;
    }

    public void setVillaFloors(int villaFloors) {
        this.villaFloors = villaFloors;
    }

//    public static List<String> readFile(String path) {
//        List<String> list = new ArrayList<>();
//        try {
//            FileReader fileReader = new FileReader(path);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line = null;
//            while ((line = bufferedReader.readLine()) != null) {
//                list.add(line);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return list;
//    }

    public static void writeVilla(Villa villa){
        try {
            FileWriter myWriter =
                    new FileWriter("D:/A2010-DoVietDangKhoa/CaseStudy/Module2/src/Data/Villa.csv", true);
            myWriter.write(villa.toString());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readVilla() {
        //villaArrayList.clear();
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader =
                    new FileReader("D:/A2010-DoVietDangKhoa/CaseStudy/Module2/src/Data/Villa.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if(!list.isEmpty()){
            String[] arrayVilla = null;
            for (String i : list) {
                arrayVilla = i.split(",");
                Villa villa = new Villa();
                villa.setId(arrayVilla[0]);
                villa.setName(arrayVilla[1]);
                villa.setArea(Double.parseDouble(arrayVilla[2]));
                villa.setFee(Long.parseLong(arrayVilla[3]));
                villa.setMaxPeople(Integer.parseInt(arrayVilla[4]));
                villa.setRentType(arrayVilla[5]);
                villa.setVillaQuality(arrayVilla[6]);
                villa.setVillaAdditionalServices(arrayVilla[7]);
                villa.setPoolArea(Double.parseDouble(arrayVilla[8]));
                villa.setVillaFloors(Integer.parseInt(arrayVilla[9]));
                villaArrayList.add(villa);
            }
        }
        else {
            System.out.println();
        }
        Villa.sortVillaList();
    }

//    public static void readVilla(List<String> list) {
//        //List<String> list = readFile(path);
//        String[] arrayVilla = null;
//        for (String i : list) {
//            arrayVilla = i.split(",");
//            Villa villa = new Villa();
//            villa.setId(arrayVilla[0]);
//            villa.setArea(Double.parseDouble(arrayVilla[1]));
//            villa.setFee(Long.parseLong(arrayVilla[2]));
//            villa.setMaxPeople(Integer.parseInt(arrayVilla[3]));
//            villa.setRentType(arrayVilla[4]);
//            villa.setVillaQuality(arrayVilla[5]);
//            villa.setVillaAdditionalServices(arrayVilla[6]);
//            villa.setPoolArea(Double.parseDouble(arrayVilla[7]));
//            villa.setVillaFloors(Integer.parseInt(arrayVilla[8]));
//            villaArrayList.add(villa);
//        }
//    }
    public void setId(String id){
        Scanner scanner = new Scanner(System.in);
        Matcher matcher;
        boolean check = false;
        while (!check){
            matcher = patternVilla.matcher(id);
            if (!matcher.matches()) {
                System.out.println("Input ID (format: SVVL-XXXX with X being a number from 0-9): ");
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
        return "Villa info:" +
                "\n1. ID: " + this.getId() +
                "\n2. Name: " + this.getName() +
                "\n3. Area: " + this.getArea() +
                "\n4. Fee: " + this.getFee() +
                "\n5. Max capacity: " + this.getMaxPeople() +
                "\n6. Rent type: " + this.getRentType() +
                "\n7. Villa quality: " + this.villaQuality +
                "\n8. Additional services: " + this.villaAdditionalServices +
                "\n9. Pool's area: " + this.poolArea +
                "\n10. Number of floors: " + this.villaFloors;
    }

    public static void sortVillaList(){
        Collections.sort(villaArrayList, new Comparator<Villa>() {
            @Override
            public int compare(Villa o1, Villa o2) {
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
                "," + this.villaQuality +
                "," + this.villaAdditionalServices +
                "," + this.poolArea +
                "," + this.villaFloors + "\n";
    }
}
