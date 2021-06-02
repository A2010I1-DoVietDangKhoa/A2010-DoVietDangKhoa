package service;

import model.Flat;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FlatService {
    void insertFlat(Flat flat);

    Flat selectFlat(int id);

    ArrayList<Flat> selectAll() throws SQLException;

    boolean deleteFlat(int id) throws SQLException;

    boolean updateFlat(Flat flat) throws SQLException;

    ArrayList<Flat> searchFlatByType(String type) throws SQLException;

    ArrayList<Flat> searchFlatByPrice(double price) throws SQLException;

    ArrayList<Flat> searchFlatByFloor(int floor) throws SQLException;
}
