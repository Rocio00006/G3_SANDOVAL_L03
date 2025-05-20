package LAB7.actividad;

import LAB7.actividad.Exceptions.ItemDuplicatedException;
import LAB7.actividad.Exceptions.ItemNotFoundException;

public class Prueba {
    public static void main(String[] args) throws ItemDuplicatedException, ItemNotFoundException {
        LinkedBST<Integer> bst = new LinkedBST<>();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Recorrido InOrder:");
        bst.inOrder(); 

        /*System.out.println("Recorrido PreOrder:");
        bst.preOrder();

        System.out.println("Recorrido PostOrder:");
        bst.postOrder();*/
        

        //Prueba de findMinNode desde la raíz
        Integer min = bst.getMinFrom(bst.getRoot());
        System.out.println("Valor mínimo en el árbol: " + min);

        //Prueba de findMaxNode desde la raíz
        Integer max = bst.getMaxFrom(bst.getRoot());
        System.out.println("Valor máximo en el árbol: " + max);
    }
}
