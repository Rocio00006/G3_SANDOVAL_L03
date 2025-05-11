package LAB6.actividad3;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        //creamos una cola de prioridad
        PriorityQueue<String, Integer> cola = new PriorityQueueLinkSort<>();

        cola.enqueue("Mates", 10);
        cola.enqueue("Inglés", 3);
        cola.enqueue("Comunicación", 15);
        cola.enqueue("Tutoría", 3);

        System.out.println("**COLA DE PRIORIDAD ORDENADA: ");
        System.out.println(cola); 

        System.out.println("\nTarea con > prio (front): " + cola.front()); 
        System.out.println("Tarea con < prio (back): " + cola.back()); 

        System.out.println("\n**Eliminar la tarea de mayor prioridad...");
        cola.dequeue(); 
        System.out.println(cola);
    }
}