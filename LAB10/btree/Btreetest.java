package LAB10.btree;

public class Btreetest {
    public static void main(String[] args) {
        BTree<Integer> btree = new BTree<>(5); // Árbol B de orden 5

        //Inserciones iniciales
        int[] elementos = {100, 50, 20, 70, 10, 30, 80, 90, 200, 25, 15, 5, 65, 35, 60, 18, 93, 94};
        for (int el : elementos) {
            System.out.println("Insertando: " + el);
            btree.insert(el);
        }

        System.out.println("\nÁrbol después de inserciones:");
        System.out.println(btree);

        //Búsquedas
        System.out.println("\nBuscando 70:");
        btree.search(70);

        System.out.println("\nBuscando 999:");
        btree.search(999);

        //Eliminaciones
        int[] eliminaciones = {70, 25, 10, 100};
        for (int el : eliminaciones) {
            System.out.println("\nEliminando: " + el);
            btree.remove(el);
            System.out.println("Árbol después de eliminar " + el + ":");
            System.out.println(btree);
        }
    }
}
