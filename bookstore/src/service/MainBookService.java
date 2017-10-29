package service;

import exception.InvalidISBNException;
import exception.NoBookException;
import model.Book;
import service.layer.BookService;
import store.FileBookStore;

public class MainBookService implements BookService {

    private FileBookStore fileBookStore = new FileBookStore();

    @Override
    public Book[] getAllBook() {
        Book[] books = null;

        try {
            books = fileBookStore.getAllBook();
        } catch (NoBookException e) {
            System.out.println("There are no books to list.");
        }

        return books;
    }

    @Override
    public void addBook(Book book) {

        try {
            fileBookStore.addBook(book);
        } catch (InvalidISBNException e) {
            System.out.println(e.getIsbn() + " ISBN number already exists.");
        }

    }

    @Override
    public Book getBookByISBN(String ISBN) {

        Book book = null;

        try {
            book = fileBookStore.getBookByISBN(ISBN);
        } catch (NoBookException e) {
            System.out.println(e.getISBN() + " ISBN number not exists.");
        }

        return book;

    }
}
