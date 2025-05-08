package LAB5;

public class Ejercicios {
    //ejer1
    //método genérico q recibe una list<T> y busca un valor T
    public static <T> boolean buscarElemento(ArrList<T> lista, T elemento){
        T[] lis = lista.getLista();
        //vamos a recorrer todo la lista
        for( T e : lis){
            //es posible que la lista no este llena
            if(e!=null && e.equals(elemento))
                return true;
        }
        return false;
    }

    
    public static void main(String[] args) {
        //lista genérica
        ArrList<String> lis = new ArrList<>(5);
        System.out.println("**** INsertamos elementos a lista Genérica String");
        lis.insertarElemento("Chio");
        lis.insertarElemento("Rocio");
        lis.insertarElemento("Marco");
        System.out.println("Existe Rocio: "+buscarElemento(lis, "Rocio"));
        lis.mostrarLista();
        
        Tarea t1 = new Tarea("ESTADÍSTICA", 1);
        Tarea t2 = new Tarea("SIA", 10);
        Tarea t3 = new Tarea("ADS", 15);

        ArrList<Tarea> lisGen = new ArrList<Tarea>(3);
        System.out.println("\n****INsertamos elementos a lista Genérica Tarea");
        lisGen.insertarElemento(t1);
        lisGen.insertarElemento(t2);
        //lisGen.insertarElemento(t3);
        System.out.println("Existe tarea ADS: "+buscarElemento(lisGen, t3));
        lisGen.mostrarLista();
    }
}
