package LAB3;

import java.util.Arrays;

public class MergeSortMejorado {
    public static void mergeSort(int[] arr, int[] aux, int izquierda, int derecha) {
        if (izquierda < derecha) { // O(1)
            int medio = izquierda + (derecha - izquierda) / 2; //O(1)

            // Llamadas recursivas para dividir el arreglo en dos mitades
            mergeSort(arr, aux, izquierda, medio); // T(n/2) == O(log n)
            mergeSort(arr, aux, medio + 1, derecha); // T(n/2) == O(log n)

            // Fusionar las mitades ordenadas
            merge(arr, aux, izquierda, medio, derecha);         //O(n)
        }
    }

    // Método para fusionar dos subarreglos ordenados usando un arreglo auxiliar
    public static void merge(int[] arr, int[] aux, int izquierda, int medio, int derecha) {
        //hacer una copia 
        System.arraycopy(arr, izquierda, aux, izquierda, derecha - izquierda + 1); // O(n)

        int i = izquierda, j = medio + 1, k = izquierda;

        //mezclar los dos subarreglos ordenados en el arreglo original
        while (i <= medio && j <= derecha) { // O(n)
            if (aux[i] <= aux[j]) { //O(1)
                arr[k++] = aux[i++]; //O(1)
            } else {
                arr[k++] = aux[j++]; //O(1)
            }
        }

        //copiar elementos restantes
        while (i <= medio) { //O(n)
            arr[k++] = aux[i++]; // O(1)
        }

        // No es necesario copiar los elementos restantes del segundo subarreglo 
        // porque ya están en su lugar en 'arr'.
    }

    // Método de prueba
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10}; //O(1)
        int[] aux = new int[arr.length]; //O(n) (espacio extra)

        mergeSort(arr, aux, 0, arr.length - 1); //O(n log n)

        System.out.println("Arreglo ordenado: " + Arrays.toString(arr)); //O(n)
    }
}
