package LAB11.hashabierto;

import java.util.LinkedList;

public class HashO<E> {
    private LinkedList<Register<E>>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashO(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    //función hash simple: clave % tamaño
    private int hash(int key) {
        return key % size;
    }

    //inserción en la lista correspondiente
    public void insert(Register<E> reg) {
        int pos = hash(reg.getKey());
        for (Register<E> r : table[pos]) {
            if (r.getKey() == reg.getKey()) {
                System.out.println("Clave repetida: " + reg.getKey());
                return;
            }
        }
        table[pos].add(reg);
    }

    //búsqueda en la lista correspondiente
    public Register<E> search(int key) {
        int pos = hash(key);
        for (Register<E> r : table[pos]) {
            if (r.getKey() == key)
                return r;
        }
        return null;
    }

    //eliminación (elimina físicamente el objeto)
    public void delete(int key) {
        int pos = hash(key);
        table[pos].removeIf(r -> r.getKey() == key);
    }

    //mostrar contenido completo de la tabla
    public void showTable() {
        System.out.println("Contenido de la tabla:");
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("Vacío");
            } else {
                for (Register<E> r : table[i]) {
                    System.out.print(r + " ");
                }
                System.out.println();
            }
        }
    }
}
