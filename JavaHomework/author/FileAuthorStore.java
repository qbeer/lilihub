package author;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileAuthorStore implements AuthorStore{

    
    @Override
    public void addAuthor(Author author) throws InvalidAuthorException {
      File authorsFolder = new File("authors");
      if(!authorsFolder.exists()){
      authorsFolder.mkdir();
      }
        
    String id = author.getId();
      String directoryLocation = "authors/"+id;
      File d = new File(directoryLocation);
      if(d.exists()){
          throw new InvalidAuthorException(id);
      }
      d.mkdir();
        
        File file = new File(directoryLocation+"/"+id+".txt");
        String fileContent = author.getId()+" "+ author.getFirstName()+" "+ 
                author.getLastName()+" "+String.valueOf(author.getBirthYear());
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file);
		 bufferedWriter = new BufferedWriter(fileWriter);
		 bufferedWriter.write(fileContent);
        }catch (IOException e) {
    		System.out.println("Exception Occurred:");
	        e.printStackTrace();
		}
		finally
		{ 
		   try{
			  if(bufferedWriter!=null)
			 bufferedWriter.close();
		   }catch(Exception ex){
			   System.out.println("Error in closing the BufferedWriter"+ex);
			}
                }
      }
        
    @Override
    public Author getAuthorById(String id) throws NoAuthorException {
     String fileLocation = "authors/"+id+"/"+id+".txt";
     Scanner scanner = null;
     try {
        scanner = new Scanner(new File(fileLocation));
        String iD, firstName, lastName;
        int birthYear;
        iD = scanner.next();
        firstName = scanner.next();
        lastName = scanner.next();
        birthYear = scanner.nextInt();
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
        if(authors.length == 0) {
            throw new NoAuthorException();
        }
        for(int i=0; i<authors.length; ++i){
            authors[i] = getAuthorById(directoriesNames[i].getName());
        }
        return authors;
    }
}