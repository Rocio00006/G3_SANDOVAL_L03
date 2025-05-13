package F1REVIEW;

public class BusquedaLineal {
    public static <T extends Comparable<T>> T busquedaLinealGenerica(T[] arr){
        T eleMin = arr[0];
        /*for( T e: arr){
            if(e.compareTo(eleMin)<0)
                eleMin = e;
        }*/
        for(int i=1; i<arr.length; i++){
            if(arr[i].compareTo(eleMin)<0){
                eleMin = arr[i];
            }
        }
        return eleMin;
    }
    public static int factorialRecursivo(int n){
        int f;
        if(n==0 || n==1){
            f=1;
            return f;
        } else {
            return n* factorialRecursivo(n-1);
        }
    }
    public static void main(String[] args) {
        Integer[] nums = {10, 8, 30,15,1,2};
        System.out.println(busquedaLinealGenerica(nums));
        System.out.println(factorialRecursivo(5));
    }
}
