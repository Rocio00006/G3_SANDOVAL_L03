package LAB6.actividad2;

class QueueLink<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    //agrega un elemento a la cola al final
    public void enqueue(E x) {
        Node<E> aux = new Node<E>(x);
        if (isEmpty()) {
            first = aux;
        } else
            this.last.setNext(aux);
        this.last = aux;
    }
    //elimina el 1 elemento =first, retorna el 1°
    public E dequeue() throws ExceptionIsEmpty {
        if(isEmpty()){
            throw new ExceptionIsEmpty("Cola vacía");
        }
        E aux = first.getValor();
        first = first.getNext();    //pasa al sig
        //si 1° no existe, el ult tmp
        if(first==null){
            last=null;
        }
        return aux;
    }

    public E back() throws ExceptionIsEmpty {
        if(isEmpty())  
            throw new ExceptionIsEmpty("Cola vacía, no hay back");
        return last.getValor();
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cola vacía, no hay front");
        return first.getValor();
    }

    public boolean isEmpty() {
        boolean vacio=false;
        if(first.getValor()==null)
            vacio=true;
        if(last.getValor()==null)
            vacio=true;
        return vacio;
    }
    public String toString() {

        String queueString = "Queue: [";
        Node<E> current = first;
        while (current != null) {
            queueString += current.getValor();
            if (current.getNext() != null) {
                queueString += ", ";
            }
            current = current.getNext();
        }
        queueString += "]";
        return queueString;

        /*Node<E> aux = first;
        while(aux!=null){
            System.out.println(aux.getValor().toString());
            aux = aux.getNext();
        }
        return "";*/
    }
}