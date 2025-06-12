package LAB9.graph7;

import java.util.ArrayList;

public class TestGraphListEdge {
    
    // Instancia única del grafo que se transformará
    private static GraphListEdge<String, String> graph;
    
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS CON UN SOLO GRAFO TRANSFORMABLE ===\n");
        
        // Inicializar el grafo como dirigido
        graph = new GraphListEdge<>(true);
        
        // Ejecutar todas las pruebas secuencialmente
        testAsDirectedPath();
        resetAndTestAsCycle();
        resetAndTestAsWheel();
        resetAndTestAsStar();
        resetAndTestAsGeneral();
        
        System.out.println("=== TODAS LAS PRUEBAS COMPLETADAS ===");
    }
    
    /**
     * Prueba 1: Configurar el grafo como un CAMINO DIRIGIDO
     */
    public static void testAsDirectedPath() {
        System.out.println("1. CONFIGURANDO GRAFO COMO CAMINO DIRIGIDO");
        System.out.println("Estructura: A --> B --> C --> D --> E");
        System.out.println("-".repeat(50));
        
        // Limpiar grafo
        clearGraph();
        
        // Agregar vértices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        
        // Crear camino dirigido
        graph.insertEdge("A", "B");
        graph.insertEdge("B", "C");
        graph.insertEdge("C", "D");
        graph.insertEdge("D", "E");
        
        // Analizar y mostrar resultados
        analyzeCurrentGraph();
        
        System.out.println("RESULTADOS:");
        System.out.println("¿Es camino dirigido? " + graph.isDirectedPath());
        System.out.println("¿Es ciclo dirigido? " + graph.isDirectedCycle());
        System.out.println("¿Es rueda dirigida? " + graph.isDirectedWheel());
        System.out.println("¿Es estrella dirigida? " + graph.isDirectedStar());
        System.out.println("Tipo identificado: " + graph.identifyGraphType());
        
        System.out.println("\n" + "=".repeat(70) + "\n");
    }
    
    /**
     * Prueba 2: Reconfigurar el mismo grafo como CICLO DIRIGIDO
     */
    public static void resetAndTestAsCycle() {
        System.out.println("2. RECONFIGURANDO EL MISMO GRAFO COMO CICLO DIRIGIDO");
        System.out.println("Estructura: A --> B --> C --> D --> A");
        System.out.println("-".repeat(50));
        
        // Limpiar grafo (reutilizar vértices si es posible)
        clearGraph();
        
        // Agregar vértices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        
        // Crear ciclo dirigido
        graph.insertEdge("A", "B");
        graph.insertEdge("B", "C");
        graph.insertEdge("C", "D");
        graph.insertEdge("D", "A"); // Cierra el ciclo
        
        // Analizar y mostrar resultados
        analyzeCurrentGraph();
        
        System.out.println("RESULTADOS:");
        System.out.println("¿Es camino dirigido? " + graph.isDirectedPath());
        System.out.println("¿Es ciclo dirigido? " + graph.isDirectedCycle());
        System.out.println("¿Es rueda dirigida? " + graph.isDirectedWheel());
        System.out.println("¿Es estrella dirigida? " + graph.isDirectedStar());
        System.out.println("Tipo identificado: " + graph.identifyGraphType());
        
        System.out.println("\n" + "=".repeat(70) + "\n");
    }
    
    /**
     * Prueba 3: Reconfigurar el mismo grafo como RUEDA DIRIGIDA
     */
    public static void resetAndTestAsWheel() {
        System.out.println("3. RECONFIGURANDO EL MISMO GRAFO COMO RUEDA DIRIGIDA");
        System.out.println("Estructura: Centro(H) ↔ {A,B,C} + A-->B-->C-->A");
        System.out.println("-".repeat(50));
        
        // Limpiar grafo
        clearGraph();
        
        // Agregar vértices
        graph.insertVertex("H"); // Centro (Hub)
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        
        // Conexiones bidireccionales del centro
        graph.insertEdge("H", "A");
        graph.insertEdge("A", "H");
        graph.insertEdge("H", "B");
        graph.insertEdge("B", "H");
        graph.insertEdge("H", "C");
        graph.insertEdge("C", "H");
        
        // Ciclo en el borde
        graph.insertEdge("A", "B");
        graph.insertEdge("B", "C");
        graph.insertEdge("C", "A");
        
        // Analizar y mostrar resultados
        analyzeCurrentGraph();
        
        System.out.println("RESULTADOS:");
        System.out.println("¿Es camino dirigido? " + graph.isDirectedPath());
        System.out.println("¿Es ciclo dirigido? " + graph.isDirectedCycle());
        System.out.println("¿Es rueda dirigida? " + graph.isDirectedWheel());
        System.out.println("¿Es estrella dirigida? " + graph.isDirectedStar());
        System.out.println("Tipo identificado: " + graph.identifyGraphType());
        
        System.out.println("\n" + "=".repeat(70) + "\n");
    }
    
    /**
     * Prueba 4: Reconfigurar el mismo grafo como ESTRELLA DIRIGIDA
     */
    public static void resetAndTestAsStar() {
        System.out.println("4. RECONFIGURANDO EL MISMO GRAFO COMO ESTRELLA DIRIGIDA");
        System.out.println("Estructura: Centro(H) --> {A,B,C,D}");
        System.out.println("-".repeat(50));
        
        // Limpiar grafo
        clearGraph();
        
        // Agregar vértices
        graph.insertVertex("H"); // Centro (Hub)
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        
        // Conexiones del centro a los periféricos
        graph.insertEdge("H", "A");
        graph.insertEdge("H", "B");
        graph.insertEdge("H", "C");
        graph.insertEdge("H", "D");
        
        // Analizar y mostrar resultados
        analyzeCurrentGraph();
        
        System.out.println("RESULTADOS:");
        System.out.println("¿Es camino dirigido? " + graph.isDirectedPath());
        System.out.println("¿Es ciclo dirigido? " + graph.isDirectedCycle());
        System.out.println("¿Es rueda dirigida? " + graph.isDirectedWheel());
        System.out.println("¿Es estrella dirigida? " + graph.isDirectedStar());
        System.out.println("Tipo identificado: " + graph.identifyGraphType());
        
        System.out.println("\n" + "=".repeat(70) + "\n");
    }
    
    /**
     * Prueba 5: Reconfigurar el mismo grafo como GRAFO GENERAL
     */
    public static void resetAndTestAsGeneral() {
        System.out.println("5. RECONFIGURANDO EL MISMO GRAFO COMO GRAFO DIRIGIDO GENERAL");
        System.out.println("Estructura: Grafo irregular complejo");
        System.out.println("-".repeat(50));
        
        // Limpiar grafo
        clearGraph();
        
        // Agregar vértices
        graph.insertVertex("X");
        graph.insertVertex("Y");
        graph.insertVertex("Z");
        graph.insertVertex("W");
        graph.insertVertex("V");
        
        // Crear estructura irregular
        graph.insertEdge("X", "Y");
        graph.insertEdge("X", "Z");
        graph.insertEdge("Y", "W");
        graph.insertEdge("Z", "W");
        graph.insertEdge("Z", "V");
        graph.insertEdge("W", "V");
        graph.insertEdge("V", "X");
        graph.insertEdge("Y", "Z");
        
        // Analizar y mostrar resultados
        analyzeCurrentGraph();
        
        System.out.println("RESULTADOS:");
        System.out.println("¿Es camino dirigido? " + graph.isDirectedPath());
        System.out.println("¿Es ciclo dirigido? " + graph.isDirectedCycle());
        System.out.println("¿Es rueda dirigida? " + graph.isDirectedWheel());
        System.out.println("¿Es estrella dirigida? " + graph.isDirectedStar());
        System.out.println("Tipo identificado: " + graph.identifyGraphType());
        
        System.out.println("\n" + "=".repeat(70) + "\n");
    }
    
    /**
     * Método auxiliar para limpiar el grafo
     */
    private static void clearGraph() {
        // Limpiar todas las aristas
        graph.getEdges().clear();
        
        // Limpiar todos los vértices
        graph.getVertices().clear();
    }
    
    /**
     * Método auxiliar para analizar el grafo actual
     */
    private static void analyzeCurrentGraph() {
        System.out.println("ESTADO ACTUAL DEL GRAFO:");
        graph.printGraph();
        
        System.out.println("ANÁLISIS DE GRADOS:");
        for (var vertex : graph.getVertices()) {
            System.out.println("  " + graph.getNodeDegreeInfo(vertex.getInfo()));
        }
        
        System.out.println("¿Es fuertemente conexo? " + graph.isStronglyConnected());
        System.out.println();
    }
    
    /**
     * Método para demostrar transformaciones paso a paso
     */
    public static void demonstrateTransformation() {
        System.out.println("=== DEMOSTRACIÓN DE TRANSFORMACIÓN PASO A PASO ===\n");
        
        graph = new GraphListEdge<>(true);
        
        // Empezar con vértices básicos
        System.out.println("PASO 1: Agregar vértices A, B, C");
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.printGraph();
        
        // Crear camino parcial
        System.out.println("PASO 2: Crear camino A->B->C");
        graph.insertEdge("A", "B");
        graph.insertEdge("B", "C");
        analyzeCurrentGraph();
        
        // Transformar a ciclo
        System.out.println("PASO 3: Cerrar ciclo C->A");
        graph.insertEdge("C", "A");
        analyzeCurrentGraph();
        
        // Agregar centro para rueda
        System.out.println("PASO 4: Agregar centro H y crear rueda");
        graph.insertVertex("H");
        graph.insertEdge("H", "A");
        graph.insertEdge("H", "B");
        graph.insertEdge("H", "C");
        graph.insertEdge("A", "H");
        graph.insertEdge("B", "H");
        graph.insertEdge("C", "H");
        analyzeCurrentGraph();
        
        System.out.println("Transformación completada!");
    }
    
    /**
     * Método para probar casos específicos interactivamente
     */
    public static void testSpecificCase(String caseName) {
        System.out.println("=== PRUEBA ESPECÍFICA: " + caseName + " ===");
        
        switch (caseName.toLowerCase()) {
            case "camino":
                testAsDirectedPath();
                break;
            case "ciclo":
                resetAndTestAsCycle();
                break;
            case "rueda":
                resetAndTestAsWheel();
                break;
            case "estrella":
                resetAndTestAsStar();
                break;
            case "general":
                resetAndTestAsGeneral();
                break;
            case "transformacion":
                demonstrateTransformation();
                break;
            default:
                System.out.println("Caso no reconocido: " + caseName);
                System.out.println("Casos disponibles: camino, ciclo, rueda, estrella, general, transformacion");
        }
    }
}