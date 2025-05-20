package LAB7.actividad;

import LAB7.actividad.Exceptions.ItemDuplicatedException;

public class Ejercicio2c {
    public static void main(String[] args) throws ItemDuplicatedException {
        //creamos un árbol de tipo Integer
        LinkedBST<Integer> arbA = new LinkedBST<>();
        System.out.println("Creamos árbol A");
            arbA.insert(10);
            arbA.insert(5);
            arbA.insert(15);
            arbA.insert(3);
            arbA.insert(7);
            arbA.insert(12);
            arbA.insert(20);
        //área del árbol
        int areaA = arbA.areaBST();
        System.out.println("Área del árbol A: " + areaA);

        //dibujamos el árbol
        System.out.println("\nDibujando el árbol A");
        arbA.drawBST();

        

        System.out.println("****************");

        //creamos un árbol B
        System.out.println("\nCreamos un árbol B");
        LinkedBST<Integer> arbB = new LinkedBST<>();

            arbB.insert(30);
            arbB.insert(25);
            arbB.insert(35);
            arbB.insert(23);
            arbB.insert(28);
            arbB.insert(33);
            arbB.insert(40);
        

        System.out.println("Dibujando el árbol B");
        arbB.drawBST();

        int areaB = arbB.areaBST();
        System.out.println("Área del árbol B: " + areaB);

        System.out.println("----------------------------------");

        // Comparación de áreas
        boolean mismaArea = sameArea(arbA, arbB);
        System.out.println("Árbol A y B tienen la misma área: " + mismaArea);
    }
    public static <E extends Comparable<E>> boolean sameArea(LinkedBST<E> a, LinkedBST<E> b) {
        return a.areaBST() == b.areaBST();
    }
}
