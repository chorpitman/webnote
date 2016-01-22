package com.epam.note.dao.impl;

import com.epam.note.dao.IUserDao;
import com.epam.note.model.User;
import com.epam.note.model.UserRole;
import com.epam.note.type.Role;
import com.epam.note.util.SQLCloser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {

    private final static String SELECT_ALL_USER = "SELECT * FROM user";
    private final static String SELECT_USER = "SELECT u.id, u.login, u.password, r.id, r.role " +
            "FROM user u JOIN role r ON u.role_id = r.id WHERE id = ?";
    private final static String INSERT = "INSERT INTO user (login, password, role_id) VALUES (?, ?, ?)";
    private final static String DELETE = "DELETE FROM user WHERE id = ?";
    private final static String UPDATE = "UPDATE user SET login = ?, password = ?, role_id = ? WHERE id = ?";

    private Connection connection;

    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_USER);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLCloser.close(resultSet);
            SQLCloser.close(statement);
        }
        return userList;
    }

    @Override
    public void addUser(User user) {
        PreparedStatement preparedStatement = null;
        Role role;
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getRole().getId());
//            //TODO Ask Alexnder about set last parametr (Enum)
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLCloser.close(preparedStatement);
        }
    }

    @Override
    public void delUser(int userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLCloser.close(preparedStatement);
        }
    }

    @Override
    public void update(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLCloser.close(preparedStatement);
        }
    }

    @Override
    public User getById(int id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement(SELECT_USER);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("u.id"));
                user.setLogin(resultSet.getString("u.login"));
                user.setPassword(resultSet.getString("u.password"));
                UserRole role = new UserRole();
                role.setId(resultSet.getInt("r.id"));
                role.setRole(Role.valueOf(resultSet.getString("r.role")));
                user.setRole(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLCloser.close(resultSet);
            SQLCloser.close(preparedStatement);
        }
        return user;
    }
}
