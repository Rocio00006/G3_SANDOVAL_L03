package LAB7.ejercicios;

// QUEUE/COLAS : FIFO FIRST IN FIRST OUT
public interface Queue<E> {
    void enqueue(E ele); //agrega la final, debe existir 
    E dequeue() throws ExceptionIsEmpty;    //elimina 1°
    E front() throws ExceptionIsEmpty;  //retorna el 1°
    E back() throws ExceptionIsEmpty;   //retorna el ult
    //public void destroyQueue();
    boolean isEmpty();
    //boolean isFull();
}
