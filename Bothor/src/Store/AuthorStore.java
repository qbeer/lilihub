package Store;

import Exceptions.InvalidIdException;
import Exceptions.NoAuthorByIdException;

public interface AuthorStore {

    Author getAuthorById(int id) throws NoAuthorByIdException;
    void addAuthor(Author newAuthor) throws InvalidIdException;

}
