package LAB2.act;
import java.util.ArrayList;

public class TestGen {
    public static void main(String[] args) {
        /*String[] v = {"Perez", "Sanchez","Rodriguez"};
        Integer[] w = {12,34,56};

        System.out.println(exist(v,"Sanchez")); //true 
        System.out.println(exist(w,34));        //true
        System.out.println(exist(w,"Salas"));   //false*/

        //ejercicio 1

        //creación de un arreglo "tradicional" de golosinas 
        Golosina g1 = new Golosina("gomitas", 10);
        Golosina g2 = new Golosina("cHICLES", 5);
        Golosina g3 = new Golosina("Dulces", 3);

        Golosina[] golosinas = new Golosina[3];
        golosinas[0]=g1;
        golosinas[1]=g2;
        golosinas[2]=g3;
        
        //creamos una golosina que no está en el arreglo
        Golosina g4 = new Golosina("PAN", 29);

        //verificamos si el metodo exist funciona
        System.out.println("Golosinas");
        System.out.println(g1.getNombre()+" está en el arreglo? "+exist(golosinas, g1));   //true
        System.out.println(g4.getNombre()+" está en el arreglo? "+exist(golosinas, g4));   //false

        //creamos un arreglo de Chocolatinas con ArrayList
        ArrayList<Chocolatina> chocolatinas = new ArrayList<>();

        Chocolatina c1=new Chocolatina("milka");
        Chocolatina c2=new Chocolatina("ferrero");
        chocolatinas.add(c1);   //añadimos las chocolatinas
        chocolatinas.add(c2);

        //creamos una chocolatina que no está en el arrayList
        Chocolatina c4 = new Chocolatina("KitKat"); 

        //verificamos si las chocolatinas están en el arreglo con exist()
        System.out.println("\nChocolatinas");
        System.out.println(c2.getMarca()+" existe? "+exist(chocolatinas, c2));    //true
        System.out.println(c4.getMarca()+" existe?"+exist(chocolatinas, c4));    //false

    }

    //método genérico para ver si existe un elemento en un arreglo de tipo T
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
}
