package book;

public interface BookService{
     void addBook(Book book);
     Book[] getAllBook();
     Book getBookByIsbn(String isbn);
}