package service;

import model.User;
import repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private BaseRepository baseRepository = new BaseRepository();
    private Connection connection = baseRepository.getConnection();

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SEARCH_USER_MYSQL = "select * from users where country = ?";
    private static final String SORT_USERS_SQL = "select * from users ORDER BY name";

    public UserServiceImpl() {
    }

//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return connection;
//    }

    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

//    public List<User> selectAllUsers() {
//
//        // using try-with-resources to avoid closing resources (boiler plate code)
//        List<User> users = new ArrayList<>();
//        // Step 1: Establishing a Connection
//
//        try (
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                users.add(new User(id, name, email, country));
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return users;
//    }

    public List<User> selectAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        CallableStatement callableStatement = connection.prepareCall("{call get_all_user()}");
        ResultSet resultSet = callableStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            users.add(new User(id, name, email, country));
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            Connection connection = baseRepository.getConnection();
            //PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
            CallableStatement statement = connection.prepareCall("{call delete_user_by_id(?)}");
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("{call update_user_by_id(?, ?, ? ,?)}");
            //PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());

            rowUpdated = callableStatement.executeUpdate() > 0;
        }   catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public ArrayList<User> searchUsers(String searchName) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER_MYSQL);
        preparedStatement.setString(1, searchName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String userName = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            users.add(new User(id, userName, email, country));
        }
        return users;
    }

    public ArrayList<User> sortUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement  statement = connection.prepareStatement(SORT_USERS_SQL);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String userName = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            users.add(new User(id, userName, email, country));
        }
        return users;
    }

    public void addUserTransaction(User user, int[] permisions) {
        PreparedStatement preparedStatement = null;
        PreparedStatement pstmtAssignment = null;
        ResultSet rs = null;
        try {

            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            int rowAffected = preparedStatement.executeUpdate();
            rs = preparedStatement.getGeneratedKeys();
            int userId = 0;
            if (rs.next())
                userId = rs.getInt(1);

            if (rowAffected == 1) {


                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "

                        + "VALUES(?,?)";

                pstmtAssignment = connection.prepareStatement(sqlPivot);

                for (int permisionId : permisions) {
                    pstmtAssignment.setInt(1, userId);
                    pstmtAssignment.setInt(2, permisionId);
                    pstmtAssignment.executeUpdate();

                }

                connection.commit();

            } else {

                connection.rollback();

            }

        } catch (SQLException ex) {


            try {

                if (connection != null)

                    connection.rollback();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

            System.out.println(ex.getMessage());

        } finally {

            try {

                if (rs != null) rs.close();

                if (preparedStatement != null) preparedStatement.close();

                if (pstmtAssignment != null) pstmtAssignment.close();

                if (connection != null) connection.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

        }

    }

//    public void sortUsers() throws SQLException {
//        ArrayList<User> users = new ArrayList<>();
//        PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_SQL);
//        preparedStatement.executeQuery(SORT_USERS_SQL);
//    }
}

