package LAB6.ejercicio3;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        //creamos una cola de prioridad de tipo String de 4 colas
        PriorityQueue<String, Integer> pq = new PriorityQueueLinked<>(3); 

        pq.enqueue("Elemento 1", 0);
        pq.enqueue("Elemento 50", 2);
        pq.enqueue("Elemento 55", 2);
        pq.enqueue("elemento 22", 1);

        System.out.println("**Mostramos las colas por prioridad");
        System.out.println(pq); 
        System.out.println("\n**TAREA con mayor prioridad ");
        System.out.println("Front: " + pq.front()); 
        System.out.println("TAREA con menor prioridad");
        System.out.println("Back: " + pq.back()); 

        System.out.println("\n**Hacemos un dequeue...");
        pq.dequeue();
        System.out.println("Después de eliminar la más prioritaria:");
        System.out.println(pq);
    }
}
