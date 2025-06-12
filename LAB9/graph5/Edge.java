package LAB9.graph5;

public class Edge<E> {
    public Vertex<E> refDest; //vertice destino
    public int weight;  //peso

    //constructor por defecto, peso -1
    public Edge(Vertex<E> refDest) {
        this(refDest, -1);
    }
    //constructor con peso
    public Edge(Vertex<E> refDest, int weight) {
        this.refDest = refDest;
        this.weight = weight;
    }

    public Vertex<E> getRefDest() {
        return refDest;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    //comparación de aristas (solo por destino)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Edge<?> edge = (Edge<?>) obj;
        return refDest.equals(edge.refDest);
    }
    /*@Override
    public boolean equals(Object o) {
        if (o instanceof Edge<?>) {
            Edge<?> e = (Edge<?>) o;
            return this.refDest.equals(e.refDest);
        }
        return false;
    }*/
    @Override
    public String toString() {
        if (this.weight > -1)
            return refDest.getData() + "[" + this.weight + "], ";
        else
            return refDest.getData() + ", ";
    }
}
