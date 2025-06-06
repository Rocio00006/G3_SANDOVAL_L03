package LAB8;

public class NodeAVL<E> extends Node<E> {
    protected int bf; // balance factor

    public NodeAVL(E data) {
        super(data);
        this.bf = 0; // se inicializa en 0 (equilibrado)
    }

    public int getBalanceFactor() {
        return bf;
    }

    public void setBalanceFactor(int bf) {
        this.bf = bf;
    }

    @Override
    public String toString() {
        return data + " (bf=" + bf + ")";
    }
}
