package services;

import exceptions.InvalidIdException;
import exceptions.NoAuthorByIdException;
import exceptions.NoAuthorsException;
import store.Author;

public interface AuthorService {

    Author[] getAllAuthors() throws NoAuthorByIdException, NoAuthorsException;
    void addAuthor(Author newAuthor) throws InvalidIdException;
    Author getAuthorById(int id) throws NoAuthorByIdException;

}
