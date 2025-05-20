package LAB7.actividad.bstInterface;

import LAB7.actividad.Exceptions.*;

public interface BinarySearchTree<E> {
    void insert(E data) throws ItemDuplicatedException;          
    void delete(E data) throws ExceptionIsEmpty, ItemNotFoundException;        
    boolean search(E data);       
    boolean isEmpty();            
    void destroy() throws ExceptionIsEmpty;              
    String toString();  
}
