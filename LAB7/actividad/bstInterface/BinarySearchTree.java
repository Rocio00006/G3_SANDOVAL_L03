package LAB7.actividad.bstInterface;

import LAB7.actividad.Exceptions.ExceptionIsEmpty;

public interface BinarySearchTree<E> {
    void insert(E data);          //Inserta un elemento en el BST
    void delete(E data);          //Elimina un elemento del BST
    boolean search(E data);       //Verifica si un elemento está en el BST
    boolean isEmpty();            //Verifica si el árbol está vacío
    void destroy() throws ExceptionIsEmpty;               //Elimina todos los nodos del árbol
    String toString();  
}
