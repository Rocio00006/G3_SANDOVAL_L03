package LAB9.graph0;

//import LAB9.linkedlist.ListLinked;

public class Vertex<E> {
    public E data;  //vertice
    protected ListLinked<Edge<E>> listAdj; //lista de adyacencia

 public Vertex(E data) {
        this.data = data;
        this.listAdj = new ListLinked<>();
    }
    public E getData() {
        return data;
    }
    public ListLinked<Edge<E>> getListAdj() {
        return listAdj;
    }
    //comparación de dos vértices
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) obj;
        return data.equals(vertex.data);
    }
    /*@Override
    public boolean equals(Object o) {
        if (o instanceof Vertex<?>) {
            Vertex<?> v = (Vertex<?>) o;
            return this.data.equals(v.data);
        }
        return false;
    }*/
    @Override
    public String toString() {
        return this.data + " --> " + this.listAdj.toString() + "\n";
    }
    
}
