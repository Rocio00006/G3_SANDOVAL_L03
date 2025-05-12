package LAB6.ejercicio3;

public class PriorityQueueLinked<E> implements PriorityQueue<E, Integer>{
    QueueLink<E>[] colasPrio; 

    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int nPrio){
        //arreglo de tipo colas enlazadas genéricas
        this.colasPrio = (QueueLink<E>[]) new Object[nPrio];
        //inicializamos cada cola de tipo queueLink
        for(int i=0; i<nPrio;i++){
            colasPrio[i] = new QueueLink<>();
        }
    }

    public void enqueue(E x, Integer pr){
        colasPrio[pr].enqueue(x);
    }
   public E dequeue() throws ExceptionIsEmpty{
        //recorremos la cola desde el final
        for(int i=colasPrio.length-1;i>=0;i--){
            if(!colasPrio[i].isEmpty()){
                return colasPrio[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
        //return null;
    }
    public E front() throws ExceptionIsEmpty{
        for(int i=colasPrio.length-1;i>=0;i--){
            if (!colasPrio[i].isEmpty()) {
                return colasPrio[i].front();
            }
        }
        return null;
    }
    public E back() throws ExceptionIsEmpty{
        for(int i=0;i<colasPrio.length;i++){
            if (!colasPrio[i].isEmpty()) {
                return colasPrio[i].back();
            }
        }
        return null;
    }
    public boolean isEmpty(){
        for(QueueLink<E> cola :  colasPrio){
            if(!cola.isEmpty())
                return false;
        }
        return true;
    }
}
