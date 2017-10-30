package exceptions;

public class InvalidIdException extends Exception {

    public InvalidIdException() {
        super();
    }

    public InvalidIdException(String s) {
        super(s);
    }

    public InvalidIdException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidIdException(Throwable throwable) {
        super(throwable);
    }

    protected InvalidIdException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
