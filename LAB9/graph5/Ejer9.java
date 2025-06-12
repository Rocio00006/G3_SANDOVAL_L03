package LAB9.graph5;

public class Ejer9 {
    public static void main(String[] args) {
        GraphLink<Integer> grafo = new GraphLink<>();

        // Insertar vértices
        grafo.insertVertex(1);
        grafo.insertVertex(2);
        grafo.insertVertex(3);
        grafo.insertVertex(4);

        // Insertar aristas para formar un cuadrado
        grafo.insertEdge(1, 2);
        grafo.insertEdge(2, 3);
        grafo.insertEdge(3, 4);
        grafo.insertEdge(4, 1);

        //Mostrar el grafo
        System.out.println("=== GRAFO CREADO ===");
        grafo.mostrarRepresentacionFormal();
        grafo.mostrarListaAdyacencias();
        System.out.println();

        // Crear un segundo grafo para probar isomorfismo
        GraphLink<Integer> grafo2 = new GraphLink<>();
        grafo2.insertVertex(5);
        grafo2.insertVertex(6);
        grafo2.insertVertex(7);
        grafo2.insertVertex(8);

        // Mismo patrón de conexiones pero con diferentes etiquetas
        grafo2.insertEdge(5, 6);
        grafo2.insertEdge(6, 7);
        grafo2.insertEdge(7, 8);
        grafo2.insertEdge(8, 5);

        // Análisis del grafo
        System.out.println("=== ANÁLISIS DEL GRAFO ===");
        System.out.println("¿Es isomorfo con el segundo grafo?: " +
                (grafo.esIsomorfo(grafo2) ? "SÍ" : "NO"));
        System.out.println("¿Es plano?: " + (grafo.esPlano() ? "SÍ" : "NO"));
        System.out.println("¿Es conexo?: " + (grafo.isConexo() ? "SÍ" : "NO"));
        System.out.println("¿Es auto-complementario?: " + (grafo.esAutoComplementario() ? "SÍ" : "NO"));
    }

        /*GraphLink<String> grafo = new GraphLink<>();
        
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");
        grafo.insertVertex("E");
        
        grafo.insertEdge("A", "B");
        grafo.insertEdge("B", "C");
        grafo.insertEdge("C", "D");
        grafo.insertEdge("D", "E");
        grafo.insertEdge("E", "A");
        grafo.insertEdge("A", "C");
        */
    


}
