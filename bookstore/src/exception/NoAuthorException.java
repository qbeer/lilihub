package exception;

public class NoAuthorException extends Exception {
    private int id;

    public  NoAuthorException() {}
    public NoAuthorException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
