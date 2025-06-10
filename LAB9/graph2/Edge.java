package LAB9.graph2;

public class Edge<T> {
    private Vertex<T> origi;
    private Vertex<T> desti;
    private double weight;
    
    //constructores
    public Edge(Vertex<T> origi, Vertex<T> desti) {
        this.origi = origi;
        this.desti = desti;
        this.weight = 0.0;
    }
    public Edge(Vertex<T> origi, Vertex<T> desti, double weight) {
        this.origi = origi;
        this.desti = desti;
        this.weight = weight;
    }
    public Vertex<T> getOrigi() {
        return origi;
    }
    public Vertex<T> getDesti() {
        return desti;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public boolean contains(Vertex<T> vertex) {
        return origi.equals(vertex) || desti.equals(vertex);
    }
    
    public Vertex<T> getOpposite(Vertex<T> vertex) {
        if (origi.equals(vertex)) {
            return desti;
        } else if (desti.equals(vertex)) {
            return origi;
        }
        return null;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Edge<?> edge = (Edge<?>) obj;
        return (origi.equals(edge.origi) && desti.equals(edge.desti)) ||
               (origi.equals(edge.desti) && desti.equals(edge.origi));
    }
    
    @Override
    public String toString() {
        return "(" + origi + " - " + desti + ")";
    }
}