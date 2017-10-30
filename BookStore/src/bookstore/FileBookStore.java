/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
    private Book foundBook;
    private int numberOfBooks;
    
    public void writeToFile(String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        for (Book currentBook : getBooks()) {
            writer.write("Title: " + currentBook.getTitle() + " || ISBN: "
                    + currentBook.getIsbn() + " || Author ID: " + currentBook.getAuthorID() + "\n");
        }
        writer.close();
    }

    public void readFromFile(String fileName) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
    public FileBookStore() {}
    
    public FileBookStore(int size) {
        books = new Book[size];
        numberOfBooks = 0;
    }

    @Override
    public void addBook(Book newBook) throws InValidISBNException {
        if (!(newBook.getIsbn() instanceof String)) {
            throw new InValidISBNException("Not a valid ISBN");
        }
        if(getNumberOfBooks() >= getBooks().length){
            System.out.println("Limit has reached.");
        }
        getBooks()[getNumberOfBooks()] = newBook;
        setNumberOfBooks(getNumberOfBooks() + 1);
    }

    public int lookUpISBN(String isbn) {
        boolean contains = false;
        int index = 0;
        while (index < getBooks().length && !contains) {
            contains = (getBooks()[index].getIsbn().equals(isbn));
            index++;
        }
        index = (contains) ? index - 1: -1;
        return index;
    }
    
    @Override
    public void getBookByISBN(String isbn) throws noBookException {
        int index = lookUpISBN(isbn);
        if(index == -1) {
            throw new noBookException("There's no such book");
        }
        foundBook = getBooks()[index];
        System.out.println("Book with this isbn: "+foundBook.getTitle());
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
    public Book getFoundBook() {
        return foundBook;
    }

    /**
     * @param foundBook the foundBook to set
     */
    public void setFoundBook(Book foundBook) {
        this.foundBook = foundBook;
    }
}
