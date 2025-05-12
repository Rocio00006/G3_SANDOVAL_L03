package LAB6.ejercicio2;

public class QueueArray<E> {
    E[] arrCola;
    E front;
    E back;
    int posFront;
    int posBack;

    @SuppressWarnings("unchecked")
    public QueueArray(int n){
        this.arrCola = (E[]) new Object[n];
        this.front = null;
        this.back = null;
        this.posBack=0;
        this.posFront=0;
    }
    //encolar: agregar un elemento al final
    public void enqueue(E x){
        if(isEmpty()){
            arrCola[posFront] = x;
            front = arrCola[posFront];
            return;
        }
        if()

    }
    //eliminar el primer elemento
    public E dequeue(E x) throws ExceptionIsEmpty{
        return front;
    }
    //devuelve el primer elemento de la cola
    public E front() throws ExceptionIsEmpty{
        return front;
    }
    //devulve el último elemento añadido a la cola
    public E back() throws ExceptionIsEmpty{
        return back;
    }
    public boolean isEmpty(){
        if(arrCola.length==0){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(tamañoCola()==arrCola.length){
            return true;
        }
        return false;
    }
    //otros métodos
    public int tamañoCola(){
        int conta = 0;
        for(E e : arrCola){
            if(e!=null)
                conta++;
        }
        return conta;
    }
}
