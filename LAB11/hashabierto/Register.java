package LAB11.hashabierto;

public class Register<E> {
    private int key;
    private E value;

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
