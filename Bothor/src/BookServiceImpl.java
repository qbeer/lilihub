import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private String srcDir;
    private static BookServiceImpl INSTANCE;

    private BookServiceImpl(String srcDir){
        this.srcDir = srcDir;
    }

    public static BookServiceImpl getInstance(String srcDir){
        if(INSTANCE == null){
            INSTANCE = new BookServiceImpl(srcDir);
        }
        return INSTANCE;
    }

    @Override
    public Book[] getAllBooks() throws NoBookByIsbnException {
        List<Book> books = new ArrayList<>();
        File[] files = new File(srcDir+"/books/").listFiles();
        for(File file : files){
            if(file.isDirectory()){
                books.add(FileBookStore.getInstance(srcDir).getBookByIsbn(file.getName()));
            }
        }
        Book[] booksArr = new Book[books.size()];
        booksArr = books.toArray(booksArr);
        return booksArr;
    }

    @Override
    public void addBook(Book b) throws InvalidIsbnException {
        FileBookStore.getInstance(srcDir).addBook(b);
    }

    @Override
    public Book getBookByIsbn(String isbn) throws NoBookByIsbnException {
        return FileBookStore.getInstance(srcDir).getBookByIsbn(isbn);
    }

}
