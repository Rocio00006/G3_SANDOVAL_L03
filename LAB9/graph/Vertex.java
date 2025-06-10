package LAB9.graph;

public class Vertex<T> {
    private T data; //valor del vértice
    private int id;
    
    public Vertex(T data, int id) {
        this.data = data;
        this.id = id;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        Vertex<?> vertex = (Vertex<?>) obj;
        return id == vertex.id;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
    
    @Override
    public String toString() {
        return "V(" + id + ":" + data + ")";
    }
}