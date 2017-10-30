
package Author;

import Author.Author;

public class NoAuthorException extends Exception{
    Author author;

    public NoAuthorException() {
        this.author = null;
    }

    public Author getAuthor() {
        return author;
    }
    
    
}
