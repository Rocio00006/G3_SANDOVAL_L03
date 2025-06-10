package LAB9.graph;

public class Edge<T> {
    private Vertex<T> source;   //origen
    private Vertex<T> destination;  //destino
    private double weight;  //peso
    
    public Edge(Vertex<T> source, Vertex<T> destination) {
        this.source = source;
        this.destination = destination;
        this.weight = 1.0; //peso por defecto es 1
    }
    //constructor con peso
    public Edge(Vertex<T> source, Vertex<T> destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    public Vertex<T> getSource() {
        return source;
    }
    public void setSource(Vertex<T> source) {
        this.source = source;
    }
    public Vertex<T> getDestination() {
        return destination;
    }
    public void setDestination(Vertex<T> destination) {
        this.destination = destination;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    //para obtener el vértice opuesto dado uno de los vértices
    public Vertex<T> getOpposite(Vertex<T> vertex) {
        if (vertex.equals(source)) {
            return destination;
        } else if (vertex.equals(destination)) {
            return source;
        }
        return null;
    }
    
    //verificar si la arista contiene un vértice específico
    public boolean contains(Vertex<T> vertex) {
        return source.equals(vertex) || destination.equals(vertex);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Edge<?> edge = (Edge<?>) obj;
        return (source.equals(edge.source) && destination.equals(edge.destination)) ||
               (source.equals(edge.destination) && destination.equals(edge.source));
    }
    
    @Override
    public String toString() {
        return "E(" + source.getId() + "-" + destination.getId() + ", w:" + weight + ")";
    }
}