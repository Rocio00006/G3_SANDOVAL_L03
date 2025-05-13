package F1REVIEW;

public class MergeSort {
    //mergesort, divide hasta tamaño 1, luego ordena

    //divide el arreglo hasta que quede de tamaño 1 y lo ordena
    public static void mergeSort(int[] arr){
        //caso base, si el arreglo es de tamaño 1 ya está ordenado*
        if(arr.length<=1) return;

        int mid = arr.length /2;

        //divir el arreglo en dos mitades
        int[] left = new int[mid];
        int[] right = new int[arr.length-mid];

        //copiar elementos a los subarreglos
        //arreglo de la izq
        for(int i=0; i<mid; i++){
            left[i] = arr[i];
        }
        //arreglo de la der
        for(int i = mid; i<arr.length; i++){
            right[i-mid]= arr[i];
        }

        //llamar recursivamente para cada mitad
        mergeSort(left);
        mergeSort(right);

        //combinamos las mitades con merge
        merge(arr, left, right);
    }
    //fusionara 
    public static void merge(int[] result, int[] left, int[] right){
        int i=0; //para recorrer la izq
        int j=0; //para recorrer la der
        int k=0; //para llenar el arr final = result
        
        //recorrer arreglso hasta que uno se acabe
        while (i<left.length && j<right.length) {
            if(left[i] <= right[i]){
                result[k++] = left[i++];
            } else {
                result[k++]= right[j++];
            }
        }

        //puede que queden elementos

        //copiar elementos restantes del arr left
        while (i<left.length) {
            result[k++]= left[i++];
        }
        //copiar elementos restantes del arr right
        while(j<right.length){
            result[k++] = right[j++];
        }
    }

    //metodo para imprimir el arreglo
    public static void printArray(int[] arr){
        for(int e:arr){
            System.out.println(e+" ");
        }
    }
    // Main para probar el algoritmo
    public static void main(String[] args) {
        int[] data = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Arreglo original:");
        printArray(data);

        mergeSort(data);

        System.out.println("Arreglo ordenado:");
        printArray(data);
    }
}
