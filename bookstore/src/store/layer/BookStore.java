package store.layer;

import exception.InvalidIsbnException;
import exception.NoBookException;
import model.Book;

public interface BookStore {
    Book[] getAllBook() throws NoBookException;
    void addBook(Book book) throws InvalidIsbnException;
    Book getBookByIsbn(String isbn) throws NoBookException;
}
