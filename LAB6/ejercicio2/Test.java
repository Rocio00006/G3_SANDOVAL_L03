package LAB6.ejercicio2;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        QueueArray<Integer> q = new QueueArray<>(5);
        q.enqueue(10);
        q.enqueue(70);
        q.enqueue(150);
        q.enqueue(20);
        System.out.println("Cola: " + q);
        System.out.println("Front: " + q.front());
        System.out.println("Back: " + q.back());
        /*
        q.dequeue();
        System.out.println("Después de dequeue: " + q);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60); // llenará la cola
        System.out.println("Cola llena: " + q);*/
    }
}
