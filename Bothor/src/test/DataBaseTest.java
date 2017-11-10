package test;

import exceptions.*;
import services.*;
import store.Author;
import store.Book;

public class DataBaseTest {

    public static void main(String[] args) throws NoBookByIsbnException, NoBooksException, InvalidIsbnException, InvalidIdException, NoAuthorsException, NoAuthorByIdException {

        BookServiceImpl bookService = new BookServiceImpl(new DatabaseBookStore());

        Book newBook = new Book("ISBN-9780571315032", "Kafka on the Shore", 1);

        getBookByIsbn(bookService, "ISBN-1234");

        System.out.println("******************************************\n");

        Book[] books = bookService.getAllBooks();
        for(Book book : books){
            System.out.println(book);
        }

        System.out.println("******************************************\n");

        addBook(bookService, newBook);

        books = bookService.getAllBooks();
        for(Book book : books){
            System.out.println(book);
        }

        Author newAuthor = new Author(3, "J.R.R.","Tolkien",1892);

        AuthorServiceImpl authorService = new AuthorServiceImpl(new DatabaseAuthorStore());

        System.out.println("\n******************************************\n");
        System.out.println("******************************************\n");

        Author[] authors = authorService.getAllAuthors();
        for(Author author : authors){
            System.out.println(author);
        }

        System.out.println("******************************************\n");

        addAuthor(authorService, newAuthor);

        authors = authorService.getAllAuthors();
        for(Author author : authors){
            System.out.println(author);
        }

        System.out.println("******************************************\n");

        getAuthorById(authorService, 3);

    }

    public static void getAuthorById(AuthorServiceImpl service, int id) throws NoAuthorByIdException {
        try{
            System.out.println(service.getAuthorById(id));
        }catch (NoAuthorByIdException e){
            System.out.println("No author by ID :: "+id);
        }
    }

    public static void getBookByIsbn(BookServiceImpl service, String isbn) throws NoBookByIsbnException{
        try{
            System.out.println(service.getBookByIsbn(isbn));
        }catch (NoBookByIsbnException e){
            System.out.println("No book by ISBN :: "+isbn);
        }
    }

    public static void addBook(BookServiceImpl service, Book book) throws InvalidIsbnException{
        try{
            service.addBook(book);
        }catch (InvalidIsbnException e){
            System.out.println("Book is already in the database.");
        }
    }

    public static void addAuthor(AuthorServiceImpl service, Author author) throws InvalidIdException {
        try{
            service.addAuthor(author);
        }catch (InvalidIdException e){
            System.out.println("Author is already in the database.");
        }
    }

}
