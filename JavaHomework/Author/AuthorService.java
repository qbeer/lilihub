package Author;

import Author.Author;


public interface AuthorService {
    
    
    public Author[] getAllAuthor();
    public void addAuthor(Author author);
    public Author getAuthorByID(String id);
}