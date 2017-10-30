
package book;

public class InvalidIsbnException extends Exception {
    private final String isbn;

    public InvalidIsbnException(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
    
}
