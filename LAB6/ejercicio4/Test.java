package LAB6.ejercicio4;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        String cadena1 = "()()()[()]()";
        System.out.println("Cadena: " + cadena1); 
        System.out.println("Balanceada? "+Aplication.symbolBalancing(cadena1));

        String cadena2 = "((()))[]";
        System.out.println("Cadena: " + cadena2);
        System.out.println("Balanceada? " + Aplication.symbolBalancing(cadena2));

        String cadena3 = "([])[](";
        System.out.println("Cadena: " + cadena3);
        System.out.println("Balanceada? " + Aplication.symbolBalancing(cadena3));

        String cadena4 = "([{)]}";
        System.out.println("Cadena: " + cadena4);
        System.out.println("Balanceada? " + Aplication.symbolBalancing(cadena4));

        String cadena5 = "[";
        System.out.println("Cadena: " + cadena5);
        System.out.println("Balanceada? " + Aplication.symbolBalancing(cadena5));

        String cadena6 = "[][][]{{{}}}";
        System.out.println("Cadena: " + cadena6);
        System.out.println("Balanceada? " + Aplication.symbolBalancing(cadena6));
    }
}