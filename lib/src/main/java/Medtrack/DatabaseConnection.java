package Medtrack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    private final String url = "jdbc:postgresql://localhost:5432/medtrack";
    private final String username = "medtrack";
    private final String password = "password";
    private static Connection connection;
    
    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static DatabaseConnection instance = new DatabaseConnection();

    public static DatabaseConnection getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
