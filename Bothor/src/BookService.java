public interface BookService {

    Book[] getAllBooks() throws NoBookByIsbnException;
    void addBook(Book b) throws InvalidIsbnException;
    Book getBookByIsbn(String isbn) throws NoBookByIsbnException;

}
