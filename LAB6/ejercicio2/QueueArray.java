package LAB6.ejercicio2;

public class QueueArray<E> {
    E[] arrCola;
    E front;    //primer elemento ingresado 
    E back;
    int posFront;   //siempre será 0
    int posBack;

    @SuppressWarnings("unchecked")
    public QueueArray(int n){
        this.arrCola = (E[]) new Object[n];
        this.front = null;
        this.back = null;
        this.posBack=0;
        this.posFront=0;    //siempre será 0
    }
    //encolar: agregar un elemento al final
    public void enqueue(E x){
        if(isEmpty()){
            arrCola[posFront] = x;
            return;
        }
        if(isFull()){
            System.out.println("COLA LLENA");
            return;
        }
        //si ya hay elementos
        for(int i=0; i<arrCola.length;i++){
            if(arrCola[i]==null){
                arrCola[i]=x;
                posBack=i;
                //back = arrCola[posBack];
                return;
            }
        }
        /*/
        //si ya hay elementos en la cola
        for(int i=arrCola.length-2; i>=0;i--){
            arrCola[i+1] = arrCola[i];
            if(i==0){
                arrCola[i] = x;
            }
        }*/
    }
    //eliminar el primer elemento
    public E dequeue(E x) throws ExceptionIsEmpty{
        return front;
    }
    //devuelve el primer elemento de la cola
    public E front() throws ExceptionIsEmpty{
        front = arrCola[posFront];
        return front;
    }
    //devulve el último elemento añadido a la cola
    public E back() throws ExceptionIsEmpty{
        back = arrCola[posBack];
        return back;
    }
    public boolean isEmpty(){
        if(tamañoCola()==0){
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
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("[");
        for(int i=0; i<tamañoCola();i++){
            s.append(arrCola[i]);
            s.append(", ");
        }
        s.append("]");
        return s.toString();
    }

}
