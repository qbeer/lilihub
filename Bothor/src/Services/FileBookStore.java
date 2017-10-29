package Services;

import Exceptions.InvalidIsbnException;
import Exceptions.NoBookByIsbnException;
import Store.Book;
import Store.BookStore;

import java.io.*;

public class FileBookStore implements BookStore {

    private final String srcDir;

    public FileBookStore(String srcDir){
        this.srcDir = srcDir;
        File newSrcDir = new File(srcDir+"/books");
        newSrcDir.mkdir();
    }

    @Override
    public Book getBookByIsbn(String isbn) throws NoBookByIsbnException {
        try {
            FileReader fileReader = new FileReader(srcDir + "/books/" + isbn + "/book.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String title;
            int authorId;
            try {
                title = bufferedReader.readLine();
                authorId = Integer.parseInt(bufferedReader.readLine());
                bufferedReader.close();
                return new Book(isbn,title,authorId);
            }catch (IOException e){
                System.out.println("IOException - Services.FileBookStore getBookByIsbn");
            }
        }catch (FileNotFoundException e){
            throw new NoBookByIsbnException("No book by "+isbn+" yet.");
        }
        return null;
    }

    @Override
    public void addBook(Book newBook) throws InvalidIsbnException {
        try{
            FileReader fileReader = new FileReader(srcDir + "/books/" + newBook.getIsbn() + "/book.txt");
            throw new InvalidIsbnException("Store.Book is already in the database.");
        }catch (FileNotFoundException e){
            File newDir = new File(srcDir+"/books/"+newBook.getIsbn());
            newDir.mkdir();
            try {
                FileWriter fileWriter = new FileWriter(srcDir + "/books/" + newBook.getIsbn() + "/book.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(newBook.getTitle());
                bufferedWriter.newLine();
                bufferedWriter.write(String.valueOf(newBook.getAuthorId()));
                bufferedWriter.close();
            }catch (IOException e2){
                System.out.println("IOException - Services.FileBookStore addBook");
            }
        }
    }
}
