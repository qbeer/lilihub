package exception;

public class NoAuthorException extends Exception {
    private int ID;

    public  NoAuthorException() {}
    public NoAuthorException(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
}
