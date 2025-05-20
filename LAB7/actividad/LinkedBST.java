package LAB7.actividad;

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
    public void destroy() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El árbol ya está vacío.");
        }
        root = null;
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

}