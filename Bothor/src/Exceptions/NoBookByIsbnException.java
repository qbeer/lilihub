package Exceptions;

public class NoBookByIsbnException extends Exception {
    public NoBookByIsbnException() {
        super();
    }

    public NoBookByIsbnException(String s) {
        super(s);
    }

    public NoBookByIsbnException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoBookByIsbnException(Throwable throwable) {
        super(throwable);
    }

    protected NoBookByIsbnException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
