package exceptions;

public class NoAuthorsException extends Exception {

    public NoAuthorsException() {
        super();
    }

    public NoAuthorsException(String s) {
        super(s);
    }

    public NoAuthorsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoAuthorsException(Throwable throwable) {
        super(throwable);
    }

    protected NoAuthorsException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
