package LAB4;

public class Ejercicio2v2 {
    public static int elementoMasPequeño(int[] arr, int k){
        //k-1 porque empieza desde 0, enviamos el lugar
        return quickSelect(arr, 0, arr.length - 1, k - 1); 
    }

    //quickSelect retorna el kesimo elemento +pequeño de un arr no ordenado
    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right)
            return arr[left];

        int pivotIndex = partition(arr, left, right);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    //ordena elementos menores que el piv a la izq y mayores a la der
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                // intercambio in-line sin método swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        // Colocar el pivote en su posición final
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        return i;
    }

    public static void main(String[] args) {
        int[] ejemplo1 = {4, 2, 7, 10, 4, 17};
        System.out.println(elementoMasPequeño(ejemplo1, 3)); //4

        int[] ejemplo2 = {4, 2, 7, 10, 4, 1, 6};
        System.out.println(elementoMasPequeño(ejemplo2, 5)); //6

        int[] ejemplo3 = {4, 2, 7, 1, 4, 6};
        System.out.println(elementoMasPequeño(ejemplo3, 1)); //1

        int[] ejemplo4 = {9, 2, 7, 1, 7};
        System.out.println(elementoMasPequeño(ejemplo4, 4)); //7
    }
}
