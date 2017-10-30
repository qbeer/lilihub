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
public class InValidISBNException extends Exception {

    public InValidISBNException() {
    }

    public InValidISBNException(String message) {
        super(message);
    }

    public InValidISBNException(String message, Throwable cause) {
        super(message, cause);
    }

    public InValidISBNException(Throwable cause) {
        super(cause);
    }

    public InValidISBNException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
