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
        for (int i = 0; i < authors.length; i++) {
            if (authorStore.getAuthors()[i] != null) {
                authors[i] = authorStore.getAuthors()[i];
            }
        }
        return authors;
    }

    @Override
    public void addAuthor(Author newAuthor) {
        try {
            authorStore.addAuthor(newAuthor);
        } catch (InValidAuthorException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Author getAuthorByID(int id) {
        Author foundAuthor = null;
        try {
            foundAuthor = authorStore.getAuthorByID(id);
        } catch (NoAuthorException e) {
            System.out.println(e.getMessage());
        }
        if (foundAuthor != null) {
            System.out.println("There's " + foundAuthor.getFirstName() + " " + foundAuthor.getLastName() + " in the author's store.");
        }
        return foundAuthor;
    }

}
