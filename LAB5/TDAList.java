package LAB5;

public interface TDAList<T> {
    public boolean isEmpty();
    public int lenght();
    public void destroy();
    public int search(T x);
    public void insertFirst(T x);
    public void insertLast(T x);
    public void removeNode(T x);

}
