package data;

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
        return getUser(username, query);
    }

    @Override
    public User findByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        return getUser(email, query);
    }

    private User getUser(String queryParam, String query) {
        ResultSet rs;
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, queryParam);
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

    @Override
    public int delete(long id) {
        //TODO: Decide if you want to implement this for admins
        return 0;
    }

    @Override
    public int update(User user) {
        try {
            String query = "Update users SET email = ?, password = ?, username = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getUsername());
            statement.setLong(4, user.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
