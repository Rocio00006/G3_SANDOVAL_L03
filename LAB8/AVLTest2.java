package LAB8;

public class AVLTest2 {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> avl = new AVLTree<>();

            System.out.println("Insertando elementos...");
            int[] elementos = {30, 10, 50, 5, 20, 40, 60, 35, 45};
            for (int el : elementos) {
                avl.insert(el);
            }
            System.out.println("Árbol AVL después de inserciones:");
            avl.printInOrder(); 
            System.out.println("Altura: " + avl.getHeight());

            System.out.println("\nEliminando hoja (5)...");
            avl.remove(5);
            avl.printInOrder();
            System.out.println("Altura: " + avl.getHeight());

            System.out.println("\nEliminando nodo con un hijo (60)...");
            avl.remove(60);
            avl.printInOrder();
            System.out.println("Altura: " + avl.getHeight());

            System.out.println("\nEliminando nodo con dos hijos (30)...");
            avl.remove(30);
            avl.printInOrder();
            System.out.println("Altura: " + avl.getHeight());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
