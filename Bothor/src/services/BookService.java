package services;

import exceptions.InvalidIsbnException;
import exceptions.NoBookByIsbnException;
import exceptions.NoBooksException;
import store.Book;

public interface BookService {

    Book[] getAllBooks() throws NoBookByIsbnException, NoBooksException;
    void addBook(Book newBook) throws InvalidIsbnException;
    Book getBookByIsbn(String isbn) throws NoBookByIsbnException;

}
