package entity;

import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private LocalDate publishedDate;
    private int authorId;

    public Book() {}

    public Book(int id, String title, LocalDate publishedDate, int authorId) {
        this.id = id;
        this.title = title;
        this.publishedDate = publishedDate;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
