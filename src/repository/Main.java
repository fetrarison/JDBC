package repository;
import entity.Book;
import entity.Author;

public class Main {
    public static void main(String[] args){
        AuthorDAO authorDAO = new AuthorDAO();
        authorDAO.create(new Author(1, "test", "test@gmail.com"));
    }
}