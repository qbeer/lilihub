package exceptions;

public class NoBooksException extends Exception {

    public NoBooksException() {
        super();
    }

    public NoBooksException(String s) {
        super(s);
    }

    public NoBooksException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoBooksException(Throwable throwable) {
        super(throwable);
    }

    protected NoBooksException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
