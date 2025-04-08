package LAB4;

public class Ejercicio1 {

    public static int sumaElementos(int[] arrComple){
        int suma =0;
        int[] elementos = new int[arrComple.length -2];
        //int[] elementos;
        for(int i=1; i<arrComple.length-1; i++){
            if(Math.sqrt(arrComple[i])%1==0){
                suma = suma+arrComple[i];
                elementos[i]= arrComple[i];
                i++;
            }
            if(arrComple[i]%5==0 && arrComple[i+1]%2==0){
                suma=suma+arrComple[i];
            }
        }
        return suma;
    }
    public static boolean verificar(int[] arrComple){

        if(arrComple[arrComple.length-1]==sumaElementos(arrComple)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arreglo = {5, 2, 4, 8, 10, 3, 14};
        
        System.out.println(verificar(arreglo));
        System.out.println(sumaElementos(arreglo));
    }
}
