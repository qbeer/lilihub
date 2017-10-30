
package main;

import author.FileAuthorStore;
import book.FileBookStore;
import book.BookStore;
import author.AuthorStore;
import book.FileBookStore;
import book.BookService;
import author.AuthorService;
import book.BookServiceImpl;
import book.Book;
import author.AuthorServiceImpl;
import author.Author;
import java.io.File;

public class Main {

    public static void main(String[] args) {
      AuthorStore authorStore = new FileAuthorStore();
      BookStore bookStore = new FileBookStore();
      AuthorService authorService = new AuthorServiceImpl(authorStore);
      BookService bookService = new BookServiceImpl(bookStore);
        Author author1 = new Author("123","James","Smith",1996);
        Author author2 = new Author("222","James","Smith",1996);
        Author author3 = new Author("333","James","Smith",1996);
        Author author4 = new Author("444","James","Smith",1996);
        Book book1 = new Book("000", "MyBook",author1);
        Book book2 = new Book("111", "MyBook2",author2);
        authorService.addAuthor(author1);
        
        bookService.addBook(book1);
        bookService.addBook(book2);
        authorService.addAuthor(author2);
        authorService.addAuthor(author3);
        authorService.addAuthor(author4);
        Author[] array = new Author[authorService.getAllAuthor().length];
        array = authorService.getAllAuthor();
        for(int i=0; i<array.length;++i){
            System.out.println(array[i]);
        }
        Book[] bookArray = new Book[bookService.getAllBook().length];
        bookArray = bookService.getAllBook();
        for(int i=0; i<bookArray.length;++i){
            System.out.println(bookArray[i]);
        }
        
    }
    
}
