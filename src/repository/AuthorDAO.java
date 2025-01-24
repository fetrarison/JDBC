package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthorDAO {
    DB db = new DB();
    Connection conn = db.getConnection();

    public void create(String name, String email) {
        String sql = "INSERT INTO author (name, email) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("Author created successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void readAll() {
        String sql = "SELECT * FROM author";
        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Email: %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void update(int id, String name, String email) {
        String sql = "UPDATE author SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = db.getConncetion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Author updated successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM author WHERE id = ?";
        try (Connection conn = DB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Author deleted successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
