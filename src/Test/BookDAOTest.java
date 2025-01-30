package Test;

import entity.Book;
import repository.BookDAO;
import org.junit.jupiter.api.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BookDAOTest {
    private static BookDAO bookDAO;

    @BeforeAll
    static void setup() {
        bookDAO = new BookDAO();
    }

    @Test
    void testCreateBook() {
        Book book = new Book(0, "Test Book", LocalDate.of(2024, 1, 30), 1);
        assertDoesNotThrow(() -> bookDAO.create(book));
    }

    @Test
    void testUpdateBook() {
        Book book = new Book(1, "Updated Book", LocalDate.of(2024, 2, 1), 1);
        assertDoesNotThrow(() -> bookDAO.update(book));
    }

    @Test
    void testDeleteBook() {
        assertDoesNotThrow(() -> bookDAO.delete(1));
    }
}
