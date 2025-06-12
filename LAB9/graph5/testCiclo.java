package LAB9.graph5;

public class testCiclo {
    public static void main(String[] args) {
        GraphLink<String> grafo = new GraphLink<>();

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

    }
}
