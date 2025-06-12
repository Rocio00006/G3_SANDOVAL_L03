package LAB9.graph5;

public class testCiclo {
    public static void main(String[] args) {
        /*GraphLink<String> grafo = new GraphLink<>();

        //C4: A - B - C - D - A
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");

        grafo.insertEdge("A", "B");
        grafo.insertEdge("B", "A");
        grafo.insertEdge("B", "C");
        grafo.insertEdge("C", "B");
        grafo.insertEdge("C", "A");
        grafo.insertEdge("A", "C");

        // Probar si es ciclo
        //System.out.println("¿Es ciclo? " + grafo.esCiclo()); 
        System.out.println("¿Es COMPLETO? " + grafo.esCompleto()); 
        System.out.println("Representación formal: ");
        grafo.mostrarRepresentacionFormal();

        //representacion adyacencias
        System.out.println("Representación en adyacencias: ");
        //grafo.mostrarListaAdyacencias();;

        System.out.println("Representación en matriz");
        grafo.mostrarMatrizAdyacencia();*/


        //ejer 8
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

        System.out.println("Representación formal: ");
        graph.mostrarRepresentacionFormal();

        //representacion adyacencias
        System.out.println("Representación en adyacencias: ");
        graph.mostrarListaAdyacencias();;

        System.out.println("Representación en matriz");
        graph.mostrarMatrizAdyacencia();

    }
}
