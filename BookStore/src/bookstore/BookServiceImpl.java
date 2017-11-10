
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PNMINH
 */
public class BookServiceImpl implements BookService {

    private FileBookStore bookStore;

    public BookServiceImpl() {
    }

    @Override
    public Book[] getAllBook() throws NullPointerException {
        File bookFolder = new File("books");
        String[] bookList = bookFolder.list();
        Book[] allBook = new Book[bookList.length];
        try{
            for(int i=0;i<allBook.length;i++){
                allBook[i] = bookStore.getBookByISBN(bookList[i]);
            }
        }
        catch(NoBookException e){
            System.out.println(e.getMessage());
        }
        catch(NullPointerException e){
            System.out.println("There is no book in the store");
        }
        return allBook;
    }

    @Override
    public void addBook(Book newBook) {
        try {
            bookStore.addBook(newBook);
        } catch (InValidISBNException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public Book getBookByISBN(String isbn) {
        Book foundBook = null;
        try {
            foundBook =  bookStore.getBookByISBN(isbn);
        } catch (NoBookException e) {
            System.out.println(e.getMessage());
        }
        return foundBook;
    }

    /**
     * @return the bookStore
     */
}
