package LAB6.actividad2;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        //creamos una cola
        Queue<String> cola = new QueueLink<>();
        //añadimos elementos a la cola
        cola.enqueue("PRIMERO");
        cola.enqueue("SEGUNDO");
        cola.enqueue("TERCERO");

        System.out.println("**LA COLA HASTA AHORA:");
        System.out.println(cola); 

        System.out.println("Front: " + cola.front()); 
        System.out.println("Back: " + cola.back()); 

        System.out.println("**Eliminamos el primer elemento");
        cola.dequeue();
        System.out.println(cola); 

        System.out.println("**Agregams otro después de eliminarlo ");
        cola.enqueue("cuatro");
        System.out.println(cola);
    }
}
