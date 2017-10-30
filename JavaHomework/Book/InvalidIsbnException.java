
package Book;


public class InvalidIsbnException extends Exception {
    String isbn;

    public InvalidIsbnException(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
    
}
