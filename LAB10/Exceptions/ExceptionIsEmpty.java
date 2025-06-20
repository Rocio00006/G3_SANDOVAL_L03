package LAB10.Exceptions;

public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty(String message){
        super(message);
    }
    public ExceptionIsEmpty(){
        super();
    }
}
