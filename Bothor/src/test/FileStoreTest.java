package test;

import exceptions.*;
import services.*;
import store.Author;
import store.Book;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileStoreTest {

    public static void main(String[] args) throws InvalidIsbnException, InvalidIdException, NoAuthorsException, NoBooksException, NoAuthorByIdException, NoBookByIsbnException {

        Book book1 = new Book("ISBN-9789989153822", "Norwegian Wood", 1);
        Book book2 = new Book("ISBN-9780571315031", "The Buried Giant", 2);
        Book book3 = new Book("ISBN-9780571315032", "Kafka on the Shore", 1);
        Author author1 = new Author(1, "Haruki", "Murakami", 1949);
        Author author2 = new Author(2, "Kazuo", "Ishiguro", 1954);

        Path currentRelativePath = Paths.get("");
        String absolutePath = currentRelativePath.toAbsolutePath().toString();

        BookServiceImpl bookService = new BookServiceImpl(new FileBookStore(absolutePath));
        AuthorServiceImpl authorService = new AuthorServiceImpl(new FileAuthorStore(absolutePath));

        addBook(bookService, book1);
        addBook(bookService, book1); // Book is already in the database.
        addBook(bookService, book2);
        addBook(bookService, book3);

        addAuthor(authorService, author1);
        addAuthor(authorService, author2);
        addAuthor(authorService, author1); // Author is already in the database.

        Author[] authors = authorService.getAllAuthors();
        for(Author author : authors){
            System.out.println(author);
        }

        System.out.println("\n*******************************************************\n");

        Book[] books = bookService.getAllBooks();
        for(Book book : books){
            System.out.println(book);
        }

        System.out.println("\n*******************************************************\n");

        getAuthorById(authorService,1);
        getAuthorById(authorService, 42); // NoAuthorByIdException

        System.out.println("\n*******************************************************\n");

        getBookByIsbn(bookService, "ISBN-9780571315032");
        getBookByIsbn(bookService, "Dummy-ISBN"); // NoBookByIsbnException


    }

    public static void getAuthorById(AuthorServiceImpl service, int id) throws NoAuthorByIdException{
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

    public static void addAuthor(AuthorServiceImpl service, Author author) throws InvalidIdException{
        try{
            service.addAuthor(author);
        }catch (InvalidIdException e){
            System.out.println("Author is already in the database.");
        }
    }

}
