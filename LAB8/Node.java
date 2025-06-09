package LAB8;

public class Node<E> {
    public E data;
    public Node<E> left;
    public Node<E> right;
    public int height; //altura
    
    public Node(E data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public E getData() {
        return data;
    }
    
    public Node<E> getLeft() {
        return left;
    }
    public Node<E> getRight() {
        return right;
    }

    
    public void setData(E data) {
        this.data = data;
    }
    public void setLeft(Node<E> left) {
        this.left = left;
    }
    public void setRight(Node<E> right) {
        this.right = right;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String toString() {
        return data.toString();
    }
}
