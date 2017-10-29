package service.layer;

import model.Book;

public interface BookService {
    Book[] getAllBook();
    void addBook(Book book);
    Book getBookByISBN(String ISBN);
}
