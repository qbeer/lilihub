
package author;

public class NoAuthorException extends Exception{
    private final Author author;

    public NoAuthorException() {
        this.author = null;
    }

    public Author getAuthor() {
        return author;
    }
    
    
}
