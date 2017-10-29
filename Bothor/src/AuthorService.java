public interface AuthorService {

    Author[] getAllAuthors() throws NoAuthorByIdException;
    void addAuthor(Author a) throws InvalidIdException;
    Author getAuthorById(int id) throws NoAuthorByIdException;

}
