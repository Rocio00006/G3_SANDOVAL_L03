package LAB6.ejercicio4;

public class StackLink<E> {

    private Node<E> top;    //es el primero de la pila        

    public StackLink() {
        this.top = null;
    }

    //agregar un elemento a lapila 
    public void push(E x) {
        Node<E> nuevo = new Node<>(x);
        nuevo.setNext(top); //fiamos el next como el primero (top)
        top = nuevo;    //acutlizamos, top ahora será nuevo
    }

    //elimina el 1° elemento o sea tope y lo retorna
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) 
            throw new ExceptionIsEmpty("Pila vacía");
        E valor = top.getValor();
        top = top.getNext();
        return valor;
    }
    //devuleve el primer elemento (tope)
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) 
            throw new ExceptionIsEmpty("piLA VACÍA");
        return top.getValor();
    }
    public boolean isEmpty() {
        return top == null;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder("Pila: [");
        Node<E> current = top;
        while (current != null) {
            sb.append(current.getValor());
            if (current.getNext() != null) sb.append(", ");
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}