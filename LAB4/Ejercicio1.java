package LAB4;

public class Ejercicio1 {

    public static boolean esPotenciaDe2(int n){
        if(n>0 && Integer.highestOneBit(n)==n)
            return true;
        return false;
    }

    public static boolean verificarSuma(int[] arr){
        //int n = arr.length -2; //cantidad de elementos*
        int su = 0;

        for(int i=1; i<arr.length -1;  i++){
            if(esPotenciaDe2(arr[i])){
                su = su+ arr[i];
            }
            if(arr[i]%5==0 && arr[i+1]%2==0){
                su = su+arr[i];
            }
        }
        if(su == arr[arr.length-1]){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] arreglo = {5, 2, 4, 8, 10, 3, 14};
        int[] arreglo2 = {5,4,8,10,3,5,27};
        //int[] arreglo3 = {5,4,8,10,3,6,27};
        //int[] arreglo4 = {6, 2, 16, 5, 7, 10, 33};

        System.out.println(verificarSuma(arreglo2));
    }
}

