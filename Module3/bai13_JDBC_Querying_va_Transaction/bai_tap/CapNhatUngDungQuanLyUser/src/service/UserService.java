package service;

import model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserService {
    void insertUser(User user) throws SQLException;

    User selectUser(int id);

    List<User> selectAllUsers() throws SQLException;

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    ArrayList<User> searchUsers(String name) throws SQLException;
    ArrayList<User> sortUsers() throws SQLException;
}