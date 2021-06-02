package repository;

import model.Flat;

import java.sql.*;
import java.util.ArrayList;

public class BaseRepository {
    private Connection connection;
    private String jdbcURL = "jdbc:mysql://localhost:3306/final_exam";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Khoadvd48!";

    private static final String SELECT_ALL = "select * from flat order by area asc";

    private static final String SELECT_BY_ID = "select * from flat where id = ?";

    private static final String INSERT_NEW = "insert into flat(flat_code, `status`, area, floors, `type`," +
            " price, `description`, start_date, end_date)  values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String DELETE = "delete from flat where id = ?";

    private static final String UPDATE = "update flat \n" +
            "set flat_code = ?, `status` = ?, area = ?, floors = ?, `type` = ?, price = ?, `description` = ?, start_date = ?," +
            " end_date = ?\n" +
            "where id = ?";

    private static final String FIND_BY_TYPE = "select * from flat where type like " + '%' + '?' + '%';

    private static final String FIND_BY_FLOORS = "select * from flat where floors = ?";

    private static final String FIND_BY_PRICE = "select * from flat where price = ?";


    public BaseRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void insertFlat(Flat flat){
        try {
            connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, flat.getCode());
            preparedStatement.setString(2, flat.getStatus());
            preparedStatement.setDouble(3, flat.getArea());
            preparedStatement.setInt(4, flat.getFloors());
            preparedStatement.setString(5, flat.getType());
            preparedStatement.setDouble(6, flat.getPrice());
            preparedStatement.setString(7, flat.getDescription());
            preparedStatement.setString(8, flat.getStart());
            preparedStatement.setString(9, flat.getEnd());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Flat> selectAll(){
        ArrayList<Flat> flats = new ArrayList<>();
        try {
            connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Flat flat = new Flat();
                createFlatFromDB(flat, resultSet);
                flats.add(flat);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flats;
    }

    public Flat selectById(int id){
        Flat flat = new Flat();
        try {
            connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                createFlatFromDB(flat, resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flat;
    }


    private void createFlatFromDB(Flat flat, ResultSet resultSet) throws SQLException {
        flat.setId(resultSet.getInt("id"));
        flat.setCode(resultSet.getString("flat_code"));
        flat.setArea(resultSet.getDouble("area"));
        flat.setFloors(resultSet.getInt("floors"));
        flat.setStatus(resultSet.getString("status"));
        flat.setStart(resultSet.getString("start_date"));
        flat.setEnd(resultSet.getString("end_date"));
        flat.setType(resultSet.getString("type"));
        flat.setDescription(resultSet.getString("description"));
        flat.setPrice(resultSet.getDouble("price"));
    }

    public boolean deleteFlat(int id) throws SQLException {
        boolean rowDeleted = false;
        connection = this.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareCall(DELETE);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateFlat(Flat flat){
        boolean rowUpdated = false;
        try {
            connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, flat.getCode());
            preparedStatement.setString(2, flat.getStatus());
            preparedStatement.setDouble(3, flat.getArea());
            preparedStatement.setInt(4, flat.getFloors());
            preparedStatement.setString(5, flat.getType());
            preparedStatement.setDouble(6, flat.getPrice());
            preparedStatement.setString(7, flat.getDescription());
            preparedStatement.setString(8, flat.getStart());
            preparedStatement.setString(9, flat.getEnd());
            preparedStatement.setInt(10, flat.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    public ArrayList<Flat> searchFlatByType(String type) throws SQLException{
        ArrayList<Flat> flats = new ArrayList<>();
        connection = this.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_TYPE);
        preparedStatement.setString(1, type);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Flat flat = new Flat();
            createFlatFromDB(flat, resultSet);
            flats.add(flat);
        }
        return flats;
    };

    public ArrayList<Flat> searchFlatByPrice(double price) throws SQLException{
        ArrayList<Flat> flats = new ArrayList<>();
        connection = this.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_PRICE);
        preparedStatement.setDouble(1, price);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Flat flat = new Flat();
            createFlatFromDB(flat, resultSet);
            flats.add(flat);
        }
        return flats;
    };

    public ArrayList<Flat> searchFlatByFloor(int floor) throws SQLException{
        ArrayList<Flat> flats = new ArrayList<>();
        connection = this.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_FLOORS);
        preparedStatement.setInt(1, floor);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Flat flat = new Flat();
            createFlatFromDB(flat, resultSet);
            flats.add(flat);
        }
        return flats;
    };
}


