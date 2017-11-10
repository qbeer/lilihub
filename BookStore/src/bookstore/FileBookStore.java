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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PNMINH
 */
public class FileBookStore implements BookStore {


    private void writeToFile(String fileName, Book currentBook) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        if (currentBook != null) {
            writer.write("Title: " + currentBook.getTitle() + " || ISBN: "
                    + currentBook.getIsbn() + " || Author ID: " + currentBook.getAuthorID());
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

    public FileBookStore() {
        
    }

    @Override
    public void addBook(Book newBook) throws InValidISBNException {
        if (!(newBook.getIsbn().contains("[a-zA-Z]+") || newBook.getIsbn().length() != 13 || newBook.getIsbn().length() != 10)) {
            throw new InValidISBNException("Not a valid ISBN");
        }
        try {
            writeToFile("book.txt", newBook);
        } 
        catch (IOException e) {}
    }

   

    @Override
    public Book getBookByISBN(String isbn) throws NoBookException {
        File bookFolder = new File("books/" + isbn);
        if (!bookFolder.exists()) {
            throw new NoBookException("No such book exists");
        }
        Book newBook = null;
        try {
            FileReader fileReader = new FileReader(bookFolder + "/book.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split("||");
                newBook = new Book(temp[0], temp[1], Integer.parseInt(temp[2]));
            }
            reader.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return newBook;
    }

   
}
