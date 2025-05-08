package LAB3;

public class MergeSort {
    //método principal mergeSort, inicia ordenamiento
    public static void mergeSort(int[] arr){

        //si arreglo tiene 0 o 1 elemento ya está ordenado
        if(arr.length<=1)
            return;
        
        //dividir el arreglo en mitades
        int mitad = arr.length/2;
        int[] izquierda = new int[mitad]; 
        int[] derecha = new int[arr.length-mitad];

        //copiar elementos a los subarreglos
        for(int i=0; i< mitad; i++){
            izquierda[i]=arr[i];
        }
        for(int i=mitad; i<arr.length; i++){
            derecha[i-mitad] = arr[i];
        }

        //ordenar recursivamente ambas mitades
        mergeSort(izquierda);
        mergeSort(derecha);

        //combinar mitad ordenadas
        merge(arr, izquierda, derecha);
    }

    //método para combinar subarreglos ordenados
    public static void merge(int[] arr, int[] izquierda, int[] derecha){
        int i=0, j=0, k=0;

        //verificar que haya elementos en ambos subarreglos
        while(i<izquierda.length && j<derecha.length){
            if(izquierda[i]<= derecha[i]){
                arr[k++] = izquierda[i++];
            } else{
                arr[k++]= derecha[j++];
            }
        }
        //copiar elementos restantes de izquierda
        while (i<izquierda.length) {
            arr[k++]=izquierda[i++];
        }
        //copiar elementos restantes de derecha
        while (j < derecha.length) {
            arr[k++] = derecha[j++];
        }
    }
    // Método auxiliar para imprimir un arreglo
    public static void imprimirArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Método principal para prueba
    public static void main(String[] args) {
        int[] arreglo = {12, 11, 13, 5, 6, 7};
        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);
        
        mergeSort(arreglo);
        
        System.out.println("Arreglo ordenado:");
        imprimirArreglo(arreglo);
    }
}
