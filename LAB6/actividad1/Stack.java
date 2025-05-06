package LAB6.actividad1;

public interface Stack<E> {
    void push(E x);  //INSERTA AL FINAL
    void pop();        //ELIMINA EL FINAL
    E top();        //DEVUELVE EL ÚLTIMO
    boolean isEmpty();  
    boolean isFull();
}
