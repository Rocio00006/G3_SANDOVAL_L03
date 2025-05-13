package LAB7.actividad.Exceptions;

public class ItemDuplicatedException extends Exception {
    public ItemDuplicatedException(String message) {
        super(message);
    }
    public ItemDuplicatedException(){
        super();
    }
}