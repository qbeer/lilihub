package Book;

import Book.Book;


public interface BookService{
    public void addBook(Book book);
    public Book[] getAllBook();
    public Book getBookByISBN(String isbn);
}