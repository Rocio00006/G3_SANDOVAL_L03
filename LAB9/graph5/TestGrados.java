package LAB9.graph5;

public class TestGrados {
    public static void main(String[] args) {
        // Crear el grafo (por ejemplo, con String como tipo de dato)
        GraphLink<String> grafo = new GraphLink<>();

        // Agregar vértices
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");

        // Agregar aristas
        grafo.insertEdge("A", "B");
        grafo.insertEdge("A", "C");
        grafo.insertEdge("B", "C");
        grafo.insertEdge("C", "D");

        // Probar el método gradoNodo
        System.out.println("Grado del nodo A: " + grafo.gradoNodo("A")); // Debería ser 2
        System.out.println("Grado del nodo B: " + grafo.gradoNodo("B")); // Debería ser 2
        System.out.println("Grado del nodo C: " + grafo.gradoNodo("C")); // Debería ser 3
        System.out.println("Grado del nodo D: " + grafo.gradoNodo("D")); // Debería ser 1
    }
}
