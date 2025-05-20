package LAB7.actividad;

import LAB7.actividad.Exceptions.ItemDuplicatedException;

public class Ejercicio3 {
    public static void main(String[] args) throws ItemDuplicatedException {
        // creamos un árbol de tipo Integer
        LinkedBST<Integer> arbA = new LinkedBST<>();
        System.out.println("Creamos árbol A");
        arbA.insert(10);
        arbA.insert(5);
        arbA.insert(15);
        arbA.insert(3);
        arbA.insert(7);
        arbA.insert(12);
        arbA.insert(20);

        // dibujamos el árbol
        System.out.println("\nDibujando el árbol A");
        arbA.drawBST();

        System.out.println("****************");
        System.out.println("\nRepresentación parentética del árbol A:");
        arbA.parenthesize();
    }
}
