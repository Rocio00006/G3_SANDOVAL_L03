package LAB10.btree;

public class TestToString {
    public static void main(String[] args) {
        BTree<Integer> arbol = new BTree<>(4);
        //Insertamos algunos valores
        int[] claves = {100, 50, 20, 70, 10, 30, 80, 90, 200, 25};
        for (int clave : claves) {
            arbol.insert(clave);
        }

        //Mostramos el árbol
        System.out.println("Árbol B después de inserciones:");
        System.out.println(arbol.toString());
    }
}
