package LAB9.graph0.pruebas;

import LAB9.graph0.GraphLink;

public class RecorridosTest {
    public static void main(String[] args) {
        System.out.println("=== CASOS DE PRUEBA PARA DFS ===\n");
        
        //testDFSLineal();
        //testDFSConCiclo();
        //testDFSGrafoComplejo();
        testBFSGrafoComplejo();
        //testDFSVerticeAislado();
        //testDFSVerticeInexistente();
        //testDFSGrafoDesconectado();
    }
    
    // ============= CASO 1: GRAFO LINEAL =============
    public static void testDFSLineal() {
        System.out.println("🧪 CASO 1: DFS en Grafo Lineal");
        GraphLink<String> graph = new GraphLink<>();
        
        // Crear grafo lineal: A -> B -> C -> D
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        
        graph.insertEdge("A", "B");
        graph.insertEdge("B", "C");
        graph.insertEdge("C", "D");
        
        System.out.println("Grafo: A -> B -> C -> D");
        System.out.println("Estructura: " + graph);
        
        System.out.println("DFS desde diferentes vértices:");
        graph.dfs("A");  // Debería visitar: A B C D
        graph.dfs("B");  // Debería visitar: B C D
        graph.dfs("C");  // Debería visitar: C D
        graph.dfs("D");  // Debería visitar: D
        System.out.println();

    }
    
    // ============= CASO 2: GRAFO CON CICLO =============
    public static void testDFSConCiclo() {
        System.out.println("🧪 CASO 2: DFS en Grafo con Ciclo");
        GraphLink<String> graph = new GraphLink<>();
        
        // Crear grafo con ciclo: A -> B -> C -> A
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        
        graph.insertEdge("A", "B");
        graph.insertEdge("B", "C");
        graph.insertEdge("C", "A");  // Ciclo
        
        System.out.println("Grafo: A -> B -> C -> A (ciclo)");
        System.out.println("Estructura: " + graph);
        
        System.out.println("DFS desde diferentes vértices:");
        graph.dfs("A");  // Debería visitar: A B C (sin repetir A)
        graph.dfs("B");  // Debería visitar: B C A
        graph.dfs("C");  // Debería visitar: C A B
        System.out.println();
    }
    
    // ============= CASO 3: GRAFO COMPLEJO =============
    public static void testDFSGrafoComplejo() {
        System.out.println("C3: Recorrido DFS");
        GraphLink<Integer> graph = new GraphLink<>();
        // Crear grafo más complejo:
        //     1 -> 2 -> 4
        //     ↓   ↓   ↑
        //     3 -> 5 -> 6
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);
        graph.insertVertex(5);
        graph.insertVertex(6);
        
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(2, 5);
        graph.insertEdge(3, 5);
        graph.insertEdge(5, 6);
        graph.insertEdge(6, 4);
        
        System.out.println("Grafo complejo:");
        System.out.println("Estructura:\n" + graph);
        
        System.out.println("DFS desde diferentes vértices:");
        graph.dfs(1);  //Explorará todo el grafo desde 1
        graph.dfs(2);  //Explorará desde 2
        graph.dfs(5);  //Explorará desde 5
        System.out.println();
    }
    // ============= C3.2: RECORRIDO AMPLITUD bfs =============
    public static void testBFSGrafoComplejo() {
        System.out.println("Recorrido BFS");
        GraphLink<Integer> graph = new GraphLink<>();

        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);
        graph.insertVertex(5);
        graph.insertVertex(6);
        
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(2, 5);
        graph.insertEdge(3, 5);
        graph.insertEdge(5, 6);
        graph.insertEdge(6, 4);
        
        System.out.println("Grafo complejo:");
        System.out.println("Estructura:\n" + graph);
        
        System.out.println("DFS desde diferentes vértices:");
        graph.bfs(1);  //Explorará todo el grafo desde 1
        graph.bfs(2);  //Explorará desde 2
        graph.bfs(5);  //Explorará desde 5
        System.out.println();
    }
    
    // ============= CASO 4: VÉRTICE AISLADO =============
    public static void testDFSVerticeAislado() {
        System.out.println("🧪 CASO 4: DFS con Vértice Aislado");
        GraphLink<String> graph = new GraphLink<>();
        
        // Crear grafo con vértice aislado
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("AISLADO");
        
        graph.insertEdge("A", "B");
        graph.insertEdge("B", "C");
        // AISLADO no tiene conexiones
        
        System.out.println("Grafo: A -> B -> C, AISLADO (sin conexiones)");
        System.out.println("Estructura: " + graph);
        
        System.out.println("DFS desde diferentes vértices:");
        graph.dfs("A");        // Debería visitar: A B C
        graph.dfs("AISLADO");  // Debería visitar: AISLADO (solo él)
        System.out.println();
    }
    
    // ============= CASO 5: VÉRTICE INEXISTENTE =============
    public static void testDFSVerticeInexistente() {
        System.out.println("🧪 CASO 5: DFS con Vértice Inexistente");
        GraphLink<String> graph = new GraphLink<>();
        
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertEdge("A", "B");
        
        System.out.println("Grafo: A -> B");
        System.out.println("Intentando DFS desde vértice inexistente:");
        graph.dfs("X");  // Debería mostrar mensaje de error
        System.out.println();
    }
    
    // ============= CASO 6: GRAFO DESCONECTADO =============
    public static void testDFSGrafoDesconectado() {
        System.out.println("🧪 CASO 6: DFS en Grafo Desconectado");
        GraphLink<String> graph = new GraphLink<>();
        
        // Crear dos componentes desconectadas:
        // Componente 1: A -> B -> C
        // Componente 2: X -> Y
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("X");
        graph.insertVertex("Y");
        
        graph.insertEdge("A", "B");
        graph.insertEdge("B", "C");
        graph.insertEdge("X", "Y");
        
        System.out.println("Grafo desconectado:");
        System.out.println("Componente 1: A -> B -> C");
        System.out.println("Componente 2: X -> Y");
        System.out.println("Estructura: " + graph);
        
        System.out.println("DFS desde diferentes componentes:");
        graph.dfs("A");  // Debería visitar solo: A B C
        graph.dfs("X");  // Debería visitar solo: X Y
        System.out.println();
    }
    
    // ============= MÉTODO ADICIONAL: DFS COMPLETO =============
    public static void demonstrateDFSBehavior() {
        System.out.println("🔍 DEMOSTRACIÓN: Comportamiento del DFS");
        GraphLink<String> graph = new GraphLink<>();
        
        // Grafo con múltiples caminos:
        //   A -> B -> D
        //   ↓   ↓   ↓
        //   C -> E -> F
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        
        graph.insertEdge("A", "B");
        graph.insertEdge("A", "C");
        graph.insertEdge("B", "D");
        graph.insertEdge("B", "E");
        graph.insertEdge("C", "E");
        graph.insertEdge("D", "F");
        graph.insertEdge("E", "F");
        
        System.out.println("Grafo con múltiples caminos:");
        System.out.println("A -> B -> D");
        System.out.println("↓   ↓   ↓");
        System.out.println("C -> E -> F");
        
        System.out.println("\nNota: DFS explora en profundidad antes de ir a los hermanos");
        graph.dfs("A");
        System.out.println("El orden puede variar según el orden de inserción de aristas");
    }
}
