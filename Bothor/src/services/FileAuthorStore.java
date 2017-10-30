package services;

import exceptions.InvalidIdException;
import exceptions.NoAuthorByIdException;
import exceptions.NoAuthorsException;
import store.Author;
import store.AuthorStore;

import java.io.*;

public class FileAuthorStore implements AuthorStore {

    private final String srcDir;

    public FileAuthorStore(String srcDir){
        this.srcDir = srcDir;
        File newSrcDir = new File(srcDir+"/authors");
        newSrcDir.mkdir();
    }

    @Override
    public Author getAuthorById(int id) throws NoAuthorByIdException {
        try {
            FileReader fileReader = new FileReader(srcDir + "/authors/" + id + "/author.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String firstName;
            String lastName;
            int birthYear;
            try {
                firstName = bufferedReader.readLine();
                lastName = bufferedReader.readLine();
                birthYear = Integer.parseInt(bufferedReader.readLine());
                bufferedReader.close();
                return new Author(id, firstName, lastName, birthYear);
            }catch (IOException e){
                System.out.println("IOException - Services.FileAuthorStore getAuthorById");
            }
        }catch (FileNotFoundException e){
            throw new NoAuthorByIdException("No author by "+id+" yet.");
        }
        return null;
    }

    @Override
    public void addAuthor(Author newAuthor) throws InvalidIdException {
        try{
            FileReader fileReader = new FileReader(srcDir + "/authors/" + newAuthor.getId() + "/author.txt");
            throw new InvalidIdException("Store.Author is already in the database.");
        }catch (FileNotFoundException e){
            File newDir = new File(srcDir+"/authors/"+newAuthor.getId());
            newDir.mkdir();
            try {
                FileWriter fileWriter = new FileWriter(srcDir + "/authors/" + newAuthor.getId() + "/author.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(newAuthor.getFirstName());
                bufferedWriter.newLine();
                bufferedWriter.write(newAuthor.getLastName());
                bufferedWriter.newLine();
                bufferedWriter.write(String.valueOf(newAuthor.getBirthyear()));
                bufferedWriter.close();
            }catch (IOException e2){
                System.out.println("IOException - Services.FileAuthorStore addAuthor");
            }
        }
    }

    @Override
    public Author[] getAllAuthors() throws NoAuthorsException{
        File[] files = new File(srcDir+"/authors/").listFiles();
        if(files == null){
            throw new NoAuthorsException("There are no authors added yet.");
        }
        int authorIndex = 0;
        Author[] authors = new Author[files.length];
        for(File file : files){
            if(file.isDirectory()) {
                try {
                    authors[authorIndex] = this.getAuthorById(Integer.parseInt(file.getName()));
                    authorIndex++;
                } catch (NoAuthorByIdException e) {
                    System.out.println("Never occurring exception.");
                }
            }
        }
        return authors;
    }

}
