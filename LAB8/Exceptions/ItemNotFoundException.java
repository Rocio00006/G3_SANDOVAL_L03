package LAB8.Exceptions;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String message) {
        super(message);
    }
    public ItemNotFoundException(){
        super();
    }
}
