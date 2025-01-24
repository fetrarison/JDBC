package repository;
import entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDAO {
    DatabaseConnection db = new DatabaseConnection();
    Connection conn = db.getConnection();

    public void create(Author author) {
        String sql = "INSERT INTO author (name, email) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, author.getName());
            stmt.setString(2, author.getEmail());
            stmt.executeUpdate();
            System.out.println("Author created successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
