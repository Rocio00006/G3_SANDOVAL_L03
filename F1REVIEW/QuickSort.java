package F1REVIEW;

public class QuickSort {
    public static void quicksort(int[] arr, int low, int high) {
        //casi verifica que el arreglo tenga más de un elemento
        if (low < high) {
            //llamaos a partition para elegir a un pivote (empezando por el último)
            int  pi = partition(arr, low, high);
           
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }

    }

    //reordena en torno al pivote
    public static int partition(int[] arr, int low, int high) {
        //empezar por el último
        int pivot = arr[high];
        //i es el índice menor
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            //si el elemento es menor, i aumenta, luego intercambiamos 
            if (arr[j] < pivot) {
                i ++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
