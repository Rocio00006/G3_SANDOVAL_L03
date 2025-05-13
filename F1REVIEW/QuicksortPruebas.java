package F1REVIEW;

public class QuicksortPruebas {

    public static void runTestCase(int[] arr) {
        System.out.println("========== NUEVO CASO DE PRUEBA ==========");
        System.out.print("Arreglo original: ");
        printArray(arr);
        System.out.println("-------------------------------------------");
        quicksort(arr, 0, arr.length - 1);
        System.out.println("-------------------------------------------");
        System.out.print("Arreglo ordenado: ");
        printArray(arr);
        System.out.println("===========================================\n");
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            System.out.println("Después de particionar con pivote en índice " + pi + " (valor " + arr[pi] + "):");
            printArray(arr);
            System.out.println();

            quicksort(arr, low, pi - 1);  // Lado izquierdo
            quicksort(arr, pi + 1, high); // Lado derecho
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // último elemento como pivote
        int i = low - 1;

        System.out.println("Particionando entre índices " + low + " y " + high + " | Pivote: " + pivot);

        for (int j = low; j < high; j++) {
            System.out.print("Comparando arr[" + j + "] = " + arr[j]);
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
                System.out.println("  → menor que el pivote, intercambiado con arr[" + i + "] = " + arr[i]);
            } else {
                System.out.println("  → mayor o igual al pivote, no se intercambia");
            }
        }

        swap(arr, i + 1, high);
        System.out.println("Intercambio final del pivote con arr[" + (i + 1) + "]:");
        printArray(arr);

        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Método main para probar
    public static void main(String[] args) {
        runTestCase(new int[]{10, 7, 8, 9, 1, 5});
        runTestCase(new int[]{4, 2, 6, 9, 3});
        runTestCase(new int[]{1, 2, 3, 4, 5});
        runTestCase(new int[]{5, 4, 3, 2, 1});
    }
}
