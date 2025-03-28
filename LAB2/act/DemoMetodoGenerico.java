package LAB2.act;

import java.util.ArrayList;

public class DemoMetodoGenerico {
    //definición de método genérico
    public static <T extends Comparable<T>> boolean igualArrays(T[] x, T[] y){
        //primero verificar longitud
        if(x.length!=y.length)
            return false;
        //verificar elementos con la posición i de arreglo x y y
        for(int i=0; i<x.length; i++)
            if(!x[i].equals(y[i]))
                return false;   //arreglos diferentes
        return true;
    }

    //método para ver si existe un elemento en un arreglo de tipo T
    public static <T> boolean exist(T[] arreglo, T elemento){
        for(T e: arreglo){
            if(e.equals(elemento))
                return true;
        }
        return false;
    }

    //metodo para ver si existe un elemento en un arrayList "generico"
    public static <T> boolean exist(ArrayList<T> arrayL, T element){
        for(T e : arrayL){
            if(e.equals(element))
                return true;
        }
        return false;
    }

    public static void main(String[] args) { 
        Integer nums[]={1,2,3,4,5}; //arreglos de tipo Integer
        Integer nums2[]={1,2,3,4,5}; 
        Integer nums3[]={1,2,7,4,5}; 
        Integer nums4[]={1,2,7,4,5,6}; 
        if (igualArrays(nums,nums)) 
            System.out.println("nums es igual a nums"); 
        if (igualArrays(nums,nums2)) 
            System.out.println("nums es igual a nums2"); 
        if (igualArrays(nums,nums3)) 
            System.out.println("nums es igual a num3"); 
        if (igualArrays(nums,nums4)) 
            System.out.println("nums es igual a nums4"); 
 
        // Crea un array de double    //A 
        //Double dvals[]={1.1,2.2,3.3,4.4,5.5};  //B 
        //if(igualArrays(nums,dvals))   //C no se puede hacer la comparación de diferte tipo
        //    System.out.println("nums es igual a dvals"); //D 
    } 
}

