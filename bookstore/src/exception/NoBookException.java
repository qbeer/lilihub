package exception;

public class NoBookException extends Exception {
    private String ISBN;

    public NoBookException() {}
    public NoBookException(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }
}
