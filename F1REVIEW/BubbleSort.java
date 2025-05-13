package F1REVIEW;

public class BubbleSort {

    public static void mibubble(int[] arr){
        //for que contralada e número de pasadas
        for(int i=0; i<arr.length-1; i++){
            //recorre hasta el penúltimo elemento no ordenado
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j]> arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void mostrarArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arreglo = {5, 3, 8, 4, 2};

        // Mostrar el arreglo original
        System.out.print("Arreglo original: ");
        mostrarArreglo(arreglo);

        mibubble(arreglo);
        // Arreglo ordenado
        System.out.print("Arreglo ordenado: ");
        mostrarArreglo(arreglo);
    }

}
