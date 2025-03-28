package LAB2.act;

import java.util.ArrayList;

public class TestGen2 {
    public static void main(String[] args) {
        //creamos un objeto Cajoraneria que almacene golosinas
        Cajoneria<Golosina> cajoneria1 = new Cajoneria<>(5);
        //Cajoneria<Caja<Golosina>> cajoneria1 = new Cajoneria<Caja<Golosina>>(6);

        //primero creamos cajas
        Caja<Golosina> cajaRoja = new Caja<>("roja");
        Caja<Golosina> cajaNegra = new Caja<>("negra");

        //creamos golosinas que irán en las cajas
        Golosina g1 = new Golosina("gomitas", 10);
        Golosina g2 = new Golosina("cHICLES", 5);
        Golosina g3 = new Golosina("Dulces", 3);
        Golosina g4 = new Golosina("OleOle", 3);
        Golosina g5 = new Golosina("Trident", 3);

        //agregamos golosinas a las cajas, por ende a la cajonería
        cajaRoja.add(g1);
        cajaRoja.add(g2);
        cajaRoja.add(g3);
        cajaNegra.add(g4);
        cajaNegra.add(g5);
        
        //agregamos cajas a la cajoneria
        cajoneria1.add(cajaRoja);
        cajoneria1.add(cajaNegra);

        //verificamos que hayan golosinas en la cajonería
        cajoneria1.search(g5);
        
        // Imprimir el contenido de la cajoneria
        System.out.println("Contenido de la Cajonería:");
        cajoneria1.toString();

        //eliminamos una golosina de la cajonería
        cajoneria1.delete(g5);

        // Imprimir el contenido de la cajoneria
        System.out.println("Contenido de la Cajonería:");
        cajoneria1.toString();


        
        

        /*
        // Búsqueda de golosinas por nombre
        System.out.println("\nBuscando golosinas por nombre:");
        cajoneria1.search(new Golosina("Trident", 0));

        // Búsqueda de golosinas por peso
        System.out.println("\nBuscando golosinas por peso:");
        cajoneria1.search(new Golosina("", 15.0));

        // Prueba de eliminación
        System.out.println("\nEliminando una golosina:");
        Golosina eliminada = cajoneria1.delete(new Golosina("Orbit", 8.2));
        System.out.println("Golosina eliminada: " + eliminada);

        // Imprimir cajonería después de eliminación
        System.out.println("\nContenido de la Cajonería después de eliminación:");
        cajoneria1.toString();
        */
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
