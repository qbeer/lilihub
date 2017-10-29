package Services;

import Exceptions.InvalidIsbnException;
import Exceptions.NoBookByIsbnException;
import Store.Book;
import Store.BookStore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private final String srcDir;
    private final BookStore store;

    public BookServiceImpl(String srcDir){
        this.srcDir = srcDir;
        store = new FileBookStore(srcDir);

    }

    @Override
    public Book[] getAllBooks() throws NoBookByIsbnException {
        List<Book> books = new ArrayList<>();
        File[] files = new File(srcDir+"/books/").listFiles();
        for(File file : files){
            if(file.isDirectory()){
                books.add(store.getBookByIsbn(file.getName()));
            }
        }
        Book[] booksArr = new Book[books.size()];
        booksArr = books.toArray(booksArr);
        return booksArr;
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
