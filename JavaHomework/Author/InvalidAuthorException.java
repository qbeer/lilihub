
package Author;

public class InvalidAuthorException extends Exception{
    String id;
    public InvalidAuthorException(String id){
        this.id=id;
    }

    public String getId() {
        return id;
    }
    
}
