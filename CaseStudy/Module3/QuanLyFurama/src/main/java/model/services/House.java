package model.services;

public class House extends Service{
    private String roomStandard;
    private String otherConvenience;
    private int floors;

    public House(int id, String name, double area, long cost, int maxPeople, String rentType,
                 String roomStandard, String otherConvenience, int floors) {
        super(id, name, area, cost, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.otherConvenience = otherConvenience;
        this.floors = floors;
    }

    public House() {
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

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }
}
