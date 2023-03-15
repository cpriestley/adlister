package configs;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdlisterConnection {

    private final Connection connection;

    public AdlisterConnection() {
        try {
            Config config = new Config();
            DriverManager.registerDriver(new Driver());
            connection = DriverManager
                    .getConnection(
                            config.getUrl(),
                            config.getUserName(),
                            config.getPassword());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
