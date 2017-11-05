/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author PNMINH
 */
public class FileAuthorStore implements AuthorStore {
    private Author[] authors;
    private Author currentAuthor;
    private int numberOfAuthors;

    public FileAuthorStore(int size) {
        authors = new Author[size];
        numberOfAuthors = 0;
    }
    
    private void writeToFile(String fileName,Author author) throws IOException{
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        StringBuilder sb = new StringBuilder();
        if (author != null) {
            sb.append(author.getFirstName()).append(" ").append(author.getLastName())
                    .append(" || ").append(author.getId()).append(" || ").append(author.getBirthYear());
            writer.write(sb.toString());
        }
        writer.close();
    }
    
    
    @Override
    public void addAuthor(Author newAuthor) throws InValidAuthorException {
        File authorFolder = new File("author/" + newAuthor.getId());
        if (getNumberOfAuthors() >= getAuthors().length) {
            System.out.println("Cannot add any author");
        }
        if(authorFolder.exists()){
            System.out.println("cannot add author");
        }
        authorFolder.mkdirs();
        authors[getNumberOfAuthors()] = newAuthor;
        numberOfAuthors++;
        try {
            writeToFile(authorFolder + "\\author.txt", newAuthor);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public Author getAuthorByID(int ID) throws NoAuthorException {
        File path = new File("author/"+ID);
        if(!path.exists()){
            throw new NoAuthorException("There's no such author");
        }
        int index = lookUpAuthor(ID);
        return getAuthors()[index];
    }

    private int lookUpAuthor(int ID){
        boolean contain = false;
        int index = 0;
        while(index<getAuthors().length && !contain){
            contain = (getAuthors()[index].getId()==ID);
            index++;
        }
        return (contain) ? index-1 : -1;
    }

    /**
     * @return the numberOfAuthors
     */
    public int getNumberOfAuthors() {
        return numberOfAuthors;
    }

    /**
     * @return the authors
     */
    public Author[] getAuthors() {
        return authors;
    }
    /**
     * @return the authors
     */
    
    
}
