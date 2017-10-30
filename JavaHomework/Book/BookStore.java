package book;

interface BookStore{
     void addBook(Book book)throws InvalidIsbnException;
     Book getBookByIsbn(String isbn)throws NoBookException; 
     Book[] getAllBook()throws NoBookException;
}