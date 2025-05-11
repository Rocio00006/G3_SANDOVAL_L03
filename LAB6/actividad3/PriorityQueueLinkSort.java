package LAB6.actividad3;

//cola de prioridad ordenadad usando listas enlazadas
public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    //clase que encapsula el dato y su prioridad
    class EntryNode {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }
        //para mostrar el valor y su prioridad
        public String toString() {
            return "(" + data + ", " + priority + ")";
        }
    }

    //atributos de la cola
    private Node<EntryNode> first;  //nodo con mayor prioridad
    private Node<EntryNode> last;   //nodo con menor prioridad

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }
    //agrega un elemento tipo E en su lugar correcto
    public void enqueue(E x, N pr) {
        //creación de un nodo entrante
        EntryNode nuevoEnt = new EntryNode(x, pr);
        //creamos un nodo de tipo EntryNode
        Node<EntryNode> nuevo = new Node<>(nuevoEnt);

        if (isEmpty()) {
            first = last = nuevo;
            return;
        }
        //si el nuevo nodo tiene > prioridad que el primero
        if (pr.compareTo(first.getValor().priority) > 0) {
            //si la prioridad de nuevo es mayor
            //el siguiente de nuevo será el primero
            nuevo.setNext(first);
            //actualizamos el puntero de primero
            first = nuevo;
            return; //termina
        }

        //si el nuevo nodo tiene prioridad mayor en otra parte
        Node<EntryNode> actual = first; //tpmamos el primero de la cola
        Node<EntryNode> anterior = null;

        //recorremos la cola mientras la prio de "nuevo" sea menor a "actual"
        while (actual != null && pr.compareTo(actual.getValor().priority) <= 0) {
            anterior = actual;  //anterior ahora será actual
            actual = actual.getNext();  //pasa al siguiente nodo
        }
        //el nuevo nodo debe insertarse entre anterior y actual
        nuevo.setNext(actual);
        if (anterior != null) {
            anterior.setNext(nuevo);
        }
        //si se insertó al final
        if (actual == null) {
            last = nuevo;
        }
    }
    //elimina y retorna el dato con mayor prioridad
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) 
            throw new ExceptionIsEmpty("COla vacía");
        //aux es el valor del primer elemento de la cola
        E aux = first.getValor().data;
        first = first.getNext();    //eliminamso el primero
        //actualizamos last, si no hay primero tmp hay último
        if (first == null) 
            last = null;
        return aux;
    }
    //retorna el primer elemento
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) 
            throw new ExceptionIsEmpty("COLA vacía");
        //devuelve el valor del primero nodo = primer elemento
        return first.getValor().data;
    }
    //retorna el último elemento
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) 
            throw new ExceptionIsEmpty("Queue is empty");
        //devuelve el valor del último elemento
        return last.getValor().data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        /*Node<EntryNode> aux = first;

        while(aux!=null){
            System.out.println(aux.getValor());
            aux = aux.getNext();
        }*/

        StringBuilder sb = new StringBuilder("Cola de prioridad: [");
        Node<EntryNode> auxi = first;
        while (auxi != null) {
            sb.append(auxi.getValor());
            if (auxi.getNext() != null) sb.append(", ");
            auxi = auxi.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}