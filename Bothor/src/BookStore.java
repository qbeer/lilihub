import java.io.FileNotFoundException;

public interface BookStore {

    Book getBookByIsbn(String isbn) throws NoBookByIsbnException;
    void addBook(Book b) throws InvalidIsbnException;

}
