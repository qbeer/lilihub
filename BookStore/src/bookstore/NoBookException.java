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
public class NoBookException extends Exception {

    /**
     * Creates a new instance of <code>noBookException</code> without detail
     * message.
     */
    public NoBookException() {
    }

    /**
     * Constructs an instance of <code>noBookException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NoBookException(String msg) {
        super(msg);
    }
}
