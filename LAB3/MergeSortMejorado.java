package LAB3;

import java.util.Arrays;

public class MergeSortMejorado {
    private static final int UMBRAL = 10; // Punto de cambio a Insertion Sort

    public static void mergeSort(int[] arr, int izquierda, int derecha) {
        if (derecha - izquierda <= UMBRAL) {
            insertionSort(arr, izquierda, derecha);
            return;
        }
        
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            mergeSort(arr, izquierda, medio);
            mergeSort(arr, medio + 1, derecha);

            merge(arr, izquierda, medio, derecha);
        }
    }

    private static void insertionSort(int[] arr, int izquierda, int derecha) {
        for (int i = izquierda + 1; i <= derecha; i++) {
            int clave = arr[i];
            int j = i - 1;

            while (j >= izquierda && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = clave;
        }
    }

    private static void merge(int[] arr, int izquierda, int medio, int derecha) {
        int[] temp = Arrays.copyOfRange(arr, izquierda, derecha + 1);

        int i = 0, j = medio - izquierda + 1, k = izquierda;

        while (i <= medio - izquierda && j <= derecha - izquierda) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= medio - izquierda) {
            arr[k++] = temp[i++];
        }

        while (j <= derecha - izquierda) {
            arr[k++] = temp[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7, 3, 9, 2, 10, 4, 8, 1};
        System.out.println("Arreglo original: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));
    }
}