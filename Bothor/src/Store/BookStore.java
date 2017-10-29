package Store;

import Exceptions.InvalidIsbnException;
import Exceptions.NoBookByIsbnException;

public interface BookStore {

    Book getBookByIsbn(String isbn) throws NoBookByIsbnException;
    void addBook(Book newBook) throws InvalidIsbnException;

}
