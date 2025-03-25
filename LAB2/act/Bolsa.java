package LAB2.act;

import java.util.ArrayList;
import java.util.Iterator;

public class Bolsa <T> implements Iterator <T>{
    private ArrayList<T> lista = new ArrayList<T>();
    private int tope;

    public Bolsa(int tope){
        super();
        this.tope = tope;
    }
    //método genérico
    public void add(T objeto){
        if (lista.size()<=tope){
            lista.add(objeto);
        } else {
            throw new RuntimeException("no caben más");
        }
    }
    //método de la interfaz 
    public Iterator <T> iterator(){
        return lista.iterator();
    }
}
