package LAB11.hashcerrado;

public class Register<E> implements Comparable<Register<E>> {
    private int key;        //clave
    private E value;        //valor genérico 

    public Register(int key, E value) {
        this.key = key;
        this.value = value;
    }
    public int getKey() {
        return key;
    }
    public E getValue() {
        return value;
    }
    @Override
    public int compareTo(Register<E> other) {
        return Integer.compare(this.key, other.key);
    }
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Register<?>){
            Register<?> other = (Register<?>) obj;
            return this.key == other.key;
        }
        return false;
    }
}
