package store;

import exceptions.InvalidIsbnException;
import exceptions.NoBookByIsbnException;
import exceptions.NoBooksException;

public interface BookStore {

    Book getBookByIsbn(String isbn) throws NoBookByIsbnException;
    void addBook(Book newBook) throws InvalidIsbnException;
    Book[] getAllBooks() throws NoBooksException;

}
