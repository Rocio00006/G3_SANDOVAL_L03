package LAB6.actividad1;

public class Test {
    public static void main(String[] args) {
        StackArray<Integer> pila1 = new StackArray<Integer>(8);
        System.out.println("Agregando elementos: ");
        pila1.push(5);
        pila1.push(10);
        pila1.push(25);
        System.out.println("PILA QUEDA COMO: ");
        pila1.printStack();
        System.out.println("Eliminar el tope con pop()");
        pila1.pop();
        System.out.println("AHORA LA PILA QUEDA COMO:");
        pila1.printStack();

        System.out.println("\nCon OBJETOS String");
        StackArray<String> pila2 = new StackArray<String>(4);
        System.out.println("Agregando elementos... ");
        pila2.push("Hola");
        pila2.push("Como");
        pila2.push("estas");
        System.out.println("PILA QUEDA COMO: ");
        pila2.printStack();
        System.out.println("El tope es: "+pila2.top());
        System.out.println("Eliminar el 2 veces tope con pop()");
        pila2.pop();
        pila2.pop();
        System.out.println("AHORA EL TOPE ES:"+pila2.top());
    }
}
