package LAB9.graph5;

public class TestGrafo {
        // Método main para testing
    public static void main(String[] args) {
        System.out.println("=== TESTING MÉTODOS DE GRAFO ===\n");
        
        // Test Camino P4
        System.out.println("--- Test Camino P4 ---");
        Grafo p4 = crearCamino(4);
        p4.imprimirGrafo();
        System.out.println("Es camino: " + p4.esCamino());
        System.out.println("Grado del nodo 0: " + p4.gradoNodo(0));
        System.out.println("Grado del nodo 1: " + p4.gradoNodo(1));
        System.out.println();
        
        // Test Ciclo C5
        System.out.println("--- Test Ciclo C5 ---");
        Grafo c5 = crearCiclo(5);
        c5.imprimirGrafo();
        System.out.println("Es ciclo: " + c5.esCiclo());
        System.out.println("Grado del nodo 0: " + c5.gradoNodo(0));
        System.out.println();
        
        // Test Rueda W5
        System.out.println("--- Test Rueda W5 ---");
        Grafo w5 = crearRueda(5);
        w5.imprimirGrafo();
        System.out.println("Es rueda: " + w5.esRueda());
        System.out.println("Grado del nodo central (0): " + w5.gradoNodo(0));
        System.out.println("Grado del nodo externo (1): " + w5.gradoNodo(1));
        System.out.println();
        
        // Test Completo K4
        System.out.println("--- Test Completo K4 ---");
        Grafo k4 = crearCompleto(4);
        k4.imprimirGrafo();
        System.out.println("Es completo: " + k4.esCompleto());
        System.out.println("Grado del nodo 0: " + k4.gradoNodo(0));
        System.out.println();
        
        // Test casos negativos
        System.out.println("--- Test Casos Negativos ---");
        System.out.println("P4 es ciclo: " + p4.esCiclo());
        System.out.println("C5 es camino: " + c5.esCamino());
        System.out.println("W5 es completo: " + w5.esCompleto());
        System.out.println("K4 es rueda: " + k4.esRueda());
    }
}
