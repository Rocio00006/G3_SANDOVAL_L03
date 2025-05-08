package LAB5;

public class Ejercicio2 {
    //EJER2
    public static <T> ArrList<T> invertirLista(ArrList<T> lista){
        T[] copia = lista.getLista();
        int tmñActual = lista.getTmñ();
        ArrList<T> listaInve = new ArrList<>(tmñActual);

        //vamos a insertar desde el final al inicio
        for(int i=tmñActual-1; i>=0;i--){
            listaInve.insertarElemento(copia[i]);
        }
        return listaInve;
    }
    public static void main(String[] args) {
        //lista genérica
        ArrList<String> lis = new ArrList<>(5);
        System.out.println("**** INsertamos elementos a lista Genérica String");
        lis.insertarElemento("Chio");
        lis.insertarElemento("Rocio");
        lis.insertarElemento("Marco");
        lis.mostrarLista();
        
        Tarea t1 = new Tarea("ESTADÍSTICA", 1);
        Tarea t2 = new Tarea("SIA", 10);
        Tarea t3 = new Tarea("ADS", 15);

        ArrList<Tarea> lisGen = new ArrList<Tarea>(3);
        System.out.println("\n****INsertamos elementos a lista Genérica Tarea");
        lisGen.insertarElemento(t1);
        lisGen.insertarElemento(t2);
        lisGen.insertarElemento(t3);
        //System.out.println("Existe tarea ADS: "+buscarElemento(lisGen, t3));
        lisGen.mostrarLista();

        System.out.println("\n****E2: Invertir Lista");
        lisGen.invertirLista();
        System.out.println("Ha quedado así: ");
        lisGen.mostrarLista();


    }
}
