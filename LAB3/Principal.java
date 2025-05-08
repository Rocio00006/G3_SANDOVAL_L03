package LAB3;

public class Principal {
    // Método auxiliar para imprimir un arreglo
    public static void imprimirArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Método principal para prueba
    public static void main(String[] args) {
        int[] arreglo = {12, 11, 13, 5, 6, 7};
        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);
        
        MergeSort.mergeSort(arreglo);
        
        System.out.println("Arreglo ordenado:");
        imprimirArreglo(arreglo);
    }
}
