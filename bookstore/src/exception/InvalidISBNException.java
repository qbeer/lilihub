package exception;

public class InvalidISBNException extends Exception {
    private String ISBN;

    public InvalidISBNException(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getIsbn() {
        return ISBN;
    }
}
