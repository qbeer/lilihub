package Book;

import Book.Book;

public interface BookStore{
    public void addBook(Book book)throws InvalidIsbnException;
    public Book getBookByISBN(String isbn)throws NoBookException; 
    public Book[] getAllBook()throws NoBookException;
}