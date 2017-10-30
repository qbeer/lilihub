
package book;

public class NoBookException extends Exception{
   private final Book book;

    public NoBookException() {
        this.book = null;
    }

    public Book getBook() {
        return book;
    }
    
}
