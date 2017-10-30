package exceptions;

public class NoAuthorByIdException extends Exception {

    public NoAuthorByIdException() {
        super();
    }

    public NoAuthorByIdException(String s) {
        super(s);
    }

    public NoAuthorByIdException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoAuthorByIdException(Throwable throwable) {
        super(throwable);
    }

    protected NoAuthorByIdException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
