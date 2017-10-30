
package Author;

import Author.AuthorService;
import Author.Author;


public class AuthorServiceImpl implements AuthorService {
    FileAuthorStore authorStore = new FileAuthorStore();
    @Override
    public Author[] getAllAuthor(){
        Author[] allAuthor = null;
        try{
        allAuthor = authorStore.getAllAuthor();
        } catch (NoAuthorException e) {
            System.out.println("No author");
        }
        return allAuthor;
    }
    
    @Override
    public void addAuthor(Author author){
    try{
        authorStore.addAuthor(author);
    }catch(InvalidAuthorException e){
        System.out.println(e.getId()+ "author already exists!");
    }
    }
    @Override
    public Author getAuthorByID(String id){
        Author author = null;
       try{
            author = authorStore.getAuthorByID(id);
       }catch(NoAuthorException e){
        System.out.println("No author");
    }
       return author;
    }
}