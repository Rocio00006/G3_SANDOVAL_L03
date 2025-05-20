package LAB7.actividad;

import java.util.LinkedList;
import java.util.Queue;

import LAB7.actividad.Exceptions.ExceptionIsEmpty;
import LAB7.actividad.Exceptions.ItemDuplicatedException;
import LAB7.actividad.Exceptions.ItemNotFoundException;
import LAB7.actividad.bstInterface.BinarySearchTree;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    private Node<E> root; //nodo raiz tiene las referecias resto

    public LinkedBST() {
        this.root = null;   //un arbol vacío empieza con null  
    }

    @Override
    public void insert(E data) throws ItemDuplicatedException {
        //a root se le asigna el resultado del método insertRec
        root = insertRec(root, data); //usamos recursividad
    }

    //metodo recursivo que recibe el nodo actual y el valor a insertar
    private Node<E> insertRec(Node<E> nodoAct, E data) throws ItemDuplicatedException {
        //c1 caso base el nodo es null, se inserta el un valor
        if (nodoAct == null) { 
            Node<E> nuevo = new Node<E>(data);
            return nuevo;
        }
        //comparamos si el valor a insertar es > < = que el nodo actual
        int cmp = data.compareTo(nodoAct.data); //resultado de la comparación

        if (cmp < 0) {
            //si es menor, ahora trabajmos solo con la izquierda
            nodoAct.left = insertRec(nodoAct.left, data);
        } else if (cmp > 0) {
            //si es mayor trabajamos solo con la derecha
            nodoAct.right = insertRec(nodoAct.right, data);
        } else {
            //si es igual, significa que ya existe ese elemento
            throw new ItemDuplicatedException("Elemento duplicado: " + data);
        }
        return nodoAct;
    }

    @Override
    public boolean search(E data) {
        return searchRecursive(root, data);
    }
    private boolean searchRecursive(Node<E> node, E data) {
        //si root es null, el árbol está vaio
        if (node == null) 
            return false;

        int cmp = data.compareTo(node.data);

        //si la comparación es 0, hay coincidencia
        if (cmp == 0) 
            return true;
        //si es menor, buscamos en la izquierda
        else if (cmp < 0) 
            return searchRecursive(node.left, data);
        //si es mayor buscamos en la derecha
        else 
            return searchRecursive(node.right, data);
    }

    @Override
    public boolean isEmpty() {
        return root == null;    //el arbol esta vacío si no hay raíz
    }
    @Override
    public void delete(E data) throws ExceptionIsEmpty, ItemNotFoundException {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El árbol está vacío.");
        }

        if (!search(data)) {
            throw new ItemNotFoundException("Elemento no encontrado: " + data);
        }

        root = deleteRecursive(root, data);
    }

    private Node<E> deleteRecursive(Node<E> node, E data) {
        if (node == null) return null;

        int cmp = data.compareTo(node.data);

        if (cmp < 0) {
            node.left = deleteRecursive(node.left, data);
        } 
        else if (cmp > 0) {
            node.right = deleteRecursive(node.right, data);
        } 
        else {
            // Caso 1: sin hijos
            if (node.left == null && node.right == null) {
                return null;
            }
            // Caso 2: un solo hijo
            else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // Caso 3: dos hijos
            else {
                E min = findMin(node.right);
                node.data = min;
                node.right = deleteRecursive(node.right, min);
            }
        }
        return node;
    }

    private E findMin(Node<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    @Override
    public void destroyNodes() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("árbol vacío");
        }
        root = null;
    }
    //método que cuenta todos los nodos padres y hojas
    public int countAllNodes(){
        int cantNodos;
        cantNodos = countAllNodesRec(root);
        return cantNodos;
    }
    public int countAllNodesRec(Node<E> nodo){
        //caso base que el nodo sea null
        if(nodo==null)
            return 0;
        //el nodo raíz existe, ya va un nodo
        //faltan los nodos de la izquierda y dereda
        int cantIzq = countAllNodesRec(nodo.left);
        int cantDer = countAllNodesRec(nodo.right);
        //el nodo raiz es 1
        return 1 + cantIzq + cantDer;
    }

    //método que cuenta los nodos excepto las hojas
    public int countNodes(){
        int nodosConHijos;
        nodosConHijos = countNodesRec(root);
        return nodosConHijos;
    }
    public int countNodesRec(Node<E> nodo){
        //caso base 
        //que la izq y der del nodo sea null o que sea null
        if((nodo.left ==null && nodo.right==null) || nodo==null)
            return 0;
        //raiz es 1 nodod, faltan nodos de la izquierda y dereda
        int cantIzq = countNodesRec(nodo.left);
        int cantDer = countNodesRec(nodo.right);
        return 1+cantIzq+cantDer;
    }

    //metodo que calcula la altura de un nodo determinado x
    public int height(E x){
        Node<E> subRaiz = root;

    //Primero buscamos el nodo o subRaiz que tiene x
    while (subRaiz != null) {
        int cmp = x.compareTo(subRaiz.data);
        if (cmp == 0) 
            break;
        //si la comparacion es menor va a la izquieda
        else if (cmp < 0)
            subRaiz = subRaiz.left;
        //si no es menor, es mayor va a la derecha
        else subRaiz = subRaiz.right;
    }

    //si la raiz q buscamos es null, altura será -1
    if (subRaiz == null) 
        return -1;

    // Medir altura de forma iterativa usando una cola
    Queue<Node<E>> queue = new LinkedList<>();
    queue.add(subRaiz);
    int height = -1;

    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        height++;
        for (int i = 0; i < levelSize; i++) {
            Node<E> current = queue.poll();
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    return height;
}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringInOrder(root, sb);
        return sb.toString();
    }

    private void toStringInOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            toStringInOrder(node.left, sb);
            sb.append(node.data).append(" ");
            toStringInOrder(node.right, sb);
        }
    }
    //RECORRIDO INRODER IZQ - RAIZ -DER
    public void inOrder() {
        inOrderRecursive(root);
        System.out.println(); // Salto de línea al final
    }

    private void inOrderRecursive(Node<E> node) {
        if (node != null) {
            inOrderRecursive(node.left);         //Recorre el subárbol izquierdo
            System.out.print(node.data + " ");   //Visita el nodo actual
            inOrderRecursive(node.right);        //Recorre el subárbol derecho
        }
    }

    // RECORRIDO PREORDER RAIZ - IZQ - DER
    public void preOrder() {
        preOrderRecursive(root);
        System.out.println(); // Salto de línea al final
    }

    private void preOrderRecursive(Node<E> node) {
        if (node != null) {
            System.out.print(node.data + " "); // Visita el nodo actual
            preOrderRecursive(node.left); // Recorre el subárbol izquierdo
            preOrderRecursive(node.right); // Recorre el subárbol derecho
        }
    }

    // RECORRIDO POSTORDER IZQ DER RAIZ
    public void postOrder() {
        postOrderRecursive(root);
        System.out.println(); // Salto de línea al final
    }

    private void postOrderRecursive(Node<E> node) {
        if (node != null) {
            postOrderRecursive(node.left); //Recorre el subárbol izquierdo
            postOrderRecursive(node.right); //Recorre el subárbol derecho
            System.out.print(node.data + " "); //Visita el nodo actual
        }
    }

    //acctividad 10
    //método para encontrar el menor valor de un subarbol
    private Node<E> findMinNode(Node<E> node) throws ItemNotFoundException {
        if (node == null) {
            throw new ItemNotFoundException("Subárbol vacío");
        }
        Node<E> current = node;
        while (current.left != null) {
            current = current.left;
        }
        if (!search(current.data)) {
            throw new ItemNotFoundException("El valor mínimo no se encuentra en el árbol");
        }
        return current;
    }

    //método para encontar el mayor valor de un subarbol
    private Node<E> findMaxNode(Node<E> node) throws ItemNotFoundException {
        if (node == null) {
            throw new ItemNotFoundException("Subárbol vacío");
        }

        Node<E> current = node;
        while (current.right != null) {
            current = current.right;
        }

        if (!search(current.data)) {
            throw new ItemNotFoundException("El valor máximo no se encuentra en el árbol");
        }
        return current;
    }

    // como son finMinNode y finMaxNode son privados
    // crearemos unos metodos public que retornen su valor
    public E getMinFrom(Node<E> node) throws ItemNotFoundException {
        return findMinNode(node).data;
    }

    public E getMaxFrom(Node<E> node) throws ItemNotFoundException {
        return findMaxNode(node).data;
    }

    public Node<E> getRoot() {
        return root;
    }

}