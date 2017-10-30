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
public class InValidAuthorException extends Exception {

    /**
     * Creates a new instance of <code>InValidAuthorException</code> without
     * detail message.
     */
    public InValidAuthorException() {
    }

    /**
     * Constructs an instance of <code>InValidAuthorException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InValidAuthorException(String msg) {
        super(msg);
    }
}
