package exception;

public class InvalidIsbnException extends Exception {
    private String isbn;

    public InvalidIsbnException(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
