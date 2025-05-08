package LAB6.actividad2;

// QUEUE/COLAS : FIFO FIRST IN FIRST OUT
public interface Queue<E> {
    public void enqueue(E ele); //agrega la final, debe existir 
    public void dequeque(E ele);    //elimina primero
    public void destroyQueue();
    public boolean isEmpty();
    public boolean isFull();
    public E isFront();     //retorna el primer elemento
    public E isBack();      //retorna el primer elemento

}
