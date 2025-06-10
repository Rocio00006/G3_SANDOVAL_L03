package LAB8;

import LAB7.actividad.Exceptions.ItemDuplicatedException;

public class AVLTest4 {
    public static void main(String[] args) throws ItemDuplicatedException {
        System.out.println("Prueba 1");
        AVLTree<Integer> avl1 = new AVLTree<>();
        System.out.println("Insertando: 25, 54, 55, 90");
        avl1.insert(25);
        avl1.insert(54);
        avl1.insert(55);
        avl1.insert(90);
        avl1.preOrder();

        System.out.println("\nPrueba 2");
        AVLTree<Integer> avl2 = new AVLTree<>();
        System.out.println("Insertando: 30, 20, 40, 10, 25, 5");
        avl2.insert(30);
        avl2.insert(20);
        avl2.insert(40);
        avl2.insert(10);
        avl2.insert(25);
        avl2.insert(5);
        avl2.preOrder(); 
    }
}
