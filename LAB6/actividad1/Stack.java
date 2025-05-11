package LAB6.actividad1;

//STACK/PILA: lifo
public interface Stack<E> {
    void push(E x);  //INSERTA AL FINAL
    E pop() throws ExceptionIsEmpty;  //elimina y devuelve el último
    E top() throws ExceptionIsEmpty;  //DEVUELVE EL ÚLTIMO
    boolean isEmpty();  
    //boolean isFull();
}
