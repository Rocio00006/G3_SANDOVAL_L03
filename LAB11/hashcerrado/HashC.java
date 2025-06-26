package LAB11.hashcerrado;

public class HashC<E> {
    //clase element que representa a una celda de la tabla hash
    private class Element<T> {
        Register<T> data;
        boolean isDeleted;

        Element(Register<T> data) {
            this.data = data;
            this.isDeleted = false;
        }

        @Override
        public String toString() {
            return isDeleted ? "X" : data.toString();
        }
    }

    private Element<E>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashC(int size) {
        this.size = size;
        table = (Element<E>[]) new Element[size];
    }

    //fucnion hash
    //usa la clave, modulo del tamño de la tabla
    private int hash(int key) {
        return key % size;
    }

    //insertar un registro en la tabla
    public void insert(Register<E> reg) {
        int pos = hash(reg.getKey());
        int start = pos;
        do {
            if (table[pos] == null || table[pos].isDeleted) {
                table[pos] = new Element<>(reg);
                return;
            } else if (table[pos].data.getKey() == reg.getKey() && !table[pos].isDeleted) {
                System.out.println("Clave repetida: " + reg.getKey());
                return;
            }
            pos = (pos + 1) % size;
        } while (pos != start);

        System.out.println("Tabla llena, no se pudo insertar");
    }

    //buscar un registro por su clave
    public Register<E> search(int key) {
        int pos = hash(key);
        int start = pos;

        do {
            if (table[pos] == null) return null;
            if (!table[pos].isDeleted && table[pos].data.getKey() == key)
                return table[pos].data;
            pos = (pos + 1) % size;
        } while (pos != start);

        return null;
    }

    //eliminar lógicamente un registro
    public void delete(int key) {
        int pos = hash(key);
        int start = pos;

        do {
            if (table[pos] == null) return;
            if (!table[pos].isDeleted && table[pos].data.getKey() == key) {
                table[pos].isDeleted = true;
                return;
            }
            pos = (pos + 1) % size;
        } while (pos != start);
    }

    //mostrar el estado de la tabla
    public void showTable() {
        System.out.println("Estado actual de la tabla:");
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            System.out.println(table[i] == null ? "Vacío" : table[i]);
        }
    }
}
