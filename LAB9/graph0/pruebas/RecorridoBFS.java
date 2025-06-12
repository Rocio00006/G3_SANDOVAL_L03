package LAB9.graph0.pruebas;

import LAB9.graph0.GraphLink;

public class RecorridoBFS {
    public static void main(String[] args) {
        GraphLink<String> grafo = new GraphLink<>();
        
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");
        grafo.insertVertex("E");
        
        grafo.insertEdge("A", "B");
        grafo.insertEdge("A", "C");
        grafo.insertEdge("B", "D");
        grafo.insertEdge("C", "D");
        grafo.insertEdge("D", "E");
        
        System.out.println("=== GRAFO CREADO ===");
        System.out.println(grafo.toString());
        
        //recorrido BFS
        System.out.println("=== PRUEBA BFS ===");
        grafo.bfs("A");
        grafo.bfs("E");

        System.out.println("=== PRUEBA BFS path ===");
        System.out.println("Camino: " +grafo.bfsPath("A", "D"));
        System.out.println("Camino: " +grafo.bfsPath("C", "E"));
        System.out.println("Camino: " +grafo.bfsPath("E", "C"));


    }
}
