package LAB10.btree;

import java.util.ArrayList;

public class BNode<E> {
    protected ArrayList<E> keys; //claves de un nodo
    protected ArrayList<BNode<E>> childs;  //referencias a los hijos del nodo
    protected int count;        //número actual de claves del nodo

    //constructor inicializa las claves, n es es el número de claves
    public BNode(int n) {
        this.keys = new ArrayList<>(n);
        this.childs = new ArrayList<>(n + 1);
        for (int i = 0; i < n - 1; i++) 
            this.keys.add(null);
        for (int i = 0; i < n; i++) 
            this.childs.add(null);
        this.count = 0;     //un nodo incia con 0 claves
    }

    //Verifica si el nodo está lleno
    public boolean nodeFull(int max) {
        return count == max;
    }

    //Verifica si el nodo está vacío
    public boolean nodeEmpty() {
        return count == 0;  //hay 0 claves en el nodo
    }

    //Busca una clave en el nodo actual
    public boolean searchNode(E key, int[] pos) {
        int i = 0;
        while (i < count && ((Comparable<E>) key).compareTo(keys.get(i)) > 0) i++;
        pos[0] = i;
        return (i < count && ((Comparable<E>) key).compareTo(keys.get(i)) == 0);
    }
    //Retorna una representación en texto del nodo actual
    @Override
    public String toString() {
        return keys.subList(0, count).toString();
    }
}