package service;

import exception.InvalidIsbnException;
import exception.NoBookException;
import model.Book;
import service.layer.BookService;
import store.FileBookStore;
import store.layer.BookStore;

public class MainBookService implements BookService {

    private BookStore bookStore;

    public MainBookService(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    @Override
    public Book[] getAllBook() {
        Book[] books = null;

        try {
            books = bookStore.getAllBook();
        } catch (NoBookException e) {
            System.out.println("There are no books to list.");
        }

        return books;
    }

    @Override
    public void addBook(Book book) {

        try {
            bookStore.addBook(book);
        } catch (InvalidIsbnException e) {
            System.out.println(e.getIsbn() + " ISBN number already exists.");
        }

    }

    @Override
    public Book getBookByIsbn(String isbn) {

        Book book = null;

        try {
            book = bookStore.getBookByIsbn(isbn);
        } catch (NoBookException e) {
            System.out.println(e.getIsbn() + " ISBN number not exists.");
        }

        return book;

    }
}
