package service;

import model.Flat;
import repository.BaseRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class FlatServiceImpl implements FlatService{
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public void insertFlat(Flat flat) {
        baseRepository.insertFlat(flat);
    }

    @Override
    public Flat selectFlat(int id) {
        return baseRepository.selectById(id);
    }

    @Override
    public ArrayList<Flat> selectAll() throws SQLException {
        return baseRepository.selectAll();
    }

    @Override
    public boolean deleteFlat(int id) throws SQLException {
        boolean rowDeleted = baseRepository.deleteFlat(id);
        return rowDeleted;
    }

    @Override
    public boolean updateFlat(Flat flat) throws SQLException {
        boolean rowUpdated = baseRepository.updateFlat(flat);
        return rowUpdated;
    }

    @Override
    public ArrayList<Flat> searchFlatByType(String type) throws SQLException {
        return baseRepository.searchFlatByType(type);
    }

    @Override
    public ArrayList<Flat> searchFlatByPrice(double price) throws SQLException {
        return baseRepository.searchFlatByPrice(price);
    }

    @Override
    public ArrayList<Flat> searchFlatByFloor(int floor) throws SQLException {
        return baseRepository.searchFlatByFloor(floor);
    }
}
