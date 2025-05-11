package LAB6.actividad2;

class QueueLink<E> implements Queue<E> {
    private Node<E> first;  //apunta al primer nodo (front)
    private Node<E> last;   //apunta al último nodo (back)

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    //agrega un elemento a la cola al final
    public void enqueue(E x) {
        Node<E> aux = new Node<E>(x);   //contiene al nuevo nodo
        if (isEmpty()) {
            first = aux;        //
        } else
            last.setNext(aux);
        last = aux;     //last siempre debe apuntar al ulti 

    }
    //elimina el 1 elemento =first, retorna el 1°
    public E dequeue() throws ExceptionIsEmpty {
        if(isEmpty()){
            throw new ExceptionIsEmpty("Cola vacía");
        }
        //aux toma el valor del primer nodo
        E aux = first.getValor();
        first = first.getNext();    //pasa al sig y elimina el 1°
        //si 1° no existe, el ult tmp
        if(first==null){
            last=null;
        }
        return aux;
    }

    public E back() throws ExceptionIsEmpty {
        if(isEmpty())  
            throw new ExceptionIsEmpty("Cola vacía, no hay back");
        //last tiene el último nodo
        return last.getValor();
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cola vacía, no hay front");
        //first almacena el primer nodo
        return first.getValor();
    }
    public boolean isEmpty() {
        boolean vacio=false;
        if(first==null)
            vacio=true;
        return vacio;
    }
    public String toString() {

        /*String queueString = "Queue: [";
        Node<E> current = first;
        while (current != null) {
            queueString += current.getValor();
            if (current.getNext() != null) {
                queueString += ", ";
            }
            current = current.getNext();
        }
        queueString += "]";
        return queueString;*/

        Node<E> aux = first;
        while(aux!=null){
            System.out.println(aux.getValor().toString());
            aux = aux.getNext();
        }
        return "";
    }
}