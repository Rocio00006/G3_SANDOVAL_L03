package LAB6;

import LAB6.actividad2.ExceptionIsEmpty;

// QUEUE/COLAS : FIFO FIRST IN FIRST OUT
public interface Queue<E> {
    public void enqueue(E ele); //agrega la final, debe existir 
    public E dequeque(E ele) throws ExceptionIsEmpty;    //elimina primero
    public void destroyQueue();
    public boolean isEmpty() throws ExceptionIsEmpty;
    public boolean isFull() throws ExceptionIsEmpty;
    public E isFront();     //retorna el primer elemento
    public E isBack();      //retorna el primer elemento

}
