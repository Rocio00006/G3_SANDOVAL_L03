package LAB3.Ordenamiento;

public class HeapSort {
    
    // Método para realizar la ordenación
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Construir el heap (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extraer los elementos del heap uno a uno
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamar a heapify en el árbol reducido
            heapify(arr, i, 0);
        }
    }

    // Función para organizar un subárbol con la raíz en el índice i
    // n es el tamaño del heap
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Inicializar largest como la raíz
        int left = 2 * i + 1; // izquierdo = 2*i + 1
        int right = 2 * i + 2; // derecho = 2*i + 2

        // Si el hijo izquierdo es más grande que la raíz
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Si el hijo derecho es más grande que el más grande hasta ahora
        if (right < n && arr[right] > arr[largest]) 
            largest = right;

        // Si largest no es la raíz-
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursivamente hacer heapify en el subárbol afectado
            heapify(arr, n, largest);
        }
    }

    // Método para imprimir el arreglo
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Método principal para probar el código
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Arreglo original:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Arreglo ordenado:");
        printArray(arr);
    }
}

