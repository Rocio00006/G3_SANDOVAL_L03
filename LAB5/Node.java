package LAB5;

public class Node <E> {
    public E valor;
    public Node<E> next;

    //constructores
    public Node(){
        this.valor= null;
        this.next = null;
    }
    public Node(E valor){
        this.valor= valor;
        this.next=null;
    }
    public Node(E valor, Node<E> next) {
        this.valor = valor;
        this.next = next;
    }
    /*
    public Node(Node<E> nodo){
        this.valor = nodo.valor;
        this.next = nodo.next;
    }*/
}
