package LAB7.actividad;

import LAB7.actividad.Exceptions.*;
import LAB7.actividad.bstInterface.BinarySearchTree;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    private Node<E> root;

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insertRecursive(root, data);
    }

    private Node<E> insertRecursive(Node<E> node, E data) throws ItemDuplicated {
        if (node == null) {
            return new Node<>(data);
        }

        int cmp = data.compareTo(node.data);

        if (cmp < 0) {
            node.left = insertRecursive(node.left, data);
        } else if (cmp > 0) {
            node.right = insertRecursive(node.right, data);
        } else {
            throw new ItemDuplicated("Elemento duplicado: " + data);
        }

        return node;
    }

    @Override
    public boolean search(E data) {
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(Node<E> node, E data) {
        if (node == null) return false;

        int cmp = data.compareTo(node.data);

        if (cmp == 0) return true;
        else if (cmp < 0) return searchRecursive(node.left, data);
        else return searchRecursive(node.right, data);
    }

    @Override
    public void delete(E data) {
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
        } else if (cmp > 0) {
            node.right = deleteRecursive(node.right, data);
        } else {
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
    public void destroy() {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El árbol ya está vacío.");
        }
        root = null; // El garbage collector de Java libera la memoria.
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
}