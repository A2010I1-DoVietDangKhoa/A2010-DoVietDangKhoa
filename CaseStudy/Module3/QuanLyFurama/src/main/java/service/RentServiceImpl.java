package service;

import model.services.House;
import model.services.Room;
import model.services.Service;
import model.services.Villa;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentServiceImpl implements RentService{
    private BaseRepository baseRepository = new BaseRepository();
    private Connection connection = baseRepository.getConnection();

    @Override
    public void insertVilla(Villa Villa) {

    }

    @Override
    public Service selectVilla(int id) {
        return null;
    }

    @Override
    public void insertHouse(House house) {

    }

    @Override
    public Service selectHouse(int id) {
        return null;
    }

    @Override
    public void insertRoom(Room room) {

    }

    @Override
    public Service selectRoom(int id) {
        return null;
    }

    @Override
    public ArrayList<Service> selectAllService() throws SQLException {
        return null;
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateVilla(Villa villa) throws SQLException {
        return false;
    }

    @Override
    public boolean updateHouse(House house) throws SQLException {
        return false;
    }

    @Override
    public boolean updateRoom(Room room) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<Service> searchServices(String name) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Service> sortServices() throws SQLException {
        return null;
    }
}
