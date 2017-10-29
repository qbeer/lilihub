package exception;

public class InvalidAuthorException extends Exception {
    private int id;

    public InvalidAuthorException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
