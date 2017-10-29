package model;

public class Book {
    private String title;
    private String ISBN;
    private int authorID;

    public Book(String title, String ISBN, int authorID) {
        this.title = title;
        this.ISBN = ISBN;
        this.authorID = authorID;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getAuthorID() {
        return authorID;
    }

    @Override
    public String toString() {
        return "[" + this.title + ", " + this.ISBN + ", " + this.authorID + "]";
    }
}
