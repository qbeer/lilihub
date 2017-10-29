public interface AuthorStore {

    Author getAuthorById(int id) throws NoAuthorByIdException;
    void addAuthor(Author a) throws InvalidIdException;

}
