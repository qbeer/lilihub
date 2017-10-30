
package main;

import Book.BookServiceImpl;
import Book.Book;
import Author.AuthorServiceImpl;
import Author.Author;
import java.io.File;

public class Main {

    public static void main(String[] args) {
      File dd = new File("authors");
      dd.mkdir();
      File ddd = new File("books");
      ddd.mkdir();
      AuthorServiceImpl service = new AuthorServiceImpl();
        Author a1 = new Author("123","James","Smith",1996);
        Author a2 = new Author("222","James","Smith",1996);
        Author a3 = new Author("333","James","Smith",1996);
        Author a4 = new Author("444","James","Smith",1996);
        Book b1 = new Book("000", "MyBook",a1);
        Book b2 = new Book("111", "MyBook2",a2);
        service.addAuthor(a1);
        BookServiceImpl service2 = new BookServiceImpl();
        service2.addBook(b1);
        service2.addBook(b2);
        //System.out.println(service2.getBookByISBN("000"));
        service.addAuthor(a2);
        service.addAuthor(a3);
        service.addAuthor(a4);
        //System.out.println(service.getAuthorByID("123"));
        Author[] array = new Author[service.getAllAuthor().length];
        array = service.getAllAuthor();
        for(int i=0; i<array.length;++i){
            System.out.println(array[i]);
        }
        Book[] bookArray = new Book[service2.getAllBook().length];
        bookArray = service2.getAllBook();
        for(int i=0; i<bookArray.length;++i){
            System.out.println(bookArray[i]);
        }
        
    }
    
}
