package Exceptions;

public class InvalidIsbnException extends Exception {

    public InvalidIsbnException() {
        super();
    }

    public InvalidIsbnException(String s) {
        super(s);
    }

    public InvalidIsbnException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidIsbnException(Throwable throwable) {
        super(throwable);
    }

    protected InvalidIsbnException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
