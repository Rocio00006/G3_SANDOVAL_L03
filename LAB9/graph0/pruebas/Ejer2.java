package LAB9.graph0.pruebas;

import java.util.ArrayList;
import java.util.Stack;

import LAB9.graph0.GraphLink;

public class Ejer2 {
    public static void main(String[] args) {
        //2.a
        /*System.out.println("\n=== GRAFO CON PESOS ===");
        GraphLink<String> grafoPesos = new GraphLink<>();
        
        grafoPesos.insertVertex("A");
        grafoPesos.insertVertex("B");
        grafoPesos.insertVertex("C");
        grafoPesos.insertVertex("D");
        
        // Insertar aristas con peso
        grafoPesos.insertEdgeWeight("A", "B", 4);
        grafoPesos.insertEdgeWeight("A", "C", 2);
        grafoPesos.insertEdgeWeight("B", "D", 3);
        grafoPesos.insertEdgeWeight("C", "D", 1);
        grafoPesos.insertEdgeWeight("C", "B", 1);
        
        System.out.println(grafoPesos.toString());*/

        /*//2.b
        System.out.println("====Camino más corto con pesos===");
        GraphLink<String> grafo = new GraphLink<>();

        // Insertar vértices
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");
        grafo.insertVertex("E");

        // Insertar aristas con pesos
        grafo.insertEdgeWeight("A", "B", 2);
        grafo.insertEdgeWeight("A", "C", 5);
        grafo.insertEdgeWeight("B", "C", 1);
        grafo.insertEdgeWeight("B", "D", 2);
        grafo.insertEdgeWeight("C", "D", 3);
        grafo.insertEdgeWeight("D", "E", 1);
        System.out.println("Grafo: \n"+grafo.toString());

        // Buscar camino más corto de A a E
        ArrayList<String> camino = grafo.shortPath("A", "E");

        // Mostrar resultado
        if (camino != null) {
            System.out.println("Camino más corto de A a E: " + camino);
        } else {
            System.out.println("No existe un camino de A a E.");
        }*/
        //testConexo();
        testDijkstra();
        
    }
    public static void testConexo(){
// Crear un nuevo grafo ponderado
        GraphLink<String> weightedGraph = new GraphLink<>();
        
        System.out.println("Creando grafo ponderado...");
        weightedGraph.insertVertex("X");
        weightedGraph.insertVertex("Y");
        weightedGraph.insertVertex("Z");
        weightedGraph.insertVertex("W");
        
        //Insertar aristas con peso
        weightedGraph.insertEdgeWeight("X", "Y", 3);
        weightedGraph.insertEdgeWeight("X", "Z", 1);
        weightedGraph.insertEdgeWeight("Y", "W", 5);
        weightedGraph.insertEdgeWeight("Z", "W", 2);
        weightedGraph.insertEdgeWeight("Y", "Z", 6);
        
        System.out.println("Grafo ponderado creado:\n" + weightedGraph);
        
        //EJERCICIO 2c: Verificar si es conexo
        System.out.println("¿El grafo ponderado es conexo? " + weightedGraph.isConexo());
    }

    public static void testDijkstra() {
        // Crear un nuevo grafo ponderado
        GraphLink<String> weightedGraph = new GraphLink<>();

        System.out.println("Creando grafo ponderado...");
        weightedGraph.insertVertex("X");
        weightedGraph.insertVertex("Y");
        weightedGraph.insertVertex("Z");
        weightedGraph.insertVertex("W");

        // Insertar aristas con peso
        weightedGraph.insertEdgeWeight("X", "Y", 3);
        weightedGraph.insertEdgeWeight("X", "Z", 1);
        weightedGraph.insertEdgeWeight("Y", "W", 5);
        weightedGraph.insertEdgeWeight("Z", "W", 2);
        weightedGraph.insertEdgeWeight("Y", "Z", 6);

        System.out.println("Grafo ponderado creado:\n" + weightedGraph);

        System.out.println("Dijkstra de X a W (usando Stack):");
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
    }
}

        