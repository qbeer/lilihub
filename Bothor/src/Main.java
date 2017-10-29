import Exceptions.InvalidIdException;
import Exceptions.InvalidIsbnException;
import Exceptions.NoAuthorByIdException;
import Exceptions.NoBookByIsbnException;
import Services.AuthorServiceImpl;
import Services.BookServiceImpl;
import Store.Author;
import Store.Book;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book("ISBN-9789989153822", "Norwegian Wood", 1);
        Book book2 = new Book("ISBN-9780571315031", "The Buried Giant", 2);
        Book book3 = new Book("ISBN-9780571315032", "Kafka on the Shore", 1);
        Author author1 = new Author(1, "Haruki", "Murakami", 1949);
        Author author2 = new Author(2, "Kazuo", "Ishiguro", 1954);

        Path currentRelativePath = Paths.get("");
        String absolutePath = currentRelativePath.toAbsolutePath().toString();

        BookServiceImpl bookService1 = new BookServiceImpl(absolutePath);
        AuthorServiceImpl authorService1 = new AuthorServiceImpl(absolutePath);

        try {
            bookService1.addBook(book1);
        }catch (InvalidIsbnException e){
            System.out.println("Invalid ISBN, couldn't add books.");
        }

        try {
            bookService1.addBook(book2);
        }catch (InvalidIsbnException e){
            System.out.println("Invalid ISBN, couldn't add books.");
        }

        try {
            bookService1.addBook(book3);
        }catch (InvalidIsbnException e){
            System.out.println("Invalid ISBN, couldn't add books.");
        }

        try{
            authorService1.addAuthor(author1);
        }catch (InvalidIdException e){
            System.out.println("Invalid ID, couldn't add authors.");
        }

        try{
            authorService1.addAuthor(author2);
        }catch (InvalidIdException e){
            System.out.println("Invalid ID, couldn't add authors.");
        }

        try{
            System.out.println("***********************************");
            for(Author author : authorService1.getAllAuthors()){
                System.out.println(author);
            }
            System.out.println("***********************************\n");
        }catch (NoAuthorByIdException e){
            System.out.println("Couldn't output all authors, there are none.");
        }

        try{
            System.out.println("***********************************");
            for(Book book : bookService1.getAllBooks()){
                System.out.println(book);
            }
            System.out.println("***********************************\n");
        }catch (NoBookByIsbnException e){
            System.out.println("Couldn't output all books, there are none.");
        }

        try{
            System.out.println("*************************************");
            System.out.println(bookService1.getBookByIsbn("ISBN-9780571315031"));
            System.out.println("*************************************\n");
        }catch (NoBookByIsbnException e){
            System.out.println("There's no book with the provided ISBN.");
        }

        try{
            System.out.println("*************************************");
            System.out.println(authorService1.getAuthorById(1));
            System.out.println("*************************************\n");
        }catch (NoAuthorByIdException e){
            System.out.println("There's no author with the provided ID.");
        }

    }

}
