package data;

import configs.AdlisterConnection;
import models.Ad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsRepositoryDao implements AdsRepository {

    private final Connection connection;

    public MySQLAdsRepositoryDao(AdlisterConnection connection) {
        this.connection = connection.getConnection();
    }


    @Override
    public List<Ad> all() {
        String query = "SELECT * FROM ads";
        ResultSet rs;
        List<Ad> ads = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ads;
    }

    @Override
    public long insert(Ad ad) {
        String query = "INSERT INTO ads (user_id, title, description) VALUES (?, ?, ?)";
        ResultSet rs;
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, ad.getUserId());
            statement.setString(2, ad.getTitle());
            statement.setString(3, ad.getDescription());
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ad findAdById(long id) {
        Ad ad = null;
        try {
            String query = "SELECT * FROM ads WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                ad = new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ad;
    }

    @Override
    public int update(Ad ad) {
        try {
            String query = "Update ads SET title = ?, description = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, ad.getTitle());
            statement.setString(2, ad.getDescription());
            statement.setLong(3, ad.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(long id) {
        System.out.println("Deleted Ad: " + id);
        String query = "DELETE FROM ads WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ad> search(String[] searchTerms) {
        List<Ad> ads = new ArrayList<>();
        // Build the SQL query string with a variable number of parameter placeholders
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT * FROM ads WHERE ");
        for (int i = 0; i < searchTerms.length; i++) {
            sqlBuilder.append("(title LIKE ? OR description LIKE ?)");
            if (i < searchTerms.length - 1) {
                sqlBuilder.append(" AND ");
            }
        }
        String sql = sqlBuilder.toString();
        try {
            // Prepare the statement and set the parameter values for each search term
            PreparedStatement statement = connection.prepareStatement(sql);
            int parameterIndex = 1;
            for (String term : searchTerms) {
                String wildcardPattern = "%" + term + "%";
                statement.setString(parameterIndex++, wildcardPattern);
                statement.setString(parameterIndex++, wildcardPattern);
            }
            // Execute the query and process the results as needed
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ads.add(new Ad(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description")
                ));
            }

            // Remember to close the statement and result set when you're finished
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ads;
    }

    @Override
    public List<Ad> findAdsByUserId(long id) {
        List<Ad> ads = new ArrayList<>();
        try {
            String query = "SELECT * FROM ads WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ads;
    }
}
