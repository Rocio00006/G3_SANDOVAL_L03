package LAB9.graph3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphListEdge<V, E> {
    ArrayList<VertexObj<V, E>> secVertex;
    ArrayList<EdgeObj<V, E>> secEdge;
    
    public GraphListEdge() {
        this.secVertex = new ArrayList<VertexObj<V, E>>();
        this.secEdge = new ArrayList<EdgeObj<V, E>>();
    }
    
    //a
    //método que inserta el vértice 'v' en caso no exista
    public void insertVertex(V data) {
        //verificar si el vértice ya existe
        if (searchVertex(data)) {
            return; // El vértice ya existe
        }
        
        //crear nuevo vértice con posición igual al tamaño actual de la lista
        VertexObj<V, E> newVertex = new VertexObj<>(data, secVertex.size());
        secVertex.add(newVertex);
    }
    
    //b
    //método q inserta la arista entre los vértices 'v' y 'z' en caso aún no haya sido insertada
    public void insertEdge(V data1, V data2) {
        // Buscar los vértices
        VertexObj<V, E> vertex1 = findVertex(data1);
        VertexObj<V, E> vertex2 = findVertex(data2);
        
        // Verificar que ambos vértices existan
        if (vertex1 == null || vertex2 == null) {
            System.out.println("Error: Uno o ambos vértices no existen");
            return;
        }
        
        // Verificar si la arista ya existe
        if (searchEdge(data1, data2)) {
            return; // La arista ya existe
        }
        
        // Crear nueva arista con posición igual al tamaño actual de la lista
        EdgeObj<V, E> newEdge = new EdgeObj<>(vertex1, vertex2, secEdge.size());
        secEdge.add(newEdge);
    }
    
    //c
    //método que busca un vertice y verifica si se ha encontrado
    public boolean searchVertex(V data) {
        return findVertex(data) != null;
    }
    
    // d) searchEdge(v, z): busca la arista entre los vértices 'v' y 'z'
    //métod que busca una arista entre dos vertices 
    public boolean searchEdge(V data1, V data2) {
        VertexObj<V, E> vertex1 = findVertex(data1);
        VertexObj<V, E> vertex2 = findVertex(data2);
        
        if (vertex1 == null || vertex2 == null) {
            return false;
        }
        //buscar la arista en la lista de aristas
        for (EdgeObj<V, E> edge : secEdge) {
            if (edge.connects(vertex1, vertex2)) {
                return true;
            }
        }
        return false;
    }
    
    // e) bfs(v): realiza el recorrido en anchura desde el vértice 'v'
    //método que hace DFS desde un vértice especídfico
    public void bfs(V inicio) {
        VertexObj<V, E> startVertex = findVertex(inicio);
        if (startVertex == null) {
            System.out.println("Vértice de inicio no encontrado");
            return;
        }
        
        Set<VertexObj<V, E>> visited = new HashSet<>();
        Queue<VertexObj<V, E>> queue = new LinkedList<>();
        queue.offer(startVertex);
        visited.add(startVertex);
        System.out.print("BFS desde " + inicio + ": ");
        while (!queue.isEmpty()) {
            VertexObj<V, E> current = queue.poll();
            System.out.print(current.getInfo() + " ");
            //obtener vertices adyacentes
            ArrayList<VertexObj<V, E>> adjacents = getAdjacentVertices(current);
            for (VertexObj<V, E> adjacent : adjacents) {
                if (!visited.contains(adjacent)) {
                    visited.add(adjacent);
                    queue.offer(adjacent);
                }
            }
        }
        System.out.println();
    }
    
    //método para encontrar un vértice y devolverlo
    private VertexObj<V, E> findVertex(V data) {
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getInfo().equals(data)) {
                return vertex;
            }
        }
        return null;
    }
    
    // Método auxiliar para obtener vértices adyacentes a un vértice dado
    private ArrayList<VertexObj<V, E>> getAdjacentVertices(VertexObj<V, E> vertex) {
        ArrayList<VertexObj<V, E>> adjacents = new ArrayList<>();
        
        for (EdgeObj<V, E> edge : secEdge) {
            if (edge.contains(vertex)) {
                VertexObj<V, E> opposite = edge.getOpposite(vertex);
                if (opposite != null) {
                    adjacents.add(opposite);
                }
            }
        }
        
        return adjacents;
    }
    
    // Método para obtener todas las aristas incidentes a un vértice
    public ArrayList<EdgeObj<V, E>> getIncidentEdges(V data) {
        VertexObj<V, E> vertex = findVertex(data);
        ArrayList<EdgeObj<V, E>> incidentEdges = new ArrayList<>();
        
        if (vertex != null) {
            for (EdgeObj<V, E> edge : secEdge) {
                if (edge.contains(vertex)) {
                    incidentEdges.add(edge);
                }
            }
        }
        
        return incidentEdges;
    }
    
    // Método para eliminar un vértice
    public boolean removeVertex(V data) {
        VertexObj<V, E> vertexToRemove = findVertex(data);
        if (vertexToRemove == null) {
            return false;
        }
        
        // Eliminar todas las aristas que contienen este vértice
        secEdge.removeIf(edge -> edge.contains(vertexToRemove));
        
        // Eliminar el vértice
        secVertex.remove(vertexToRemove);
        
        // Actualizar posiciones de los vértices restantes
        for (int i = 0; i < secVertex.size(); i++) {
            secVertex.get(i).setPosition(i);
        }
        
        // Actualizar posiciones de las aristas restantes
        for (int i = 0; i < secEdge.size(); i++) {
            secEdge.get(i).setPosition(i);
        }
        
        return true;
    }
    
    // Método para eliminar una arista
    public boolean removeEdge(V data1, V data2) {
        VertexObj<V, E> vertex1 = findVertex(data1);
        VertexObj<V, E> vertex2 = findVertex(data2);
        
        if (vertex1 == null || vertex2 == null) {
            return false;
        }
        
        // Buscar y eliminar la arista
        for (int i = 0; i < secEdge.size(); i++) {
            EdgeObj<V, E> edge = secEdge.get(i);
            if (edge.connects(vertex1, vertex2)) {
                secEdge.remove(i);
                
                // Actualizar posiciones de las aristas restantes
                for (int j = i; j < secEdge.size(); j++) {
                    secEdge.get(j).setPosition(j);
                }
                
                return true;
            }
        }
        
        return false;
    }
    
    // Método para verificar si el grafo es conexo
    public boolean isConnected() {
        if (secVertex.isEmpty()) {
            return true;
        }
        
        Set<VertexObj<V, E>> visited = new HashSet<>();
        Queue<VertexObj<V, E>> queue = new LinkedList<>();
        
        VertexObj<V, E> startVertex = secVertex.get(0);
        queue.offer(startVertex);
        visited.add(startVertex);
        
        while (!queue.isEmpty()) {
            VertexObj<V, E> current = queue.poll();
            
            ArrayList<VertexObj<V, E>> adjacents = getAdjacentVertices(current);
            for (VertexObj<V, E> adjacent : adjacents) {
                if (!visited.contains(adjacent)) {
                    visited.add(adjacent);
                    queue.offer(adjacent);
                }
            }
        }
        
        return visited.size() == secVertex.size();
    }
    
    // Método para mostrar el grafo
    public void printGraph() {
        System.out.println("=== GRAFO (Lista de Estructura de Aristas) ===");
        
        System.out.println("Vértices:");
        for (VertexObj<V, E> vertex : secVertex) {
            System.out.println("  Posición " + vertex.getPosition() + ": " + vertex.getInfo());
        }
        
        System.out.println("Aristas:");
        for (EdgeObj<V, E> edge : secEdge) {
            System.out.println("  Posición " + edge.getPosition() + ": " + 
                             edge.getEndVertex1().getInfo() + " -- " + 
                             edge.getEndVertex2().getInfo());
        }
        
        System.out.println("Total vértices: " + secVertex.size());
        System.out.println("Total aristas: " + secEdge.size());
        System.out.println("¿Es conexo? " + isConnected());
        System.out.println();
    }
    
    // Método para obtener el grado de un vértice
    public int getDegree(V data) {
        VertexObj<V, E> vertex = findVertex(data);
        if (vertex == null) {
            return -1;
        }
        
        int degree = 0;
        for (EdgeObj<V, E> edge : secEdge) {
            if (edge.contains(vertex)) {
                degree++;
            }
        }
        
        return degree;
    }
    
    // Getters para acceso a las listas (útil para pruebas)
    public ArrayList<VertexObj<V, E>> getVertices() {
        return secVertex;
    }
    
    public ArrayList<EdgeObj<V, E>> getEdges() {
        return secEdge;
    }
    
    // Método para obtener el número de vértices
    public int getVertexCount() {
        return secVertex.size();
    }
    
    // Método para obtener el número de aristas
    public int getEdgeCount() {
        return secEdge.size();
    }
}