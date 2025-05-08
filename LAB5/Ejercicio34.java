package LAB5;

public class Ejercicio34 {
    public static <T> void insertarAlFinal(Node<T> head, T valor){
        Node<T> nuevo = new Node<T>(valor);
        Node<T> actu = head;

        while(actu.getNext()!=null){
            actu = actu.getNext(); //llegar al ult nodo
        }   
        actu.setNext(nuevo); //agregamos nodo
    }
    public static <T> int contarNodos(Node<T> head){
        int conta =0;
        Node<T> aux = head;
        while (aux != null) {
            conta++;
            aux = aux.getNext();
        }
        return conta;
    } 

    public static <T> void mostrar(Node<T> head){
        //mostramos
        Node<T> aux = head;
        while (aux != null) {
            System.out.println(aux.getValor());
            aux = aux.getNext();
        }
    }
    public static void main(String[] args) {
        //creamos una lista enlazada con algunos valores
        LinkedList<String> lista = new LinkedList<>();
        lista.insertFinal("Chio");
        lista.insertFinal("Azul");
        lista.insertFinal("Samanra");
        System.out.println("LISTA INICIAL: ");
        lista.print();

        Node<String> nodos = lista.getFirstNode();  //nodo que se enviará
        /*String val = "Marcos";  //creamos el valor T a enviar
        
        System.out.println("PROBAMOS INSERTAR AL FINAL");
        insertarAlFinal(nodos, val);
        System.out.println("LISTA QUEDA ASÍ: ");
        mostrar(nodos);*/

        System.out.println("CUÁNTOS NODOS HAY? " + contarNodos(nodos));
    }
}
