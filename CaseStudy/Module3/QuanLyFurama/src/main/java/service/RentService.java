package service;

import model.services.House;
import model.services.Room;
import model.services.Service;
import model.services.Villa;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RentService {
    void insertVilla(Villa Villa);

    Service selectVilla(int id);

    void insertHouse(House house);

    Service selectHouse(int id);

    void insertRoom(Room room);

    Service selectRoom(int id);

    ArrayList<Service> selectAllService() throws SQLException;

    boolean deleteService(int id) throws SQLException;

    boolean updateVilla(Villa villa) throws SQLException;

    boolean updateHouse(House house) throws SQLException;

    boolean updateRoom(Room room) throws SQLException;

    ArrayList<Service> searchServices(String name) throws SQLException;
    ArrayList<Service> sortServices() throws SQLException;
}
