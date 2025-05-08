package LAB6.actividad1;

public interface Stack<E> {
    void push(E x);  //INSERTA AL FINAL
    E pop() throws ExceptionIsEmpty;     //ELIMINA EL FINAL
    E top() throws ExceptionIsEmpty;     //DEVUELVE EL ÚLTIMO
    boolean isEmpty();  
    //boolean isFull();
}
