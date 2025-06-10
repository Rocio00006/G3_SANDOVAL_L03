package LAB9.graph;

import LAB9.linkedlist.ListLinked;

public class GraphLink<T> {
    private ListLinked<Vertex<T>> vertices;
    private ListLinked<Edge<T>> edges;
    private int nextVertexId;
    
    public GraphLink() {
        this.vertices = new ListLinked<>();
        this.edges = new ListLinked<>();
        this.nextVertexId = 0;
    }
    
    // Agregar vértice
    public Vertex<T> addVertex(T data) {
        Vertex<T> vertex = new Vertex<>(data, nextVertexId++);
        vertices.add(vertex);
        return vertex;
    }
    
    // Eliminar vértice
    public boolean removeVertex(Vertex<T> vertex) {
        if (!vertices.contains(vertex)) {
            return false;
        }
        
        // Eliminar todas las aristas que contienen este vértice
        ListLinked<Edge<T>> edgesToRemove = new ListLinked<>();
        for (int i = 0; i < edges.size(); i++) {
            Edge<T> edge = edges.get(i);
            if (edge.contains(vertex)) {
                edgesToRemove.add(edge);
            }
        }
        
        for (int i = 0; i < edgesToRemove.size(); i++) {
            edges.remove(edgesToRemove.get(i));
        }
        
        // Eliminar el vértice
        return vertices.remove(vertex);
    }
    
    // Agregar arista
    public Edge<T> addEdge(Vertex<T> source, Vertex<T> destination) {
        if (!vertices.contains(source) || !vertices.contains(destination)) {
            throw new IllegalArgumentException("Ambos vértices deben existir en el grafo");
        }
        
        // Verificar si la arista ya existe
        for (int i = 0; i < edges.size(); i++) {
            Edge<T> edge = edges.get(i);
            if (edge.equals(new Edge<>(source, destination))) {
                return edge; // Arista ya existe
            }
        }
        
        Edge<T> edge = new Edge<>(source, destination);
        edges.add(edge);
        return edge;
    }
    
    // Agregar arista con peso
    public Edge<T> addEdge(Vertex<T> source, Vertex<T> destination, double weight) {
        if (!vertices.contains(source) || !vertices.contains(destination)) {
            throw new IllegalArgumentException("Ambos vértices deben existir en el grafo");
        }
        
        // Verificar si la arista ya existe
        for (int i = 0; i < edges.size(); i++) {
            Edge<T> edge = edges.get(i);
            if (edge.equals(new Edge<>(source, destination))) {
                edge.setWeight(weight);
                return edge; // Actualizar peso de arista existente
            }
        }
        
        Edge<T> edge = new Edge<>(source, destination, weight);
        edges.add(edge);
        return edge;
    }
    
    // Eliminar arista
    public boolean removeEdge(Vertex<T> source, Vertex<T> destination) {
        Edge<T> edgeToRemove = new Edge<>(source, destination);
        return edges.remove(edgeToRemove);
    }
    
    // Obtener arista entre dos vértices
    public Edge<T> getEdge(Vertex<T> source, Vertex<T> destination) {
        for (int i = 0; i < edges.size(); i++) {
            Edge<T> edge = edges.get(i);
            if (edge.equals(new Edge<>(source, destination))) {
                return edge;
            }
        }
        return null;
    }
    
    // Obtener todos los vértices
    public ListLinked<Vertex<T>> getVertices() {
        return vertices;
    }
    
    // Obtener todas las aristas
    public ListLinked<Edge<T>> getEdges() {
        return edges;
    }
    
    // Obtener vértices adyacentes a un vértice dado
    public ListLinked<Vertex<T>> getAdjacentVertices(Vertex<T> vertex) {
        ListLinked<Vertex<T>> adjacentVertices = new ListLinked<>();
        
        for (int i = 0; i < edges.size(); i++) {
            Edge<T> edge = edges.get(i);
            if (edge.contains(vertex)) {
                Vertex<T> opposite = edge.getOpposite(vertex);
                if (opposite != null) {
                    adjacentVertices.add(opposite);
                }
            }
        }
        
        return adjacentVertices;
    }
    
    // Obtener aristas incidentes a un vértice
    public ListLinked<Edge<T>> getIncidentEdges(Vertex<T> vertex) {
        ListLinked<Edge<T>> incidentEdges = new ListLinked<>();
        
        for (int i = 0; i < edges.size(); i++) {
            Edge<T> edge = edges.get(i);
            if (edge.contains(vertex)) {
                incidentEdges.add(edge);
            }
        }
        
        return incidentEdges;
    }
    
    // Obtener grado de un vértice
    public int getDegree(Vertex<T> vertex) {
        return getIncidentEdges(vertex).size();
    }
    
    // Verificar si existe una arista entre dos vértices
    public boolean hasEdge(Vertex<T> source, Vertex<T> destination) {
        return getEdge(source, destination) != null;
    }
    
    // Obtener número de vértices
    public int getVertexCount() {
        return vertices.size();
    }
    
    // Obtener número de aristas
    public int getEdgeCount() {
        return edges.size();
    }
    
    // Verificar si el grafo está vacío
    public boolean isEmpty() {
        return vertices.isEmpty();
    }
    
    // Limpiar el grafo
    public void clear() {
        vertices.clear();
        edges.clear();
        nextVertexId = 0;
    }
    
    // Buscar vértice por datos
    public Vertex<T> findVertex(T data) {
        for (int i = 0; i < vertices.size(); i++) {
            Vertex<T> vertex = vertices.get(i);
            if (vertex.getData().equals(data)) {
                return vertex;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grafo:\n");
        sb.append("Vértices: ").append(vertices).append("\n");
        sb.append("Aristas: ").append(edges);
        return sb.toString();
    }
}