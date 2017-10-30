package Book;

import Book.BookStore;
import Book.Book;
import Author.Author;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileBookStore implements BookStore{
    @Override
    public void addBook(Book book)throws InvalidIsbnException{
        String isbn = book.getIsbn();
      String dirname2 = "books/"+isbn;
      File d = new File(dirname2);
      if(d.exists()){
          throw new InvalidIsbnException(isbn);
      }
      d.mkdir();
        
        File file = new File(dirname2+"/"+isbn+".txt");
        String fileContent = book.getIsbn()+" "+ book.getTitle()+" "+ book.getAuthor();
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(file);
		 bw = new BufferedWriter(fw);
		 bw.write(fileContent);
        }catch (IOException e) {
    		System.out.println("Exception Occurred:");
	        e.printStackTrace();
		}
		finally
		{ 
		   try{
			  if(bw!=null)
			 bw.close();
		   }catch(Exception ex){
			   System.out.println("Error in closing the BufferedWriter"+ex);
			}
                }
    }
    @Override
    public Book getBookByISBN(String isbn)throws NoBookException{
     String dirname = "books/"+isbn+"/"+isbn+".txt";
     Scanner sc = null;
     try {
        sc = new Scanner(new File(dirname));
        String iSbn, title, id, firstName, lastName;
        int birthYear;
        iSbn = sc.next();
        title = sc.next();
        id = sc.next();
        firstName = sc.next();
        lastName = sc.next();
        birthYear = sc.nextInt();
        Author author = new Author(id,firstName, lastName, birthYear);
        Book book = new Book(iSbn, title, author);
       return book;
    } catch (FileNotFoundException e) {
        throw new NoBookException();
    }
    }
    @Override
    public Book[] getAllBook()throws NoBookException{
        Book[] books = new Book[new File("books/").listFiles().length];
        File[] directoriesNames = new File("books/").listFiles();
        if(books.length == 0) {throw new NoBookException();}
        for(int i=0; i<books.length; ++i){
            books[i] = getBookByISBN(directoriesNames[i].getName());
        }
        return books;
    }
}