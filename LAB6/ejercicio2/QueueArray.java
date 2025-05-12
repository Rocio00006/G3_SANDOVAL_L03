package LAB6.ejercicio2;

public class QueueArray<E> {
    E[] arrCola;
    E front;    //primer elemento ingresado 
    E back;     //último elemento
    int posFront;   //siempre será 0, si no esta vacia
    int posBack;    //posición del último elemento

    @SuppressWarnings("unchecked")
    public QueueArray(int n){
        this.arrCola = (E[]) new Object[n];
        this.front = null;
        this.back = null;
        this.posBack=-1;
        this.posFront=-1;   
    }
    //encolar: agregar un elemento al final
    public void enqueue(E x){
        if(isEmpty()){
            posFront=0;
            posBack=0;
            arrCola[posFront] = x;
            return;
        }
        if(isFull()){
            System.out.println("COLA LLENA");
            return;
        }

        //si ya hay elementos en la cola
        for(int i=0; i<arrCola.length;i++){
            if(arrCola[i]==null){
                arrCola[i]=x;
                posBack=i;
                return;
            }
        }
    }
    //elimina y devuleve el primer elemento o sea front
    public E dequeue() throws ExceptionIsEmpty{
        if(isEmpty())
            throw new ExceptionIsEmpty("COLA VACIA");

        //guardar front antes de eliminarlo
        E copiaFront = arrCola[posFront];
        //movemos una posición a la izquierda
        for(int i=1; i<posBack+1;i++){
            arrCola[i-1] = arrCola[i];
        }
        //el ultimo valor se ha duplicado, tonces lo borramos
        arrCola[posBack]=null;
        posBack--;  //el indice de la última posición resta 1
        return copiaFront;
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
    //método que cuenta elementos de la cola, NO NULL
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

//mover una posición a la izquierda
        /*/
        //si ya hay elementos en la cola
        for(int i=arrCola.length-2; i>=0;i--){
            arrCola[i+1] = arrCola[i];
            if(i==0){
                arrCola[i] = x;
            }
        }*/