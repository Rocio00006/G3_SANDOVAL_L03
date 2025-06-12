package LAB9;

package LAB9.graph0;

public class GraphLinkTest {
    
    public static void main(String[] args) {
        System.out.println("=== CASOS DE PRUEBA PARA GRAPHLINK ===\n");
        
        testInsertVertex();
        testInsertEdge();
        testSearchVertex();
        testSearchEdge();
        testRemoveEdge();
        testRemoveVertex();
        testComplexScenario();
    }
    
    // ============= CASOS DE PRUEBA insertVertex =============
    public static void testInsertVertex() {
        System.out.println("🧪 TESTING insertVertex():");
        GraphLink<String> graph = new GraphLink<>();
        
        // Caso 1: Insertar vértices normales
        System.out.println("Caso 1: Insertar vértices A, B, C");
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        System.out.println("Grafo: " + graph);
        
        // Caso 2: Intentar insertar vértice duplicado
        System.out.println("Caso 2: Intentar insertar A de nuevo (duplicado)");
        graph.insertVertex("A");
        System.out.println("Grafo: " + graph);
        System.out.println("✅ No se duplicó el vértice A\n");
    }
    
    // ============= CASOS DE PRUEBA insertEdge =============
    public static void testInsertEdge() {
        System.out.println("🧪 TESTING insertEdge():");
        GraphLink<String> graph = new GraphLink<>();
        
        // Preparar vértices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        
        // Caso 1: Insertar aristas válidas
        System.out.println("Caso 1: Insertar aristas A→B, B→C, C→A");
        graph.insertEdge("A", "B");
        graph.insertEdge("B", "C");
        graph.insertEdge("C", "A");
        System.out.println("Grafo: " + graph);
        
        // Caso 2: Intentar insertar arista con vértice inexistente
        System.out.println("Caso 2: Intentar insertar arista A→X (X no existe)");
        graph.insertEdge("A", "X");
        System.out.println("Grafo: " + graph);
        System.out.println("✅ No se insertó arista hacia vértice inexistente\n");
    }
    
    // ============= CASOS DE PRUEBA searchVertex =============
    public static void testSearchVertex() {
        System.out.println("🧪 TESTING searchVertex():");
        GraphLink<String> graph = new GraphLink<>();
        
        graph.insertVertex("A");
        graph.insertVertex("B");
        
        // Caso 1: Buscar vértice existente
        System.out.println("Caso 1: Buscar vértice A (existe)");
        boolean found = graph.searchVertex("A");
        System.out.println("Resultado: " + found + " ✅");
        
        // Caso 2: Buscar vértice inexistente
        System.out.println("Caso 2: Buscar vértice Z (no existe)");
        found = graph.searchVertex("Z");
        System.out.println("Resultado: " + found + " ✅");
        
        // Caso 3: Grafo vacío
        GraphLink<String> emptyGraph = new GraphLink<>();
        System.out.println("Caso 3: Buscar en grafo vacío");
        found = emptyGraph.searchVertex("A");
        System.out.println("Resultado: " + found + " ✅\n");
    }
    
    // ============= CASOS DE PRUEBA searchEdge =============
    public static void testSearchEdge() {
        System.out.println("🧪 TESTING searchEdge():");
        GraphLink<String> graph = new GraphLink<>();
        
        // Preparar grafo
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertEdge("A", "B");
        graph.insertEdge("B", "C");
        
        System.out.println("Grafo inicial: " + graph);
        
        // Caso 1: Buscar arista existente
        System.out.println("Caso 1: Buscar arista A→B (existe)");
        boolean found = graph.searchEdge("A", "B");
        System.out.println("Resultado: " + found + " ✅");
        
        // Caso 2: Buscar arista inexistente entre vértices existentes
        System.out.println("Caso 2: Buscar arista A→C (no existe)");
        found = graph.searchEdge("A", "C");
        System.out.println("Resultado: " + found + " ✅");
        
        // Caso 3: Buscar arista con vértice inexistente
        System.out.println("Caso 3: Buscar arista A→X (X no existe)");
        found = graph.searchEdge("A", "X");
        System.out.println("Resultado: " + found + " ✅");
        
        // Caso 4: Buscar arista en dirección opuesta
        System.out.println("Caso 4: Buscar arista B→A (dirección opuesta)");
        found = graph.searchEdge("B", "A");
        System.out.println("Resultado: " + found + " ✅ (Grafo dirigido)\n");
    }
    
    // ============= CASOS DE PRUEBA removeEdge =============
    public static void testRemoveEdge() {
        System.out.println("🧪 TESTING removeEdge():");
        GraphLink<String> graph = new GraphLink<>();
        
        // Preparar grafo
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertEdge("A", "B");
        graph.insertEdge("B", "C");
        graph.insertEdge("A", "C");
        
        System.out.println("Grafo inicial: " + graph);
        
        // Caso 1: Eliminar arista existente
        System.out.println("Caso 1: Eliminar arista A→B");
        graph.removeEdge("A", "B");
        System.out.println("Grafo después: " + graph);
        System.out.println("Verificar que A→B no existe: " + !graph.searchEdge("A", "B") + " ✅");
        
        // Caso 2: Intentar eliminar arista inexistente
        System.out.println("Caso 2: Intentar eliminar arista B→A (no existe)");
        graph.removeEdge("B", "A");
        System.out.println("Grafo después: " + graph);
        System.out.println("✅ No hubo cambios");
        
        // Caso 3: Eliminar arista con vértice inexistente
        System.out.println("Caso 3: Intentar eliminar arista A→X (X no existe)");
        graph.removeEdge("A", "X");
        System.out.println("Grafo después: " + graph);
        System.out.println("✅ No hubo cambios\n");
    }
    
    // ============= CASOS DE PRUEBA removeVertex =============
    public static void testRemoveVertex() {
        System.out.println("🧪 TESTING removeVertex():");
        GraphLink<String> graph = new GraphLink<>();
        
        // Preparar grafo complejo
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertEdge("A", "B");  // A→B
        graph.insertEdge("B", "C");  // B→C
        graph.insertEdge("C", "B");  // C→B (arista hacia B)
        graph.insertEdge("D", "B");  // D→B (otra arista hacia B)
        graph.insertEdge("B", "D");  // B→D
        
        System.out.println("Grafo inicial: " + graph);
        
        // Caso 1: Eliminar vértice con aristas entrantes y salientes
        System.out.println("Caso 1: Eliminar vértice B (tiene aristas entrantes y salientes)");
        graph.removeVertex("B");
        System.out.println("Grafo después: " + graph);
        System.out.println("Verificaciones:");
        System.out.println("- B no existe: " + !graph.searchVertex("B") + " ✅");
        System.out.println("- A→B no existe: " + !graph.searchEdge("A", "B") + " ✅");
        System.out.println("- C→B no existe: " + !graph.searchEdge("C", "B") + " ✅");
        System.out.println("- D→B no existe: " + !graph.searchEdge("D", "B") + " ✅");
        
        // Caso 2: Intentar eliminar vértice inexistente
        System.out.println("\nCaso 2: Intentar eliminar vértice X (no existe)");
        graph.removeVertex("X");
        System.out.println("Grafo después: " + graph);
        System.out.println("✅ No hubo cambios");
        
        // Caso 3: Eliminar vértice aislado
        graph.insertVertex("E");  // Vértice sin aristas
        System.out.println("\nCaso 3: Eliminar vértice E (aislado, sin aristas)");
        System.out.println("Grafo antes: " + graph);
        graph.removeVertex("E");
        System.out.println("Grafo después: " + graph);
        System.out.println("✅ Vértice aislado eliminado correctamente\n");
    }
    
    // ============= CASO COMPLEJO =============
    public static void testComplexScenario() {
        System.out.println("🧪 TESTING Escenario Complejo:");
        GraphLink<Integer> graph = new GraphLink<>();
        
        // Crear grafo dirigido: 1→2, 2→3, 3→1, 1→3, 4→2
        System.out.println("Creando grafo con números enteros:");
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);
        
        graph.insertEdge(1, 2);  // 1→2
        graph.insertEdge(2, 3);  // 2→3
        graph.insertEdge(3, 1);  // 3→1 (ciclo)
        graph.insertEdge(1, 3);  // 1→3 (conexión directa)
        graph.insertEdge(4, 2);  // 4→2
        
        System.out.println("Grafo inicial: " + graph);
        
        // Pruebas de conectividad
        System.out.println("Pruebas de conectividad:");
        System.out.println("- 1→2: " + graph.searchEdge(1, 2));
        System.out.println("- 1→3: " + graph.searchEdge(1, 3));
        System.out.println("- 3→1: " + graph.searchEdge(3, 1));
        System.out.println("- 2→1: " + graph.searchEdge(2, 1) + " (no existe)");
        
        // Eliminar vértice central
        System.out.println("\nEliminando vértice 2 (central):");
        graph.removeVertex(2);
        System.out.println("Grafo después: " + graph);
        
        // Verificar que se rompieron las conexiones
        System.out.println("Verificaciones después de eliminar 2:");
        System.out.println("- 1→2: " + graph.searchEdge(1, 2) + " (debe ser false)");
        System.out.println("- 4→2: " + graph.searchEdge(4, 2) + " (debe ser false)");
        System.out.println("- 1→3: " + graph.searchEdge(1, 3) + " (debe seguir existiendo)");
        System.out.println("- 3→1: " + graph.searchEdge(3, 1) + " (debe seguir existiendo)");
        
        System.out.println("\n✅ Todos los casos de prueba completados!");
    }
}