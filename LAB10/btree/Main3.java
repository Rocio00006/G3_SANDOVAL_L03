package LAB10.btree;

public class Main3 {
    public static void main(String[] args) {
        try {
            BTree<Integer> tree = BTree.building_BTree("arbolB.txt");
            System.out.println("\nÁrbol B construido desde archivo:");
            System.out.println(tree);

            System.out.println("\nBuscando 19:");
            tree.search(19);

            System.out.println("\nBuscando 50:");
            tree.search(50);

        } catch (BTree.ItemNoFound e) {
            System.out.println("Error al construir el árbol: " + e.getMessage());
        }
    }
}
