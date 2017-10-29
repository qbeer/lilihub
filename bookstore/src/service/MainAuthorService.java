package service;

import exception.InvalidAuthorException;
import exception.NoAuthorException;
import model.Author;
import service.layer.AuthorService;
import store.FileAuthorStore;

public class MainAuthorService implements AuthorService {

    private FileAuthorStore fileAuthorStore = new FileAuthorStore();

    @Override
    public Author[] getAllAuthor() {
        Author[] authors = null;

        try {
            authors = fileAuthorStore.getAllAuthor();
            return authors;
        } catch (NoAuthorException e) {
            System.out.println("There are no authors to list.");
        }

        return authors;
    }

    @Override
    public void addAuthor(Author author) {

        try {
            fileAuthorStore.addAuthor(author);
        } catch (InvalidAuthorException e) {
            System.out.println(e.getID() + " ID author already exists.");
        }

    }

    @Override
    public Author getAuthorByID(int ID) {
        Author author = null;

        try {
            author = fileAuthorStore.getAuthorByID(ID);
        } catch (NoAuthorException e) {
            System.out.println(e.getID() + " ID author not exists.");
        }

        return author;
    }
}
