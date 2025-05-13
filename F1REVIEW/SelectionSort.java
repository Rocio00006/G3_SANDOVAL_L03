package F1REVIEW;

public class SelectionSort {
    public static void selections(int[] arr){
        
        for(int i = 0; i<arr.length-1; i++){
            //suponemo que el primero elemento es el menor
            int intdiceMenor=i;

            for(int j= i+1; j<arr.length; j++){
                if(arr[j]<arr[intdiceMenor]){
                    intdiceMenor=j; //nuevo indice menor
                }
            }

            if(intdiceMenor !=i){
                int temp = arr[i];
                arr[i] = arr[intdiceMenor];
                arr[intdiceMenor] = temp;
            }
        }
    }

    // Método auxiliar para mostrar el arreglo
    public static void mostrarArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arreglo = {29, 10, 14, 37, 13};

        System.out.print("Arreglo original: ");
        mostrarArreglo(arreglo);
        
        selections(arreglo);
        System.out.print("Arreglo ordenado: ");
        mostrarArreglo(arreglo);
    }
    
}
