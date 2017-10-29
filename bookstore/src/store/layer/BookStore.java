package store.layer;

import exception.InvalidISBNException;
import exception.NoBookException;
import model.Book;

public interface BookStore {
    Book[] getAllBook() throws NoBookException;
    void addBook(Book book) throws InvalidISBNException;
    Book getBookByISBN(String ISBN) throws NoBookException;
}
