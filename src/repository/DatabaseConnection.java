package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final String jdbcUrl = DatabaseConfig.getDbUrl();
    private final String  user = DatabaseConfig.getDbUsername();
    private final String  password = DatabaseConfig.getDbPassword();
    public Connection getConnection(){
        Connection conn = null;
        try {
            // Open a connection
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(jdbcUrl, user, password);

        } catch (SQLException  e) {
            System.err.println(e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}