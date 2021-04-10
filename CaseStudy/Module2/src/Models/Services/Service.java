package Models.Services;

import java.util.Scanner;
import java.util.regex.*;

public abstract class Service{
    protected String id;
    protected String name;
    protected double area;
    protected long fee;
    protected int maxPeople;
    protected String rentType;
    protected Pattern patternName = Pattern.compile("^[A-Z].*");
    private Scanner scanner = new Scanner(System.in);

    public Service(){

    }

    public Service(String id, double area, long fee, int maxPeople, String rentType) {
    }

    public Service(String id, String name, double area, long fee, int maxPeople, String rentType) {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getArea() {
        return this.area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public long getFee() {
        return this.fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPeople() {
        return this.maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        while (maxPeople < 0 || maxPeople > 20){
            System.out.println("Must be an integer >0 and <=20: ");
            maxPeople = scanner.nextInt();
        }
        this.maxPeople = maxPeople;
    }

    public String getRentType() {
        return this.rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public static boolean isDouble(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean checkArea(String area){
        if(isDouble(area)){
            if (Double.parseDouble(area) >= 30){
                return true;
            }
            else
            return false;
        }
        else
            return false;
    }

    public static boolean checkFloors(String floor){
        if(isInteger(floor)){
            if (Integer.parseInt(floor) > 0){
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    public abstract String showInfo();

    @Override
    public String toString() {
        return "";
    }
}
