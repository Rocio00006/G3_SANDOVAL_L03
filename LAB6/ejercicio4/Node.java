package LAB6.ejercicio4;

public class Node <E>{
    private E valor;
    private Node<E> next;

    //constructores
    //recibe solo el valor
    public Node(E valor){
        this.valor= valor;
        this.next=null;
    }
    //para cuando recibe el valor, y el nodo siguiente
    public Node(E valor, Node<E> next) {
        this.valor = valor;
        this.next = next;
    }
    //setters y getters
    public void setValor(E valor){
        this.valor = valor;
    }
    public void setNext(Node<E> next){
        this.next = next;
    }
    public E getValor(){
        return valor;
    }
    public Node<E> getNext(){
        return next;
    }
}
