package store;

import exceptions.InvalidIdException;
import exceptions.NoAuthorByIdException;
import exceptions.NoAuthorsException;

public interface AuthorStore {

    Author getAuthorById(int id) throws NoAuthorByIdException;
    void addAuthor(Author newAuthor) throws InvalidIdException;
    Author[] getAllAuthors() throws NoAuthorsException;

}
