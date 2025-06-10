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
}
