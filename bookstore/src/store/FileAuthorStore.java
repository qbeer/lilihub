package store;

import exception.InvalidAuthorException;
import exception.NoAuthorException;
import model.Author;

import store.layer.AuthorStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileAuthorStore implements AuthorStore {

    private File mainStoragePath;

    public FileAuthorStore() {
        mainStoragePath = new File("saved/author/");
        mainStoragePath.mkdirs();
    }

    @Override
    public Author[] getAllAuthor() throws NoAuthorException {

        Author[] authors = new Author[new File("saved/author/").listFiles().length];
        File[] folderNames = new File("saved/author/").listFiles();

        if(authors.length == 0) throw new NoAuthorException();

        for (int i = 0; i < authors.length; i++) {
            authors[i] = getAuthorByID(Integer.parseInt(folderNames[i].getName()));
        }

        return authors;
    }

    @Override
    public void addAuthor(Author author) throws InvalidAuthorException {

        if (new File("saved/author/" + author.getID()).exists()) {
            throw new InvalidAuthorException(author.getID());
        }

        File bookFile = new File("saved/author/" + author.getID() + "/author.txt");
        bookFile.getParentFile().mkdirs();

        try (PrintWriter printWriter = new PrintWriter(bookFile)) {
            printWriter.println(author.getID());
            printWriter.println(author.getFirstName());
            printWriter.println(author.getLastName());
            printWriter.println(author.getBirthYear());
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }

    @Override
    public Author getAuthorByID(int ID) throws NoAuthorException {

        try (Scanner scanner = new Scanner(new File("saved/author/" + ID + "/author.txt"))) {
            Author author = new Author(Integer.parseInt(scanner.nextLine()), scanner.nextLine(), scanner.nextLine(),
                    Integer.parseInt(scanner.nextLine()));
            return author;
        } catch (FileNotFoundException e) {
            throw new NoAuthorException(ID);
        }

    }
}
