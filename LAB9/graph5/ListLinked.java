package LAB9.graph5;

public class ListLinked<E> {
    private Node<E> head;
    private int size;
    
    public ListLinked() {
        this.head = null;
        this.size = 0;
    }
    
    //Agregar elemento al final
    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    //Agregar elemento en posición específica
    public void add(int index, E data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        
        if (index == 0) {
            Node<E> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<E> newNode = new Node<>(data);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }
    
    //Obtener elemento por índice
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    //Eliminar elemento por índice
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        
        if (index == 0) {
            E data = head.data;
            head = head.next;
            size--;
            return data;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            E data = current.next.data;
            current.next = current.next.next;
            size--;
            return data;
        }
    }
    
    //Eliminar elemento por valor
    public boolean remove(E data) {
        if (head == null) return false;
        
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        
        Node<E> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    //Buscar elemento
    public boolean contains(E data) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    //Obtener índice de elemento
    public int indexOf(E data) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    
    //Obtener tamaño
    public int size() {
        return size;
    }
    
    //Verificar si está vacía
    public boolean isEmpty() {
        return size == 0;
    }
    
    //Limpiar lista
    public void clear() {
        head = null;
        size = 0;
    }
    
    @Override
    public String toString() {
        if (head == null) return "[]";
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
    public void insertLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    //método adicional para obtener la cabeza
    // Obtener el head (para recorrer externamente)
    public Node<E> getHead() {
        return head;
    }
    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> aux = head;
        while (aux != null) {
            sb.append(aux.data.toString()).append(" ");
            aux = aux.next;
        }
        return sb.toString();
    }*/


    public static class Node<E> {
        public E data;
        public Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
}

