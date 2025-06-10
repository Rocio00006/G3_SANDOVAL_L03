package LAB9.graph2;

import java.util.ArrayList;
import java.util.Stack;

public class TestGraphLink {
    public static void main(String[] args) {
        GraphLink<String> graph = new GraphLink<>();
        
        System.out.println("=== PRUEBAS DEL TAD GRAPH ===\n");
        
        // Insertar vértices
        System.out.println("1. Insertando vértices: A, B, C, D, E");
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        
        // Insertar aristas
        System.out.println("2. Insertando aristas...");
        graph.insertEdge("A", "B");
        graph.insertEdge("A", "C");
        graph.insertEdge("B", "D");
        graph.insertEdge("C", "D");
        graph.insertEdge("D", "E");
        
        // Mostrar el grafo
        System.out.println("3. Grafo creado:");
        graph.printGraph();
        
        System.out.println("\n=== EJERCICIO 1: BFS y BFS PATH ===\n");
        
        // EJERCICIO 1a: Probar BFS
        System.out.println("4. Recorrido BFS desde A:");
        graph.bfs("A");
        
        System.out.println("5. Recorrido BFS desde C:");
        graph.bfs("C");
        
        // EJERCICIO 1b: Probar BFS Path
        System.out.println("6. Camino de A a E usando BFS:");
        ArrayList<String> path = graph.bfsPath("A", "E");
        if (!path.isEmpty()) {
            System.out.print("Camino encontrado: ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        } else {
            System.out.println("No se encontró camino");
        }
        
        System.out.println("7. Camino de B a C usando BFS:");
        path = graph.bfsPath("B", "C");
        if (!path.isEmpty()) {
            System.out.print("Camino encontrado: ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        } else {
            System.out.println("No se encontró camino");
        }
        
        System.out.println("\n=== EJERCICIO 2: GRAFO PONDERADO ===\n");
        
        // Crear un nuevo grafo ponderado
        GraphLink<String> weightedGraph = new GraphLink<>();
        
        System.out.println("8. Creando grafo ponderado...");
        weightedGraph.insertVertex("X");
        weightedGraph.insertVertex("Y");
        weightedGraph.insertVertex("Z");
        weightedGraph.insertVertex("W");
        
        // EJERCICIO 2a: Insertar aristas con peso
        weightedGraph.insertEdgeWeight("X", "Y", 2.5);
        weightedGraph.insertEdgeWeight("X", "Z", 1.0);
        weightedGraph.insertEdgeWeight("Y", "W", 3.0);
        weightedGraph.insertEdgeWeight("Z", "W", 1.5);
        weightedGraph.insertEdgeWeight("Y", "Z", 4.0);
        
        System.out.println("9. Grafo ponderado creado:");
        weightedGraph.printGraph();
        
        // EJERCICIO 2b: Camino más corto
        System.out.println("10. Camino más corto de X a W:");
        ArrayList<String> shortPath = weightedGraph.shortPath("X", "W");
        if (!shortPath.isEmpty()) {
            System.out.print("Camino más corto: ");
            for (int i = 0; i < shortPath.size(); i++) {
                System.out.print(shortPath.get(i));
                if (i < shortPath.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        } else {
            System.out.println("No se encontró camino");
        }
        
        // EJERCICIO 2c: Verificar si es conexo
        System.out.println("11. ¿El grafo es conexo? " + graph.isConexo());
        System.out.println("12. ¿El grafo ponderado es conexo? " + weightedGraph.isConexo());
        
        // EJERCICIO 2d: Dijkstra
        System.out.println("13. Dijkstra de X a W (usando Stack):");
        Stack<String> dijkstraPath = weightedGraph.dijkstra("X", "W");
        if (!dijkstraPath.isEmpty()) {
            System.out.print("Camino (Stack): ");
            while (!dijkstraPath.isEmpty()) {
                System.out.print(dijkstraPath.pop());
                if (!dijkstraPath.isEmpty()) System.out.print(" -> ");
            }
            System.out.println();
        } else {
            System.out.println("No se encontró camino");
        }
        
        System.out.println("\n=== PRUEBAS ADICIONALES ===\n");
        
        // Probar DFS también
        System.out.println("14. Recorrido DFS desde A:");
        graph.dfs("A");
        
        // Probar eliminación
        System.out.println("15. Eliminando vértice B...");
        graph.removeVertex("B");
        System.out.println("16. Grafo después de eliminar B:");
        graph.printGraph();
        
        System.out.println("17. BFS desde A después de eliminar B:");
        graph.bfs("A");
        
        System.out.println("18. ¿El grafo sigue siendo conexo? " + graph.isConexo());
    }
}