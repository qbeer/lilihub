package Services;

import Exceptions.InvalidIdException;
import Exceptions.NoAuthorByIdException;
import Store.Author;

public interface AuthorService {

    Author[] getAllAuthors() throws NoAuthorByIdException;
    void addAuthor(Author newAuthor) throws InvalidIdException;
    Author getAuthorById(int id) throws NoAuthorByIdException;

}
