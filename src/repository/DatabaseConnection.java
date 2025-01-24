import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private final string jdbcUrl = DatabaseConfig.getDbUrl();
    private final string  user = DatabaseConfig.getDbUsername();
    private final string  password = DatabaseConfig.getDbPassword();
    Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            // Open a connection
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(jdbcUrl, user, password);
            return conn;

        } catch (SQLException  e) {
            System.err.println(e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}