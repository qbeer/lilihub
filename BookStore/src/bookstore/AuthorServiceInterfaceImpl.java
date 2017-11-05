/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author PNMINH
 */
public class AuthorServiceInterfaceImpl implements AuthorServiceInterface {
    FileAuthorStore authorStore;

    public AuthorServiceInterfaceImpl(int size) {
        authorStore = new FileAuthorStore(size);
    }
    
    @Override
    public Author[] getAllAuthors() {
        Author[] authors = new Author[authorStore.getNumberOfAuthors()];
        
        return authors;
    }

    @Override
    public void addAuthor(Author newAuthor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Author getAuthorByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
