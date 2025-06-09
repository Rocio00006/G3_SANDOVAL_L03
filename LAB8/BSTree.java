package LAB8;

import LAB7.actividad.Exceptions.ExceptionIsEmpty;
import LAB7.actividad.Exceptions.ItemDuplicatedException;
import LAB7.actividad.Exceptions.ItemNotFoundException;

public class BSTree<E extends Comparable<E>> {
    protected Node<E> root;

    //constructor
    public BSTree() {
        root = null;
    }

    //metodo para insertar
    public void insert(E data) throws ItemDuplicatedException {
        root = insertRec(root, data);
    }

    //metodo para insertar recursivo
    protected Node<E> insertRec(Node<E> node, E data) {
        if (node == null) {
            return new Node<>(data);
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insertRec(node.left, data);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, data);
        }
        //Si es igual o 0, no se hace nada (no se permiten duplicados)¿
        return node;
    }

    //método para buscar
    public boolean search(E data) {
        return searchRec(root, data);
    }

    //método para buscar recursivo
    protected boolean searchRec(Node<E> node, E data) {
        if (node == null) {
            return false;
        }

        int cmp = data.compareTo(node.data);

        if (cmp == 0) return true;
        if (cmp < 0) return searchRec(node.left, data);
        return searchRec(node.right, data);
    }

    //método para mostrar en inorder
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    public boolean isEmpty() {
        return root == null;    //el arbol esta vacío si no hay raíz
    }
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

    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }

    protected void printInOrder(Node<E> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node + " ");
            printInOrder(node.right);
        }
    }
}
