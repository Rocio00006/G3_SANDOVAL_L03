package LAB4;

public class QuickSelect {
    public int quickSelect(int[] arr, int low, int high, int k){

        if (low <= high) {
            int pivotIndex = partition(arr, low, high);
            
            //Si el pivote es el k-ésimo elemento
            if (pivotIndex == k) {
                return arr[pivotIndex];
            }
            //Si k es menor que la posición del pivote, buscar en la izquierda
            else if (k < pivotIndex) {
                return quickSelect(arr, low, pivotIndex - 1, k);
            }
            //Si k es mayor que la posición del pivote, buscar en la derecha
            else {
                return quickSelect(arr, pivotIndex + 1, high, k);
            }
        }
        return -1; // No se encontró el elemento
    }

    public int partition(int[] arr, int low, int high){
        //el último elemento será el pivote
        int pivot = arr[high];

        int i= low-1; //indice del elemento más pequeño

        for(int j=low; j<high; j++){
            //verifica si el elemento actual es <= al pivote
            if (arr[j]<=pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //INtercambiar arr[i+1] y arr[high] (pivote)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;     //retorna la posición del pivote
    }
}
