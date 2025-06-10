package LAB9.graph3;

import java.util.ArrayList;

public class TestGraphListEdge {
    public static void main(String[] args) {
        
        //Creamos un nuevo grafo con vértices y aristas de tipo String
        GraphListEdge<String, String> graph = new GraphListEdge<>();
        
        System.out.println("1. PRUEBA DE INSERCIÓN DE VÉRTICES");
        System.out.println("-----------------------------------");
        System.out.println("Insertando vértices: A, B, C, D, E");
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        
        //Intentar insertar un vértice duplicado
        System.out.println("Intentando insertar vértice A nuevamente...");
        graph.insertVertex("A");
        graph.printGraph();
        
        // ==========================================
        // PRUEBA 2: BÚSQUEDA DE VÉRTICES
        // ==========================================
        System.out.println("2. PRUEBA DE BÚSQUEDA DE VÉRTICES");
        System.out.println("----------------------------------");
        
        System.out.println("¿Existe vértice A? " + graph.searchVertex("A"));
        System.out.println("¿Existe vértice F? " + graph.searchVertex("F"));
        System.out.println("¿Existe vértice C? " + graph.searchVertex("C"));
        System.out.println();
        
        // ==========================================
        // PRUEBA 3: INSERCIÓN DE ARISTAS
        // ==========================================
        System.out.println("3. PRUEBA DE INSERCIÓN DE ARISTAS");
        System.out.println("----------------------------------");
        
        System.out.println("Insertando aristas:");
        System.out.println("A-B, A-C, B-D, C-D, D-E, B-E");
        
        graph.insertEdge("A", "B");
        graph.insertEdge("A", "C");
        graph.insertEdge("B", "D");
        graph.insertEdge("C", "D");
        graph.insertEdge("D", "E");
        graph.insertEdge("B", "E");
        //intentar insertar una arista duplicada
        System.out.println("Intentando insertar arista A-B nuevamente...");
        graph.insertEdge("A", "B");
        
        //intentar insertar arista con vértice inexistente
        System.out.println("Intentando insertar arista A-F (F no existe)...");
        graph.insertEdge("A", "F");
        graph.printGraph();
        
        // ==========================================
        // PRUEBA 4: BÚSQUEDA DE ARISTAS
        // ==========================================
        System.out.println("4. PRUEBA DE BÚSQUEDA DE ARISTAS");
        System.out.println("---------------------------------");
        
        System.out.println("¿Existe arista A-B? " + graph.searchEdge("A", "B"));
        System.out.println("¿Existe arista B-A? " + graph.searchEdge("B", "A")); // Debe ser true (grafo no dirigido)
        System.out.println("¿Existe arista A-E? " + graph.searchEdge("A", "E"));
        System.out.println("¿Existe arista F-G? " + graph.searchEdge("F", "G"));
        System.out.println();
        
        // ==========================================
        // PRUEBA 5: RECORRIDO BFS
        // ==========================================
        System.out.println("5. PRUEBA DE RECORRIDO BFS");
        System.out.println("---------------------------");
        
        System.out.println("BFS desde diferentes vértices:");
        graph.bfs("A");
        graph.bfs("C");
        graph.bfs("E");
        
        // Probar BFS con vértice inexistente
        System.out.println("BFS desde vértice inexistente F:");
        graph.bfs("F");
        System.out.println();
        
        // ==========================================
        // PRUEBA 6: GRADO DE VÉRTICES
        // ==========================================
        System.out.println("6. PRUEBA DE GRADO DE VÉRTICES");
        System.out.println("-------------------------------");
        
        System.out.println("Grado de A: " + graph.getDegree("A"));
        System.out.println("Grado de B: " + graph.getDegree("B"));
        System.out.println("Grado de C: " + graph.getDegree("C"));
        System.out.println("Grado de D: " + graph.getDegree("D"));
        System.out.println("Grado de E: " + graph.getDegree("E"));
        System.out.println("Grado de F (inexistente): " + graph.getDegree("F"));
        System.out.println();
        
        // ==========================================
        // PRUEBA 7: ARISTAS INCIDENTES
        // ==========================================
        System.out.println("7. PRUEBA DE ARISTAS INCIDENTES");
        System.out.println("--------------------------------");
        
        ArrayList<EdgeObj<String, String>> incidentEdges = graph.getIncidentEdges("D");
        System.out.println("Aristas incidentes a D:");
        for (EdgeObj<String, String> edge : incidentEdges) {
            System.out.println("  " + edge.getEndVertex1().getInfo() + " -- " + 
                             edge.getEndVertex2().getInfo());
        }
        System.out.println();
        
        // ==========================================
        // PRUEBA 8: ELIMINACIÓN DE ARISTAS
        // ==========================================
        System.out.println("8. PRUEBA DE ELIMINACIÓN DE ARISTAS");
        System.out.println("------------------------------------");
        
        System.out.println("Estado antes de eliminar arista B-E:");
        graph.printGraph();
        
        System.out.println("Eliminando arista B-E...");
        boolean removed = graph.removeEdge("B", "E");
        System.out.println("¿Se eliminó correctamente? " + removed);
        
        System.out.println("Estado después de eliminar arista B-E:");
        graph.printGraph();
        
        // ==========================================
        // PRUEBA 9: ELIMINACIÓN DE VÉRTICES
        // ==========================================
        System.out.println("9. PRUEBA DE ELIMINACIÓN DE VÉRTICES");
        System.out.println("-------------------------------------");
        
        System.out.println("Estado antes de eliminar vértice C:");
        graph.printGraph();
        
        System.out.println("Eliminando vértice C...");
        boolean vertexRemoved = graph.removeVertex("C");
        System.out.println("¿Se eliminó correctamente? " + vertexRemoved);
        
        System.out.println("Estado después de eliminar vértice C:");
        graph.printGraph();
        
        System.out.println("BFS después de eliminar C:");
        graph.bfs("A");
        
        // ==========================================
        // PRUEBA 10: GRAFO COMPLEJO
        // ==========================================
        System.out.println("10. PRUEBA CON GRAFO MÁS COMPLEJO");
        System.out.println("----------------------------------");
        
        GraphListEdge<Integer, String> complexGraph = new GraphListEdge<>();
        
        // Insertar vértices numerados
        for (int i = 1; i <= 6; i++) {
            complexGraph.insertVertex(i);
        }
        
        // Crear un grafo más complejo
        complexGraph.insertEdge(1, 2);
        complexGraph.insertEdge(1, 3);
        complexGraph.insertEdge(2, 4);
        complexGraph.insertEdge(3, 4);
        complexGraph.insertEdge(4, 5);
        complexGraph.insertEdge(4, 6);
        complexGraph.insertEdge(5, 6);
        
        System.out.println("Grafo complejo creado:");
        complexGraph.printGraph();
        
        System.out.println("BFS desde vértice 1:");
        complexGraph.bfs(1);
        
        System.out.println("BFS desde vértice 4:");
        complexGraph.bfs(4);
        
        // ==========================================
        // PRUEBA 11: ESTADÍSTICAS FINALES
        // ==========================================
        System.out.println("11. ESTADÍSTICAS FINALES");
        System.out.println("-------------------------");
        
        System.out.println("Grafo original:");
        System.out.println("  - Número de vértices: " + graph.getVertexCount());
        System.out.println("  - Número de aristas: " + graph.getEdgeCount());
        System.out.println("  - ¿Es conexo? " + graph.isConnected());
        
        System.out.println("\nGrafo complejo:");
        System.out.println("  - Número de vértices: " + complexGraph.getVertexCount());
        System.out.println("  - Número de aristas: " + complexGraph.getEdgeCount());
        System.out.println("  - ¿Es conexo? " + complexGraph.isConnected());
        
        System.out.println("\n=== FIN DE LAS PRUEBAS ===");
    }
}