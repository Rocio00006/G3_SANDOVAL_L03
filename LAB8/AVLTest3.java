package LAB8;

import LAB7.actividad.Exceptions.ItemDuplicatedException;

public class AVLTest3 {
    public static void main(String[] args) throws ItemDuplicatedException {
        AVLTree<Integer> avl = new AVLTree<>();
        avl.insert(50);
        avl.insert(30);
        avl.insert(70);
        avl.insert(20);
        avl.insert(40);
        avl.insert(60);
        avl.insert(80);
        avl.insert(10);
        avl.insert(25);
        avl.insert(65);

        avl.printLevels();

    }
}
