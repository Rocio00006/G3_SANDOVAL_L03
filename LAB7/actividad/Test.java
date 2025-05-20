package LAB7.actividad;

import LAB7.actividad.Exceptions.ItemDuplicatedException;

public class Test {
    public static void main(String[] args) throws ItemDuplicatedException {
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

        // Buscar elementos
        System.out.println("\nBuscando elementos:");
        System.out.println("¿Existe el elemento 40? " + bst.search(40));
        System.out.println("¿Existe el elemento 90? " + bst.search(90));
    }
}
