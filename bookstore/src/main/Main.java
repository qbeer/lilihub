package main;

import model.Author;
import model.Book;
import service.MainAuthorService;
import service.MainBookService;
import store.FileAuthorStore;
import store.FileBookStore;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MainAuthorService authorService = new MainAuthorService(new FileAuthorStore());
        MainBookService bookService = new MainBookService(new FileBookStore());

        Author author = new Author(1, "Aut", "Hor", 1990);
        Book book1 = new Book("Book1", "1234", 1);
        Book book2 = new Book("Book2", "5678", 1);

        authorService.addAuthor(author);
        bookService.addBook(book1);
        bookService.addBook(book2);

        Book invalidBook = bookService.getBookByIsbn("0000");
        Author invalidAuthor = authorService.getAuthorById(0);

        Author[] authors = authorService.getAllAuthor();
        if (authors != null) {
            System.out.println(Arrays.toString(authors));
        }

        Book[] books = bookService.getAllBook();
        if (books != null) {
            System.out.println(Arrays.toString(books));
        }


    }
}
