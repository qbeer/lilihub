package service;

import exception.InvalidAuthorException;
import exception.NoAuthorException;
import model.Author;
import service.layer.AuthorService;
import store.FileAuthorStore;
import store.layer.AuthorStore;

public class MainAuthorService implements AuthorService {

    private AuthorStore authorStore;

    public  MainAuthorService(AuthorStore authorStore) {
        this.authorStore = authorStore;
    }

    @Override
    public Author[] getAllAuthor() {
        Author[] authors = null;

        try {
            authors = authorStore.getAllAuthor();
            return authors;
        } catch (NoAuthorException e) {
            System.err.println("There are no authors to list.");
        }

        return authors;
    }

    @Override
    public void addAuthor(Author author) {

        try {
            authorStore.addAuthor(author);
        } catch (InvalidAuthorException e) {
            System.err.println(e.getId() + " ID author already exists.");
        }

    }

    @Override
    public Author getAuthorById(int id) {
        Author author = null;

        try {
            author = authorStore.getAuthorById(id);
        } catch (NoAuthorException e) {
            System.err.println(e.getId() + " ID author does not exists.");
        }

        return author;
    }
}
