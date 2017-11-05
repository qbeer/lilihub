/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author PNMINH
 */
public class FileBookStore implements BookStore {

    private Book[] books;
    private int numberOfBooks;

    private void writeToFile(String fileName, Book currentBook) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        if (currentBook != null) {
            writer.write("Title: " + currentBook.getTitle() + " || ISBN: "
                    + currentBook.getIsbn() + " || Author ID: " + currentBook.getAuthorID() + "\n");
        }
        writer.close();
    }

    private void readFromFile(String fileName) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public FileBookStore(int size) {
        books = new Book[size];
        numberOfBooks = 0;
    }

    @Override
    public void addBook(Book newBook) throws InValidISBNException {
        if (!(newBook.getIsbn() instanceof String)) {
            throw new InValidISBNException("Not a valid ISBN");
        }
        if (getNumberOfBooks() >= getBooks().length) {
            System.out.println("Limit has reached.");
        }
        books[numberOfBooks] = newBook;
        numberOfBooks++;
        File bookFolder = new File("books/" + newBook.getIsbn());
        if (!bookFolder.exists()) {
            bookFolder.mkdirs();
        }
        try {
            writeToFile(bookFolder + "\\book.txt", newBook);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private int lookUpISBN(String isbn) {
        boolean contains = false;
        int index = 0;
        while (index < getBooks().length && !contains) {
            contains = (getBooks()[index].getIsbn().equals(isbn));
            index++;
        }
        index = (contains) ? index - 1 : -1;
        return index;
    }

    @Override
    public Book getBookByISBN(String isbn) throws NoBookException {
        int index = lookUpISBN(isbn);
        File path = new File("book/" + isbn);
        if (!path.exists()) {
            throw new NoBookException("There's no such book");
        }
        return books[index];
    }

    /**
     * @return the numberOfBooks
     */
    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    /**
     * @param numberOfBooks the numberOfBooks to set
     */
    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    /**
     * @return the books
     */
    public Book[] getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(Book[] books) {
        this.setBooks(books);
    }

    /**
     * @return the foundBook
     */
}
