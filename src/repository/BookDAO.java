package repository;

import entity.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookDAO {
    DatabaseConnection db = new DatabaseConnection();
    Connection conn = db.getConnection();

    public void create(Book book) {
        String sql = "INSERT INTO book (title, published_date, author_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setObject(2, book.getPublishedDate());
            stmt.setInt(3, book.getAuthorId());
            stmt.executeUpdate();
            System.out.println("Book created successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void update(Book book) {
        String sql = "UPDATE book SET title = ?, published_date = ?, author_id = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setObject(2, book.getPublishedDate());
            stmt.setInt(3, book.getAuthorId());
            stmt.setInt(4, book.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Book updated successfully.");
            } else {
                System.out.println("No book found with the given ID.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM book WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("No book found with the given ID.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
