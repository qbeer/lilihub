package store;

import exception.InvalidISBNException;
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
            books[i] = getBookByISBN(folderNames[i].getName());
        }

        return books;

    }

    @Override
    public void addBook(Book book) throws InvalidISBNException {

        if (new File("saved/book/" + book.getISBN()).exists()) {
            throw new InvalidISBNException(book.getISBN());
        }

        File bookFile = new File("saved/book/" + book.getISBN() + "/book.txt");
        bookFile.getParentFile().mkdirs();

        try (PrintWriter printWriter = new PrintWriter(bookFile)) {
            printWriter.println(book.getTitle());
            printWriter.println(book.getISBN());
            printWriter.println(book.getAuthorID());
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }

    @Override
    public Book getBookByISBN(String ISBN) throws NoBookException {

        try (Scanner scanner = new Scanner(new File("saved/book/" + ISBN + "/book.txt"))) {
            Book book = new Book(scanner.nextLine(), scanner.nextLine(), Integer.parseInt(scanner.nextLine()));
            return book;
        } catch (FileNotFoundException e) {
            throw new NoBookException(ISBN);
        }

    }
}
