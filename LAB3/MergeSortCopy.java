package LAB3;

import java.util.Arrays;

public class MergeSortCopy {
  
    public static void mergeSort(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {                              //O(1)
            int medio = izquierda + (derecha - izquierda) / 2;  //O(1)
            // Dividir el arreglo en dos mitades
            mergeSort(arr, izquierda, medio);                   //T(n/2)
            mergeSort(arr, medio + 1, derecha);                 //T(n/2)
            // Combinar las mitades ordenadas
            merge(arr, izquierda, medio, derecha);              //O(n)
        }
    } 
    
    //metodo merge
    public static void merge(int[] arr, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;                 //O(1)
        int n2 = derecha - medio;                       //O(1)
        int[] izquierdaArr = new int[n1];               //O(n)
        int[] derechaArr = new int[n2];                 //O(n)
        // Copiar datos a arreglos temporales
        for (int i = 0; i < n1; i++) //n1 veces         //o(n)
            izquierdaArr[i] = arr[izquierda + i]; //O(1)
        for (int j = 0; j < n2; j++) // n2 veces        //O(n)
            derechaArr[j] = arr[medio + 1 + j]; //O(1)

        // Fusionar los arreglos temporales
        int i = 0, j = 0, k = izquierda;                //O(1)
        while (i < n1 && j < n2) {   //n veces          //O(n)
            if (izquierdaArr[i] <= derechaArr[j]) { //O(1)
                arr[k] = izquierdaArr[i];   //O(1)
                i++;                        //O(1)
            } else {
                arr[k] = derechaArr[j];     //O(1)
                j++;                        //O(1)
            }
            k++;                            //o(1)
        }
        // Copiar elementos restantes de izquierdaArr[], si hay alguno
        while (i < n1) { //n1 veces = n1*O(n1)= O(n)
            arr[k] = izquierdaArr[i];   //O(1)
            i++;                        //O(1)
            k++;                        //O(1)
        }
        // Copiar elementos restantes de derechaArr[], si hay alguno
        while (j < n2) {    //n2 veces = n*O(1) = O(n)
            arr[k] = derechaArr[j];     //O(1)
            j++;                        //O(1)
            k++;                        //O(!)
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
