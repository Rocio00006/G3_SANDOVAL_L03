package LAB3;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {//compara si izquierda es menor a derecha
            int medio = izquierda + (derecha - izquierda) / 2;
            
            // Dividir el arreglo en dos mitades
            mergeSort(arr, izquierda, medio); //primera mitad
            mergeSort(arr, medio + 1, derecha); //mitd sobrante
            
            // Combinar las mitades ordenadas
            merge(arr, izquierda, medio, derecha);
        }
    } 

    //metodo merge
    public static void merge(int[] arr, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        int[] izquierdaArr = new int[n1];
        int[] derechaArr = new int[n2];

        // Copiar datos a arreglos temporales
        for (int i = 0; i < n1; i++)
            izquierdaArr[i] = arr[izquierda + i];
        for (int j = 0; j < n2; j++)
            derechaArr[j] = arr[medio + 1 + j];

        // Fusionar los arreglos temporales
        int i = 0, j = 0, k = izquierda;
        while (i < n1 && j < n2) {
            if (izquierdaArr[i] <= derechaArr[j]) {
                arr[k] = izquierdaArr[i];
                i++;
            } else {
                arr[k] = derechaArr[j];
                j++;
            }
            k++;
        }
        // Copiar elementos restantes de izquierdaArr[], si hay alguno
        while (i < n1) {
            arr[k] = izquierdaArr[i];
            i++;
            k++;
        }
        // Copiar elementos restantes de derechaArr[], si hay alguno
        while (j < n2) {
            arr[k] = derechaArr[j];
            j++;
            k++;
        }  
    }

    //main para probar
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Arreglo original: " + Arrays.toString(arr));
        
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));
    }
}
