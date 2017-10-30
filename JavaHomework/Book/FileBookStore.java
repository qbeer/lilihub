package book;

import author.Author;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileBookStore implements BookStore{
    @Override
    public void addBook(Book book)throws InvalidIsbnException{
        File booksFolder = new File("books");
      if(!booksFolder.exists()){
          booksFolder.mkdir();
      }
        String isbn = book.getIsbn();
      String directoryLocation = "books/"+isbn;
      File d = new File(directoryLocation);
      if(d.exists()){
          throw new InvalidIsbnException(isbn);
      }
      d.mkdir();
        
        File file = new File(directoryLocation+"/"+isbn+".txt");
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
    public Book getBookByIsbn(String isbn)throws NoBookException{
     String fileLocation = "books/"+isbn+"/"+isbn+".txt";
     Scanner sc = null;
     try {
        sc = new Scanner(new File(fileLocation));
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
            books[i] = getBookByIsbn(directoriesNames[i].getName());
        }
        return books;
    }
}