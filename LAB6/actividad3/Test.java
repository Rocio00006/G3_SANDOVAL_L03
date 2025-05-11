package LAB6.actividad3;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        PriorityQueue<String, Integer> cola = new PriorityQueueLinkSort<>();

        cola.enqueue("Tarea urgente", 5);
        cola.enqueue("Tarea importante", 3);
        cola.enqueue("Tarea baja", 1);
        cola.enqueue("Tarea intermedia", 3);
        cola.enqueue("Tarea crítica", 6);

        System.out.println(cola); // Ordenado de mayor a menor prioridad

        System.out.println("Front: " + cola.front()); // Tarea crítica
        System.out.println("Back: " + cola.back()); // Tarea baja

        cola.dequeue(); // Elimina la de mayor prioridad
        System.out.println(cola);

    }
}