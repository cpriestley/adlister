package services;

import configs.AdlisterConnection;
import models.User;

import java.sql.*;

public class MySQLUsersDao implements Users {

    private final Connection connection;

    public MySQLUsersDao(AdlisterConnection connection) {
        this.connection = connection.getConnection();
    }

    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        ResultSet rs;
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            rs = statement.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        ResultSet rs;
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            rs = statement.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users (email, password, username) VALUES (?, ?, ?)";
        ResultSet rs;
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getUsername());
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
