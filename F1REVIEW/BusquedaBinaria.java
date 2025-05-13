package F1REVIEW;

public class BusquedaBinaria {
    //busqueda binaria funciona para arreglos ORDENADOS
    public static int busquedaBinariaIterativa(int[] arr, int x){
        int izq = 0;
        int der = arr.length-1;
        

        while (izq <= der) {
            int iMedio = (izq+(der-izq))/2;
            
            if (arr[iMedio] == x) {
                return iMedio;
            } else if (arr[iMedio] < x) {
                izq = iMedio + 1;
            }
            if (arr[iMedio] > x) {
                der = iMedio - 1;
            }
        }
        return -1;
    }

    public static int busquedaBinariaRecursiva(int[] arr, int ini, int fin, int y){
        //caso base
        if(ini>fin){
            return -1;
        }
        int medio = ini+(fin-ini)/2;
        if(arr[medio] == y){
            return medio;
        } else if(arr[medio]>y){
            return busquedaBinariaRecursiva(arr, ini, medio-1, y);
        } else {
            return busquedaBinariaRecursiva(arr, medio+1, fin, y);
        }
        //return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Ejecutandose");
        int resultado = busquedaBinariaRecursiva(nums, 0, nums.length - 1, 4);
        if (resultado != -1) {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        } else {
            System.out.println("Elemento no encontrado en el arreglo.");
        }
    }
}
