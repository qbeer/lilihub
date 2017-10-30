package services;

import exceptions.InvalidIsbnException;
import exceptions.NoBookByIsbnException;
import exceptions.NoBooksException;
import store.Book;
import store.BookStore;

public class BookServiceImpl implements BookService {

    private final BookStore store;

    public BookServiceImpl(BookStore store){
        this.store = store;
    }

    @Override
    public Book[] getAllBooks() throws NoBooksException {
        return store.getAllBooks();
    }

    @Override
    public void addBook(Book newBook) throws InvalidIsbnException {
        store.addBook(newBook);
    }

    @Override
    public Book getBookByIsbn(String isbn) throws NoBookByIsbnException {
        return store.getBookByIsbn(isbn);
    }

}