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

    public void update(Author author) {
        String sql = "UPDATE author SET name = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, author.getName());
            stmt.setString(2, author.getEmail());
            stmt.setInt(3, author.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Author updated successfully.");
            } else {
                System.out.println("No author found with the given ID.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM author WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Author deleted successfully.");
            } else {
                System.out.println("No author found with the given ID.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
