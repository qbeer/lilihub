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
public interface AuthorStore {
    void addAuthor(Author newAuthor) throws InValidAuthorException;
    Author getAuthorByID(int ID) throws NoAuthorException;
}
