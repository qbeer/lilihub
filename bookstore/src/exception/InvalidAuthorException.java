package exception;

public class InvalidAuthorException extends Exception {
    private int ID;

    public InvalidAuthorException(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
}
