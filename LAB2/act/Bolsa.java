package LAB2.act;

import java.util.ArrayList;
import java.util.Iterator;

public class Bolsa <T> implements Iterable <T>{
    //crear objeto de la clase arrayList con tipos de datos genéricos
    private ArrayList<T> lista = new ArrayList<T>();
    private int tope; //variables que define el tamaño del array

    //constructor
    public Bolsa(int tope){
        super();
        this.tope = tope;
    }
    //método genérico que añade objetos de tipo T
    public void add(T objeto){
        if (lista.size()<=tope){
            lista.add(objeto);
        } else {
            throw new RuntimeException("no caben más");
        }
    }
    //método de la interfaz Iterable
    public Iterator <T> iterator(){
        return lista.iterator();
    }


}
