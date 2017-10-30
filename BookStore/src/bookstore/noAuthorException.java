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
public class noAuthorException extends Exception {

    /**
     * Creates a new instance of <code>noAuthorException</code> without detail
     * message.
     */
    public noAuthorException() {
    }

    /**
     * Constructs an instance of <code>noAuthorException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public noAuthorException(String msg) {
        super(msg);
    }
}
