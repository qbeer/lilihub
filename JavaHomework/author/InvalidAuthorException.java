
package author;

public class InvalidAuthorException extends Exception{
    private final String id;
    public InvalidAuthorException(String id){
        this.id=id;
    }

    public String getId() {
        return id;
    }
    
}
