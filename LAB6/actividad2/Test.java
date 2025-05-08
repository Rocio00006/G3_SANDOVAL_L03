package LAB6.actividad2;

public class Test {
    public static void main(String[] args) {
        //creamos una cola
        Queue<String> cola = new QueueLink<>();
        //añadimos elementos a la cola
        cola.enqueue("PRIMERO");
        cola.enqueue("SEGUNDO");
        cola.enqueue("TERCERO");

        System.out.println("COLA:");
        System.out.println(cola); 
/*/
        System.out.println("Front: " + cola.front()); 
        System.out.println("Back: " + cola.back()); 

        cola.dequeue();
        System.out.println(cola); // Queue: [dos, tres]
*/
        cola.enqueue("cuatro");
        System.out.println(cola);

    }
}
