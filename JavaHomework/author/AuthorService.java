package author;

public interface AuthorService {
    
    Author[] getAllAuthor();
    void addAuthor(Author author);
    Author getAuthorById(String id);
}