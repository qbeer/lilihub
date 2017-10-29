package model;

public class Book {
    private String title;
    private String isbn;
    private int authorId;

    public Book(String title, String isbn, int authorId) {
        this.title = title;
        this.isbn = isbn;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAuthorId() {
        return authorId;
    }

    @Override
    public String toString() {
        return "[" + this.title + ", " + this.isbn + ", " + this.authorId + "]";
    }
}
