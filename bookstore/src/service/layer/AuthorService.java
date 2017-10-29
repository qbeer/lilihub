package service.layer;

import model.Author;

public interface AuthorService {
    Author[] getAllAuthor();
    void addAuthor(Author author);
    Author getAuthorById(int id);
}
