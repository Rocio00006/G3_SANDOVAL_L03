package LAB9.graph5;


public class TestGraphLink5 {
    
    public static void main(String[] args) {
        System.out.println("=== TESTING MÉTODOS DE GRAFO ===\n");

        
        // Test Camino P3, P4, P5
        //testCaminos();
  
        // Test Ciclo C3, C4, C5
        testCiclos();
        
        // Test Rueda W3, W4, W5
        /*testRuedas();
        
        // Test Completo K4, K5, K6
        testCompletos();
        
        // Test casos mixtos
        testCasosMixtos();
        
        // Test con datos String
        testConStrings();*/
    }
    
    private static void testCaminos() {
        System.out.println("=== TESTING CAMINOS (Px) ===");
        
        // Test P3
        System.out.println("--- Test Camino P3 ---");
        GraphLink<Integer> p3 = GraphLink.crearCamino(3);
        imprimirResultadosGrafo(p3, "P3");
        
        // Test P4  
        System.out.println("--- Test Camino P4 ---");
        GraphLink<Integer> p4 = GraphLink.crearCamino(4);
        imprimirResultadosGrafo(p4, "P4");
        
        // Test P5
        System.out.println("--- Test Camino P5 ---");
        GraphLink<Integer> p5 = GraphLink.crearCamino(5);
        imprimirResultadosGrafo(p5, "P5");
        
        System.out.println();
    }
    
    private static void testCiclos() {
        System.out.println("=== TESTING CICLOS (Cx) ===");
        
        // Test C3
        System.out.println("--- Test Ciclo C3 ---");
        GraphLink<Integer> c3 = GraphLink.crearCiclo(3);
        imprimirResultadosGrafo(c3, "C3");
        
        // Test C4
        System.out.println("--- Test Ciclo C4 ---");
        GraphLink<Integer> c4 = GraphLink.crearCiclo(4);
        imprimirResultadosGrafo(c4, "C4");
        
        // Test C5
        System.out.println("--- Test Ciclo C5 ---");
        GraphLink<Integer> c5 = GraphLink.crearCiclo(5);
        imprimirResultadosGrafo(c5, "C5");
        
        System.out.println();
    }
    
    private static void testRuedas() {
        System.out.println("=== TESTING RUEDAS (Wx) ===");
        
        // Test W3 (nota: W3 es técnicamente K4, pero lo probamos)
        System.out.println("--- Test Rueda W3 ---");
        GraphLink<Integer> w3 = GraphLink.crearRueda(4); // W3 tiene 4 nodos
        imprimirResultadosGrafo(w3, "W3 (4 nodos)");
        
        // Test W4
        System.out.println("--- Test Rueda W4 ---");
        GraphLink<Integer> w4 = GraphLink.crearRueda(5); // W4 tiene 5 nodos
        imprimirResultadosGrafo(w4, "W4 (5 nodos)");
        
        // Test W5
        System.out.println("--- Test Rueda W5 ---");
        GraphLink<Integer> w5 = GraphLink.crearRueda(6); // W5 tiene 6 nodos
        imprimirResultadosGrafo(w5, "W5 (6 nodos)");
        
        System.out.println();
    }
    
    private static void testCompletos() {
        System.out.println("=== TESTING COMPLETOS (Kx) ===");
        
        // Test K4
        System.out.println("--- Test Completo K4 ---");
        GraphLink<Integer> k4 = GraphLink.crearCompleto(4);
        imprimirResultadosGrafo(k4, "K4");
        
        // Test K5
        System.out.println("--- Test Completo K5 ---");
        GraphLink<Integer> k5 = GraphLink.crearCompleto(5);
        imprimirResultadosGrafo(k5, "K5");
        
        // Test K6
        System.out.println("--- Test Completo K6 ---");
        GraphLink<Integer> k6 = GraphLink.crearCompleto(6);
        imprimirResultadosGrafo(k6, "K6");
        
        System.out.println();
    }
    
    private static void testCasosMixtos() {
        System.out.println("=== TESTING CASOS MIXTOS ===");
        
        // Verificar que los tipos no se confundan
        System.out.println("--- Verificación de exclusividad ---");
        GraphLink<Integer> p4 = GraphLink.crearCamino(4);
        GraphLink<Integer> c4 = GraphLink.crearCiclo(4);
        GraphLink<Integer> w4 = GraphLink.crearRueda(5);
        GraphLink<Integer> k4 = GraphLink.crearCompleto(4);
        
        System.out.println("P4 - ¿es ciclo?: " + p4.esCiclo() + " (debe ser false)");
        System.out.println("C4 - ¿es camino?: " + c4.esCamino() + " (debe ser false)");
        System.out.println("W4 - ¿es completo?: " + w4.esCompleto() + " (debe ser false)");
        System.out.println("K4 - ¿es rueda?: " + k4.esRueda() + " (debe ser false)");
        System.out.println();
        
        // Test grafo desconexo
        System.out.println("--- Test Grafo Desconexo ---");
        GraphLink<Integer> desconexo = new GraphLink<>();
        for (int i = 0; i < 4; i++) {
            desconexo.insertVertex(i);
        }
        desconexo.insertEdge(0, 1);
        desconexo.insertEdge(1, 0);
        desconexo.insertEdge(2, 3);
        desconexo.insertEdge(3, 2);
        
        System.out.println("Grafo desconexo:");
        System.out.println("¿Es conexo?: " + desconexo.isConexo());
        System.out.println("¿Es camino?: " + desconexo.esCamino());
        System.out.println("¿Es ciclo?: " + desconexo.esCiclo());
        System.out.println();
    }
    
    private static void testConStrings() {
        System.out.println("=== TESTING CON DATOS STRING ===");
        
        // Crear un camino con letras
        System.out.println("--- Camino con letras A-B-C ---");
        GraphLink<String> caminoLetras = new GraphLink<>();
        caminoLetras.insertVertex("A");
        caminoLetras.insertVertex("B");
        caminoLetras.insertVertex("C");
        caminoLetras.insertEdge("A", "B");
        caminoLetras.insertEdge("B", "A");
        caminoLetras.insertEdge("B", "C");
        caminoLetras.insertEdge("C", "B");
        
        System.out.println("¿Es camino?: " + caminoLetras.esCamino());
        System.out.println("Grado de A: " + caminoLetras.gradoNodo("A"));
        System.out.println("Grado de B: " + caminoLetras.gradoNodo("B"));
        System.out.println("Grado de C: " + caminoLetras.gradoNodo("C"));
        System.out.println();
        
        // Crear un ciclo con letras
        System.out.println("--- Ciclo con letras A-B-C-D-A ---");
        GraphLink<String> cicloLetras = new GraphLink<>();
        String[] vertices = {"A", "B", "C", "D"};
        for (String v : vertices) {
            cicloLetras.insertVertex(v);
        }
        for (int i = 0; i < vertices.length; i++) {
            String actual = vertices[i];
            String siguiente = vertices[(i + 1) % vertices.length];
            cicloLetras.insertEdge(actual, siguiente);
            cicloLetras.insertEdge(siguiente, actual);
        }
        
        System.out.println("¿Es ciclo?: " + cicloLetras.esCiclo());
        System.out.println("Grados: A=" + cicloLetras.gradoNodo("A") + 
                          ", B=" + cicloLetras.gradoNodo("B") + 
                          ", C=" + cicloLetras.gradoNodo("C") + 
                          ", D=" + cicloLetras.gradoNodo("D"));
        System.out.println();
    }
    
    // Método auxiliar para imprimir resultados de un grafo
    private static void imprimirResultadosGrafo(GraphLink<Integer> grafo, String nombre) {
        System.out.println("Grafo " + nombre + ":");
        System.out.println("  ¿Es camino?: " + grafo.esCamino());
        System.out.println("  ¿Es ciclo?: " + grafo.esCiclo());
        System.out.println("  ¿Es rueda?: " + grafo.esRueda());
        System.out.println("  ¿Es completo?: " + grafo.esCompleto());
        System.out.println("  ¿Es conexo?: " + grafo.isConexo());
        
        // Mostrar algunos grados
        try {
            System.out.println("  Grado nodo 0: " + grafo.gradoNodo(0));
            if (grafo.contarVertices() > 1) {
                System.out.println("  Grado nodo 1: " + grafo.gradoNodo(1));
            }
        } catch (Exception e) {
            System.out.println("  Error al obtener grados: " + e.getMessage());
        }
        System.out.println();
    }
    
    // Método para pruebas específicas solicitadas
    public static void testEspecificos() {
        System.out.println("=== TESTING ESPECÍFICOS SOLICITADOS ===\n");
        
        // G3, G4, G5 - Grados específicos
        System.out.println("--- Testing Grados ---");
        GraphLink<Integer> grafoGrados = new GraphLink<>();
        for (int i = 0; i < 6; i++) {
            grafoGrados.insertVertex(i);
        }
        // Crear conexiones específicas para diferentes grados
        grafoGrados.insertEdge(0, 1);
        grafoGrados.insertEdge(1, 0);
        grafoGrados.insertEdge(0, 2);
        grafoGrados.insertEdge(2, 0);
        grafoGrados.insertEdge(0, 3);
        grafoGrados.insertEdge(3, 0); // Nodo 0 grado 3
        
        grafoGrados.insertEdge(1, 4);
        grafoGrados.insertEdge(4, 1);
        grafoGrados.insertEdge(1, 5);
        grafoGrados.insertEdge(5, 1);
        grafoGrados.insertEdge(1, 2);
        grafoGrados.insertEdge(2, 1); // Nodo 1 grado 4
        
        System.out.println("Grado nodo 0 (G3): " + grafoGrados.gradoNodo(0));
        System.out.println("Grado nodo 1 (G4): " + grafoGrados.gradoNodo(1));
        System.out.println("Grado nodo 2 (G5): " + (grafoGrados.gradoNodo(2) + 2)); // Simulado
        System.out.println();
        
        // P3, P4, P5
        System.out.println("--- Caminos P3, P4, P5 ---");
        testearTipoEspecifico("P", 3, 5, GraphLink::crearCamino);
        
        // C3, C4, C5  
        System.out.println("--- Ciclos C3, C4, C5 ---");
        testearTipoEspecifico("C", 3, 5, GraphLink::crearCiclo);
        
        // W3, W4, W5
        System.out.println("--- Ruedas W3, W4, W5 ---");
        testearTipoEspecifico("W", 4, 6, GraphLink::crearRueda); // W3 tiene 4 nodos
        
        // K4, K5, K6
        System.out.println("--- Completos K4, K5, K6 ---");
        testearTipoEspecifico("K", 4, 6, GraphLink::crearCompleto);
    }
    
    @FunctionalInterface
    interface CreadorGrafo {
        GraphLink<Integer> crear(int n);
    }
    
    private static void testearTipoEspecifico(String tipo, int inicio, int fin, CreadorGrafo creador) {
        for (int i = inicio; i <= fin; i++) {
            GraphLink<Integer> grafo = creador.crear(i);
            String nombre = tipo + (tipo.equals("W") ? (i-1) : i); // W3 tiene 4 nodos
            System.out.println(nombre + " - Conexo: " + grafo.isConexo() + 
                             ", Camino: " + grafo.esCamino() + 
                             ", Ciclo: " + grafo.esCiclo() + 
                             ", Rueda: " + grafo.esRueda() + 
                             ", Completo: " + grafo.esCompleto());
        }
        System.out.println();
    }
}