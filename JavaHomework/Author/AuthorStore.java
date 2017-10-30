package author;

interface AuthorStore{
    void addAuthor(Author author)throws InvalidAuthorException;
    Author getAuthorById(String id)throws NoAuthorException;
    Author[] getAllAuthor()throws NoAuthorException;
    
}