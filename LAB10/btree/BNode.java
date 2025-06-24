package LAB10.btree;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    protected ArrayList<E> keys; //lista claves de un nodo
    protected ArrayList<BNode<E>> childs;  //referencias a los hijos del nodo
    protected int count;        //número actual de claves del nodo
    private int idNode;         //idNode será el identificador del nodo
    private static int nextId = 0;  //para genera id consecutivos 

    //constructor inicializa las claves, n es es el max número de hijos
    public BNode(int n) {
        this.keys = new ArrayList<>(n);
        this.childs = new ArrayList<>(n + 1);
        for (int i = 0; i < n - 1; i++) //inicializamos posiciones
            this.keys.add(null);    //insertar con null
        for (int i = 0; i < n; i++) 
            this.childs.add(null);
        this.count = 0;     //un nodo incia con 0 claves
        this.idNode = nextId++; //asgina el identificador del nodo, y se incrementa a medida que se crea un nodo
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
        while (i < count && ((Comparable<E>) key).compareTo(keys.get(i)) > 0) 
            i++;
        pos[0] = i;
        return (i < count && ((Comparable<E>) key).compareTo(keys.get(i)) == 0);
    }
    //método para buscar si hay una clave
    public boolean search(E key) {
        for (int i = 0; i < count; i++) {
            if (((Comparable<E>) key).compareTo(keys.get(i)) == 0) {
                return true;
            }
        }
        return false;
    }
    //getters y setters 

    @Override
    public String toString() {
        return "Nodo " + idNode + ": " + keys.subList(0, count).toString();
    }
    public ArrayList<E> getKeys() {
        return keys;
    }
    public void setKeys(ArrayList<E> keys) {
        this.keys = keys;
    }
    public ArrayList<BNode<E>> getChilds() {
        return childs;
    }
    public void setChilds(ArrayList<BNode<E>> childs) {
        this.childs = childs;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getIdNode() {
        return idNode;
    }
    public void setIdNode(int idNode) {
        this.idNode = idNode;
    }
}

