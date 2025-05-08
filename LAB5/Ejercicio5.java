package LAB5;

public class Ejercicio5 {
    public static <T> boolean sonIguales(LinkedList<T> li1, LinkedList<T> li2){
        Node<T> n1 = li1.getFirstNode();
        Node<T> n2 = li2.getFirstNode();

        boolean iguales = false;
        while (n1 != null && n2 != null) {
            if (!n1.getValor().equals(n2.getValor())) {
                iguales = false;
            }
            n1 = n1.getNext();
            n2 = n2.getNext();
        }
        //dignifica que ambos llegaron al final
        if(n1==null && n2==null)
            iguales = true;
        return iguales;
    }
    public static void main(String[] args) {
        //creamos dos listas enlazadas
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.insertFinal(20);
        l1.insertFinal(15);
        l1.print();

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.insertFinal(20);
        l2.insertFinal(5);
        l2.print();

        System.out.println("SON IGUALES?: "+sonIguales(l1, l2));
        
    }
}
