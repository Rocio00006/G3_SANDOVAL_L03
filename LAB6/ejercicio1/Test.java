package LAB6.ejercicio1;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        StackLink<Double> pila = new StackLink<>();
        pila.push(1.5);
        pila.push(7.6);
        pila.push(3.7);

        System.out.println("**PILA ACTUAL");
        System.out.println(pila); 
        System.out.println("\n 1er elemento (top): " + pila.top()); // 3.3

        System.out.println("Borramos el primer elemento..");
        pila.pop();
        System.out.println("**Ahora la pila, queda: ");
        System.out.println(pila); 

        System.out.println("\nAgregamos un elemento con push: ");
        pila.push(4.4);
        System.out.println(pila); 
    }
}
