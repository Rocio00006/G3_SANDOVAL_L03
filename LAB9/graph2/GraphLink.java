package LAB9.graph2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import LAB9.linkedlist.ListLinked;

public class GraphLink<T> {
    private ListLinked<Vertex<T>> vertices; //lista de vertices
    private ListLinked<Edge<T>> edges;      //lista de aristas

    public GraphLink() {
        vertices = new ListLinked<>();
        edges = new ListLinked<>();
    }

    //Método para insertar un vértice
    public void insertVertex(T data) {
        Vertex<T> newVertex = new Vertex<>(data);

        // Verificar si el vértice ya existe
        if (searchVertex(data)) {
            return; //El vértice ya existe
        }
        vertices.insertLast(newVertex);
        // Verificar si el vértice ya existe
        /*if (!searchVertex(data)) {
            vertices.insertLast(newVertex);
        }*/
    }

    //Método para insertar una arista
    public void insertEdge(T data1, T data2) {
        //obtener los objetos de esos vertices
        Vertex<T> vertex1 = findVertex(data1);
        Vertex<T> vertex2 = findVertex(data2);

        //Verificar que ambos vértices existan
        if (vertex1 == null || vertex2 == null) {
            // verificar si la arista NO existe
            if (!searchEdge(data1, data2)) {
                Edge<T> newEdge = new Edge<>(vertex1, vertex2);
                edges.insertLast(newEdge);
            }
        }
    }

    //Método para buscar un vértice
    public boolean searchVertex(T data) {
        return findVertex(data) != null;
    }
    //Método auxiliar para encontrar un vértice
    private Vertex<T> findVertex(T data) {
        for (int i = 0; i < vertices.size(); i++) {
            Vertex<T> vertex = vertices.get(i);
            if (vertex.getData().equals(data)) {
                return vertex;
            }
        }
        return null;
    }
     //Método para buscar una arista
    public boolean searchEdge(T data1, T data2) {
        Vertex<T> vertex1 = findVertex(data1);
        Vertex<T> vertex2 = findVertex(data2);
        
        if (vertex1 == null || vertex2 == null) {
            return false;
        }
        
        for (int i = 0; i < edges.size(); i++) {
            Edge<T> edge = edges.get(i);
            if ((edge.getOrigi().equals(vertex1) && edge.getDesti().equals(vertex2)) ||
                (edge.getOrigi().equals(vertex2) && edge.getDesti().equals(vertex1))) {
                return true;
            }
        }
        return false;
    }
    //Método para eliminar un vértice
    public boolean removeVertex(T data) {
        Vertex<T> vertexToRemove = findVertex(data);
        if (vertexToRemove == null) {
            return false;
        }
        //Primero eliminar todas las aristas que contengan este vértice
        for (int i = edges.size() - 1; i >= 0; i--) {
            Edge<T> edge = edges.get(i);
            if (edge.contains(vertexToRemove)) {
                edges.remove(i);
            }
        }
        //Luego eliminar el vértice
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).equals(vertexToRemove)) {
                vertices.remove(i);
                return true;
            }
        }
        return false;
    }
    
    //Método para eliminar una arista
    public boolean removeEdge(T data1, T data2) {
        Vertex<T> vertex1 = findVertex(data1);
        Vertex<T> vertex2 = findVertex(data2);
        
        if (vertex1 == null || vertex2 == null) {
            return false;
        }
        
        for (int i = 0; i < edges.size(); i++) {
            Edge<T> edge = edges.get(i);
            if ((edge.getOrigi().equals(vertex1) && edge.getDesti().equals(vertex2)) ||
                (edge.getOrigi().equals(vertex2) && edge.getDesti().equals(vertex1))) {
                edges.remove(i);
                return true;
            }
        }
        return false;
    }

    //Método para recorrido en profundidad (DFS)
    public void dfs(T startData) {
        Vertex<T> startVertex = findVertex(startData);
        if (startVertex == null) {
            System.out.println("Vértice de inicio no encontrado");
            return;
        }
        Set<Vertex<T>> visited = new HashSet<>();
        Stack<Vertex<T>> stack = new Stack<>();
        stack.push(startVertex);
        System.out.print("DFS desde " + startData + ": ");

        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                System.out.print(current.getData() + " ");
                //agregar vértices adyacentes al stack
                List<Vertex<T>> adjacents = getAdjacentVertices(current);
                //agregar en orden inverso para mantener el orden correcto en DFS
                for (int i = adjacents.size() - 1; i >= 0; i--) {
                    Vertex<T> adjacent = adjacents.get(i);
                    if (!visited.contains(adjacent)) {
                        stack.push(adjacent);
                    }
                }
            }
        }
        System.out.println();
    }

    //Ejercicio 1
    //a
    //método para obtener recorrido por anchura BFS
    public void bfs(T startData) {
        Vertex<T> startVertex = findVertex(startData);
        if (startVertex == null) {
            System.out.println("Vértice de inicio no encontrado");
            return;
        }
        
        Set<Vertex<T>> visited = new HashSet<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        
        queue.offer(startVertex);
        visited.add(startVertex);
        
        System.out.print("BFS desde " + startData + ": ");
        
        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            System.out.print(current.getData() + " ");
            
            // Agregar vértices adyacentes no visitados a la cola
            List<Vertex<T>> adjacents = getAdjacentVertices(current);
            for (Vertex<T> adjacent : adjacents) {
                if (!visited.contains(adjacent)) {
                    visited.add(adjacent);
                    queue.offer(adjacent);
                }
            }
        }
        System.out.println();
    }
    //b
    //método para encontrar camino entre dos vértices usando BFS
    public ArrayList<T> bfsPath(T startData, T endData) {
        Vertex<T> startVertex = findVertex(startData);
        Vertex<T> endVertex = findVertex(endData);
        
        if (startVertex == null || endVertex == null) {
            System.out.println("Uno o ambos vértices no encontrados");
            return new ArrayList<>();
        }
        if (startVertex.equals(endVertex)) {
            ArrayList<T> path = new ArrayList<>();
            path.add(startData);
            return path;
        }
        Set<Vertex<T>> visited = new HashSet<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        Map<Vertex<T>, Vertex<T>> parent = new HashMap<>();
    
        queue.offer(startVertex);
        visited.add(startVertex);
        parent.put(startVertex, null);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            Vertex<T> current = queue.poll();
            List<Vertex<T>> adjacents = getAdjacentVertices(current);
            for (Vertex<T> adjacent : adjacents) {
                if (!visited.contains(adjacent)) {
                    visited.add(adjacent);
                    parent.put(adjacent, current);
                    queue.offer(adjacent);                    
                    if (adjacent.equals(endVertex)) {
                        found = true;
                        break;
                    }
                }
            }
        }
        // Reconstruir el camino
        ArrayList<T> path = new ArrayList<>();
        if (found) {
            Vertex<T> current = endVertex;
            Stack<T> reversePath = new Stack<>();            
            while (current != null) {
                reversePath.push(current.getData());
                current = parent.get(current);
            }            
            while (!reversePath.isEmpty()) {
                path.add(reversePath.pop());
            }
        }
        return path;
    }

    // ejercicio 2
    // método para insertar una arista con peso
    public void insertEdgeWeight(T data1, T data2, double weight) {
        Vertex<T> vertex1 = findVertex(data1);
        Vertex<T> vertex2 = findVertex(data2);

        if (vertex1 != null && vertex2 != null) {
            if (!searchEdge(data1, data2)) {
                Edge<T> newEdge = new Edge<>(vertex1, vertex2, weight);
                edges.insertLast(newEdge);
            }
        }
    }

    // método para encontrar el camino más corto
    public ArrayList<T> shortPath(T startData, T endData) {
        Vertex<T> startVertex = findVertex(startData);
        Vertex<T> endVertex = findVertex(endData);
        
        if (startVertex == null || endVertex == null) {
            return new ArrayList<>();
        }
        
        Map<Vertex<T>, Double> distances = new HashMap<>();
        Map<Vertex<T>, Vertex<T>> previous = new HashMap<>();
        Set<Vertex<T>> unvisited = new HashSet<>();
        
        // Inicializar distancias
        for (int i = 0; i < vertices.size(); i++) {
            Vertex<T> vertex = vertices.get(i);
            distances.put(vertex, Double.POSITIVE_INFINITY);
            unvisited.add(vertex);
        }
        distances.put(startVertex, 0.0);
        
        while (!unvisited.isEmpty()) {
            // Encontrar vértice no visitado con menor distancia
            Vertex<T> current = null;
            double minDistance = Double.POSITIVE_INFINITY;
            
            for (Vertex<T> vertex : unvisited) {
                if (distances.get(vertex) < minDistance) {
                    minDistance = distances.get(vertex);
                    current = vertex;
                }
            }
            if (current == null || distances.get(current) == Double.POSITIVE_INFINITY) {
                break;
            }  
            unvisited.remove(current);
            
            if (current.equals(endVertex)) {
                break;
            }
            // Actualizar distancias de vértices adyacentes
            List<Edge<T>> adjacentEdges = getAdjacentEdges(current);
            for (Edge<T> edge : adjacentEdges) {
                Vertex<T> neighbor = edge.getOrigi().equals(current) ? edge.getDesti() : edge.getOrigi();
                if (unvisited.contains(neighbor)) {
                    double newDistance = distances.get(current) + edge.getWeight();
                    if (newDistance < distances.get(neighbor)) {
                        distances.put(neighbor, newDistance);
                        previous.put(neighbor, current);
                    }
                }
            }
        }
         // Reconstruir camino
        ArrayList<T> path = new ArrayList<>();
        Vertex<T> current = endVertex;
        
        if (previous.get(current) != null || current.equals(startVertex)) {
            while (current != null) {
                path.add(0, current.getData());
                current = previous.get(current);
            }
        }
        return path;
    }

    //método para ver si es conexo
    public boolean isConexo() {
        if (vertices.size() == 0) {
            return true;
        }
        
        Set<Vertex<T>> visited = new HashSet<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        
        Vertex<T> startVertex = vertices.get(0);
        queue.offer(startVertex);
        visited.add(startVertex);
        
        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            
            List<Vertex<T>> adjacents = getAdjacentVertices(current);
            for (Vertex<T> adjacent : adjacents) {
                if (!visited.contains(adjacent)) {
                    visited.add(adjacent);
                    queue.offer(adjacent);
                }
            }
        }
        
        return visited.size() == vertices.size();
    }

    //método del algoritmos dikstra que retornorá un stack
    public Stack<T> dijkstra(T startData, T endData) {
        ArrayList<T> path = shortPath(startData, endData);
        Stack<T> result = new Stack<>();
        
        //Invertir el camino para que el stack tenga el orden correcto
        for (int i = path.size() - 1; i >= 0; i--) {
            result.push(path.get(i));
        }
        return result;
    }

        //método para obtener vértices adyacentes
    private List<Vertex<T>> getAdjacentVertices(Vertex<T> vertex) {
        List<Vertex<T>> adjacents = new ArrayList<>();
        for (int i = 0; i < edges.size(); i++) {
            Edge<T> edge = edges.get(i);
            if (edge.getOrigi().equals(vertex)) {
                adjacents.add(edge.getDesti());
            } else if (edge.getDesti().equals(vertex)) {
                adjacents.add(edge.getOrigi());
            }
        }
        return adjacents;
    }

    // Método auxiliar para obtener aristas adyacentes a un vértice
    private List<Edge<T>> getAdjacentEdges(Vertex<T> vertex) {
        List<Edge<T>> adjacentEdges = new ArrayList<>();
        for (int i = 0; i < edges.size(); i++) {
            Edge<T> edge = edges.get(i);
            if (edge.getOrigi().equals(vertex) || edge.getDesti().equals(vertex)) {
                adjacentEdges.add(edge);
            }
        }
        return adjacentEdges;
    }

    // Métodos adicionales para mostrar el grafo
    public void printGraph() {
        System.out.println("Vértices del grafo:");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i).getData() + " ");
        }
        System.out.println();
        
        System.out.println("Aristas del grafo:");
        for (int i = 0; i < edges.size(); i++) {
            Edge<T> edge = edges.get(i);
            System.out.println(edge.getOrigi().getData() + " - " + 
                             edge.getDesti().getData() + " (peso: " + edge.getWeight() + ")");
        }
    }

}


