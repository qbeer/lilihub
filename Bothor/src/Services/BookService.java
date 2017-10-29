package Services;

import Exceptions.InvalidIsbnException;
import Exceptions.NoBookByIsbnException;
import Store.Book;

public interface BookService {

    Book[] getAllBooks() throws NoBookByIsbnException;
    void addBook(Book newBook) throws InvalidIsbnException;
    Book getBookByIsbn(String isbn) throws NoBookByIsbnException;

}
