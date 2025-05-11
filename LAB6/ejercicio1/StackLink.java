package LAB6.ejercicio1;

public class StackLink<E> {

    private Node<E> top;    //es el incio de la pila        

    public StackLink() {
        this.top = null;
    }

    public void push(E x) {
        Node<E> newNode = new Node<>(x);
        newNode.setNext(top);
        top = newNode;
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) 
            throw new ExceptionIsEmpty("Stack is empty");
        E value = top.getValor();
        top = top.getNext();
        return value;
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) 
            throw new ExceptionIsEmpty("Stack is empty");
        return top.getValor();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Stack: [");
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