package LAB9.graph5;

public class testRueda {
    public static void main(String[] args) {
        GraphLink<String> grafo = new GraphLink<>();

        // Crear vértices (W5: un centro + 4 en el ciclo)
        grafo.insertVertex("C"); // Nodo central
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("D");
        grafo.insertVertex("E");

        // Conectar nodo central a todos los demás
        grafo.insertEdge("C", "A");
        grafo.insertEdge("C", "B");
        grafo.insertEdge("C", "D");
        grafo.insertEdge("C", "E");
        grafo.insertEdge("A", "C");
        grafo.insertEdge("B", "C");
        grafo.insertEdge("D", "C");
        grafo.insertEdge("E", "C");

        // Conectar nodos externos en un ciclo: A - B - D - E - A
        grafo.insertEdge("A", "B");
        grafo.insertEdge("B", "A");
        grafo.insertEdge("B", "D");
        grafo.insertEdge("D", "B");
        grafo.insertEdge("D", "E");
        grafo.insertEdge("E", "D");
        grafo.insertEdge("E", "A");
        grafo.insertEdge("A", "E");

        System.out.println("¿Es rueda? " + grafo.esRueda()); // Debería imprimir true

    }
}
