package LAB8;

public class NodeAVL<E> {
    public E data;
    public NodeAVL<E> left;
    public NodeAVL<E> right;
    protected int bf; //nuevo atributo balance factor
    int height;

    public NodeAVL(E data) {
        //this.bf = 0; //inicializa en 0
        this.data = data;    // Esta línea es crucial
        this.left = null;
        this.right = null;
        this.height = 1;

    }
    public E getData() {
        return data;
    }
    public void setData(E data) {
        this.data = data;
    }
    public NodeAVL<E> getLeft() {
        return left;
    }
    public void setLeft(NodeAVL<E> left) {
        this.left = left;
    }
    public NodeAVL<E> getRight() {
        return right;
    }
    public void setRight(NodeAVL<E> right) {
        this.right = right;
    }
    public int getBf() {
        return bf;
    }
    public void setBf(int bf) {
        this.bf = bf;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return data + " (bf=" + bf + ")";
    }
}
