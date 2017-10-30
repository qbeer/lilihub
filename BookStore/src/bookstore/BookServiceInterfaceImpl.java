
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
    /*public static FileBookStore getInstance(){
        if (bookStore == null){
            bookStore = new FileBookStore();
        }
        return bookStore;
    }*/

    public BookServiceInterfaceImpl() {
    }

    public BookServiceInterfaceImpl(FileBookStore bookStore) {
        this.bookStore = bookStore;
    }
    
    @Override
    public Book[] getAllBook(FileBookStore bookStore) {
        Book[] books = new Book[bookStore.getNumberOfBooks()];
        for(int i =0;i<books.length;i++){
            if (bookStore.getBooks()[i] != null) {
                books[i] = bookStore.getBooks()[i];
            }
        }
        return books;
    }

    @Override
    public void addBook(Book newBook) {
        try{
            getBookStore().addBook(newBook);
        }
        catch(InValidISBNException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Book getBookByISBN(String isbn) {
        Book foundBook = null;
        try {
            getBookStore().getBookByISBN(isbn);
            foundBook = getBookStore().getFoundBook();
        }        
        catch(noBookException e){
            System.out.println(e.getMessage());
        }
        return foundBook;
    }

    /**
     * @return the bookStore
     */
    public FileBookStore getBookStore() {
        return bookStore;
    }

    /**
     * @param bookStore the bookStore to set
     */
    public void setBookStore(FileBookStore bookStore) {
        this.bookStore = bookStore;
    }
    
}
