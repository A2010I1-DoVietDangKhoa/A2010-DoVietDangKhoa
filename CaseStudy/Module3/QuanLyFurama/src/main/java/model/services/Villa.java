package model.services;

public class Villa extends Service{
    private String roomStandard;
    private String otherConvenience;
    private double poolArea;
    private int floors;

    public Villa(int id, String name, double area, long cost, int maxPeople, String rentType, String roomStandard, String otherConvenience, double poolArea, int floors) {
        super(id, name, area, cost, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.otherConvenience = otherConvenience;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public Villa() {
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherConvenience() {
        return otherConvenience;
    }

    public void setOtherConvenience(String otherConvenience) {
        this.otherConvenience = otherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }
}
