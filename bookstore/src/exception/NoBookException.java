package exception;

public class NoBookException extends Exception {
    private String isbn;

    public NoBookException() {}
    public NoBookException(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
