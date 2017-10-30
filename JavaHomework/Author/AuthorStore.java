package Author;

import Author.Author;

public interface AuthorStore{
    public void addAuthor(Author author)throws InvalidAuthorException;
    public Author getAuthorByID(String id)throws NoAuthorException;
    public Author[] getAllAuthor()throws NoAuthorException;
    
}