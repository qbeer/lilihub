package store.layer;

import exception.InvalidAuthorException;
import exception.NoAuthorException;
import model.Author;

public interface AuthorStore {
    Author[] getAllAuthor() throws NoAuthorException;
    void addAuthor(Author author) throws InvalidAuthorException;
    Author getAuthorById(int id) throws NoAuthorException;
}
