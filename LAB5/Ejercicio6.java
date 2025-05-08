package LAB5;

public class Ejercicio6 {
    public static <T> LinkedList<T> concatenarListas(LinkedList<T> l1, LinkedList<T> l2){
        //vamos a juntar todo en la lista 1
        Node<T> aux = l1.getFirstNode();
        while(aux.getNext() !=null){
            aux=aux.getNext();
        }
        aux.setNext(l2.getFirstNode());
        return l1;
    }
    public static void main(String[] args) {
        //creamos dos listas enlazadas
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.insertFinal(20);
        l1.insertFinal(15);
        System.out.println("Lista 1");
        l1.print();

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.insertFinal(40);
        l2.insertFinal(5555);
        System.out.println("Lista 2");
        l2.print();

        System.out.println("Concatenamos");
        LinkedList<Integer> LFinal = concatenarListas(l1, l2);
        LFinal.print();
    }
}
