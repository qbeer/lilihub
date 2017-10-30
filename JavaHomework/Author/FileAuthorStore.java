package Author;

import Author.AuthorStore;
import Author.Author;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileAuthorStore implements AuthorStore{
   
    @Override
    public void addAuthor(Author author) throws InvalidAuthorException {
        
    String id = author.getId();
      String dirname2 = "authors/"+id;
      File d = new File(dirname2);
      if(d.exists()){
          throw new InvalidAuthorException(id);
      }
      d.mkdir();
        
        File file = new File(dirname2+"/"+id+".txt");
        String fileContent = author.getId()+" "+ author.getFirstName()+" "+ 
                author.getLastName()+" "+String.valueOf(author.getBirthYear());
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
    public Author getAuthorByID(String id) throws NoAuthorException {
     String dirname = "authors/"+id+"/"+id+".txt";
     Scanner sc = null;
     try {
        sc = new Scanner(new File(dirname));
        String iD, firstName, lastName;
        int birthYear;
        iD = sc.next();
        firstName = sc.next();
        lastName = sc.next();
        birthYear = sc.nextInt();
        Author author = new Author(iD,firstName, lastName, birthYear);
       return author;
    } catch (FileNotFoundException e) {
        throw new NoAuthorException();
    }
    }
      @Override
    public Author[] getAllAuthor()throws NoAuthorException{
        Author[] authors = new Author[new File("authors/").listFiles().length];
        File[] directoriesNames = new File("authors/").listFiles();
        if(authors.length == 0) {throw new NoAuthorException();}
        for(int i=0; i<authors.length; ++i){
            authors[i] = getAuthorByID(directoriesNames[i].getName());
        }
        return authors;
    }
}