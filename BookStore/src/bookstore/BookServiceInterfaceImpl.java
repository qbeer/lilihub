
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author PNMINH
 */
public class BookServiceInterfaceImpl implements BookServiceInterface {

    private FileBookStore bookStore;

    public BookServiceInterfaceImpl(int size) {
        bookStore = new FileBookStore(size);
    }

    @Override
    public Book[] getAllBook() {
        Book[] books = new Book[bookStore.getNumberOfBooks()];
        for (int i = 0; i < books.length; i++) {
            if (bookStore.getBooks()[i] != null) {
                books[i] = bookStore.getBooks()[i];
            }
        }
        return books;
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
            foundBook = bookStore.getBookByISBN(isbn);
        } catch (NoBookException e) {
            System.out.println(e.getMessage());
        }
        if (foundBook != null) {
            System.out.println("There's " + foundBook.getTitle() + " in the store");
        }
        return foundBook;
    }

    /**
     * @return the bookStore
     */
}
