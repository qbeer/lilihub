
package Book;

import Book.BookService;
import Book.Book;

public class BookServiceImpl implements BookService {
    FileBookStore bookStore = new FileBookStore();
    @Override
    public void addBook(Book book){
        try{
            bookStore.addBook(book);
        }catch(InvalidIsbnException e){
            System.out.println(e.getIsbn()+ "book already exists!");
        }
        
    }
    @Override
    public Book getBookByISBN(String isbn){
        Book book = null;
       try{
            book = bookStore.getBookByISBN(isbn);
       }catch(NoBookException e){
        System.out.println("No book");
    }
       return book;
    }
    @Override
    public Book[] getAllBook(){
        Book[] allBook = null;
        try{
        allBook = bookStore.getAllBook();
        } catch (NoBookException e) {
            System.out.println("No book");
        }
        return allBook;
    }
}
