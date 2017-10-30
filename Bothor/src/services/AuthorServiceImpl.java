package services;

import exceptions.InvalidIdException;
import exceptions.NoAuthorByIdException;
import exceptions.NoAuthorsException;
import store.Author;
import store.AuthorStore;

public class AuthorServiceImpl implements AuthorService{

    private final AuthorStore store;


    public AuthorServiceImpl(AuthorStore store){
        this.store = store;
    }

    @Override
    public Author[] getAllAuthors() throws NoAuthorsException {
        return store.getAllAuthors();
    }

    @Override
    public void addAuthor(Author newAuthor) throws InvalidIdException {
        store.addAuthor(newAuthor);
    }

    @Override
    public Author getAuthorById(int id) throws NoAuthorByIdException {
        return store.getAuthorById(id);
    }

}
