package model.services;

public class Room extends Service{
    private String attachService;

    public Room(int id, String name, double area, long cost, int maxPeople, String rentType, String attachService) {
        super(id, name, area, cost, maxPeople, rentType);
        this.attachService = attachService;
    }

    public Room() {
    }

    public String getAttachService() {
        return attachService;
    }

    public void setAttachService(String attachService) {
        this.attachService = attachService;
    }
}
