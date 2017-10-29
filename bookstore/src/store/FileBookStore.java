package store;

import exception.InvalidIsbnException;
import exception.NoBookException;

import model.Book;
import store.layer.BookStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileBookStore implements BookStore {

    private File mainStoragePath;

    public FileBookStore() {
        mainStoragePath = new File("saved/book/");
        mainStoragePath.mkdirs();
    }

    @Override
    public Book[] getAllBook() throws NoBookException {

        Book[] books = new Book[new File("saved/book/").listFiles().length];
        File[] folderNames = new File("saved/book/").listFiles();

        if(books.length == 0) throw new NoBookException();

        for (int i = 0; i < books.length; i++) {
            books[i] = getBookByIsbn(folderNames[i].getName());
        }

        return books;

    }

    @Override
    public void addBook(Book book) throws InvalidIsbnException {

        if (new File("saved/book/" + book.getIsbn()).exists()) {
            throw new InvalidIsbnException(book.getIsbn());
        }

        File bookFile = new File("saved/book/" + book.getIsbn() + "/book.txt");
        bookFile.getParentFile().mkdirs();

        try (PrintWriter printWriter = new PrintWriter(bookFile)) {
            printWriter.println(book.getTitle());
            printWriter.println(book.getIsbn());
            printWriter.println(book.getAuthorId());
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }

    @Override
    public Book getBookByIsbn(String isbn) throws NoBookException {

        try (Scanner scanner = new Scanner(new File("saved/book/" + isbn + "/book.txt"))) {
            Book book = new Book(scanner.nextLine(), scanner.nextLine(), Integer.parseInt(scanner.nextLine()));
            return book;
        } catch (FileNotFoundException e) {
            throw new NoBookException(isbn);
        }

    }
}
