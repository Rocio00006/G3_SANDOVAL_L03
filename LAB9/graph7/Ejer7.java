package LAB9.graph7;

public class Ejer7 {
    public static void main(String[] args) {
        // Crear un grafo dirigido
        GraphLink<String> grafoDirigido = new GraphLink<>();

        // Agregar vértices
        grafoDirigido.insertVertex("A");
        grafoDirigido.insertVertex("B");
        grafoDirigido.insertVertex("C");

        // Agregar aristas dirigidas
        grafoDirigido.insertDirectedEdge("A", "B");
        grafoDirigido.insertDirectedEdge("B", "C");

        // Analizar el grafo
        grafoDirigido.analizarGrafoDirigido();

        // Ver grados de un nodo específico
        grafoDirigido.mostrarGradosNodoDirigido("B");
    }
}
