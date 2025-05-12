package LAB6.ejercicio2;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        QueueArray<Integer> q = new QueueArray<>(4);
        q.enqueue(10);
        q.enqueue(70);
        q.enqueue(150);
        q.enqueue(20);
        System.out.println("**COLA: " + q);
        System.out.println("Front: " + q.front());
        System.out.println("Back: " + q.back());
        
        System.out.println("\n**hacemos un dequeue");
        q.dequeue();
        System.out.println("Después de dequeue: " + q);
        System.out.println("Front: " + q.front());
        System.out.println("Back: " + q.back());

        System.out.println("\n**llenamos la COLA");
        q.enqueue(300);
        q.enqueue(66);
        System.out.println("Cola llena: " + q);
    }
}
