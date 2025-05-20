package LAB7.actividad;

import LAB7.actividad.Exceptions.ExceptionIsEmpty;
import LAB7.actividad.Exceptions.ItemDuplicatedException;
import LAB7.actividad.Exceptions.ItemNotFoundException;

public class Test {
    public static void main(String[] args) throws ItemDuplicatedException, ExceptionIsEmpty, ItemNotFoundException {
        //creamos un nuevo BST de tipo Integer
        System.out.println("Creando un árbol binario de búsqueda...");
        LinkedBST<Integer> bst = new LinkedBST<>();

        System.out.println("\nInsertando elementos: 50, 30, 70, 20, 40, 60, 80");
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        //buscar elementos
        /*System.out.println("\nBuscando elementos:");
        System.out.println("¿Existe el elemento 40? " + bst.search(40));
        System.out.println("¿Existe el elemento 90? " + bst.search(90));*/

        /*System.out.println("árbol antes de eliminar, (in-order): " + bst);
        //eliminar elementos
        System.out.println("\nEliminando elemento 30:");
        bst.delete(30);
        System.out.println("árbol ahora, (in-order): " + bst);*/

        System.out.println("\nMostrando árbol: ");
        System.out.println(bst);
    }
}
