
package Book;

import Book.Book;

public class NoBookException extends Exception{
    Book book;

    public NoBookException() {
        this.book = null;
    }

    public Book getBook() {
        return book;
    }
    
}
