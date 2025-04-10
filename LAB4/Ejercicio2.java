package LAB4;

public class Ejercicio2 {
    public static int menorNumero(int[] arr, int k){
        return quickSelectH(arr, 0, arr.length - 1, k - 1);
    }

    public static int quickSelectH(int[] arr, int left, int right, int k){
        // solo hay un elemento, por lo tanto es el más pequeño
        if (left == right) {
            return arr[left];
        }
        int pivotIndex = partition(arr, left, right);
        if (k == pivotIndex) {
            return arr[k]; // El pivote es el k-ésimo más pequeño
        } else if (k < pivotIndex) {
            return quickSelectH(arr, left, pivotIndex - 1, k); // Buscar en la sublista izquierda
        } else {
            return quickSelectH(arr, pivotIndex + 1, right, k); // Buscar en la sublista derecha
        }

    }
    // Función para particionar el arreglo y obtener el índice del pivote
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];  // Elegimos el último elemento como pivote
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                // Intercambiamos los elementos menores que el pivote
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }
        // Colocamos el pivote en su posición correcta
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
 
        return i;
    }

    //probamos en main
    public static void main(String[] args) {
        int[] arr1 = {4, 2, 7, 10, 4, 17};
        System.out.println(menorNumero(arr1, 3));  // Salida: 4

        int[] arr2 = {4, 2, 7, 10, 4, 1, 6};
        System.out.println(menorNumero(arr2, 5));  // Salida: 6

        int[] arr3 = {4, 2, 7, 1, 4, 6};
        System.out.println(menorNumero(arr3, 1));  // Salida: 1

        int[] arr4 = {9, 2, 7, 1, 7};
        System.out.println(menorNumero(arr4, 4));  // Salida: 7
    }
}
