package LAB8;

public class Node<E> {
    private E data;
    private Node<E> left;
    private Node<E> right;
    private int height; //altura
    
    public Node(E data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public E getData() {
        return data;
    }

    public String toString() {
        return data.toString();
    }
}
