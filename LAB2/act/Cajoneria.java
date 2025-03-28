package LAB2.act;

import java.util.ArrayList;
import java.util.Iterator;

//cajonería será una clase genérica <>
public class Cajoneria <T> implements Iterable <Caja<T>> {

    ArrayList<Caja<T>> cajoneria;//arrayList que contine cajas<T>
    private int tope;

    public Cajoneria(int tope){
        super();
        this.tope = tope;
        cajoneria = new ArrayList<Caja<T>>();
    }

    //método generico para añadir cajas a cajonería
    public void add(Caja<T> ca){
        if(cajoneria.size()<tope){
            cajoneria.add(ca);
        } else {
            throw new RuntimeException("La cajonería está llena");
        }
    }
    //metodo para buscar un elemento de las cajas
    public void search(T elemento){
        //recorremos las cajas de la cajonería
        for(int i=0; i< cajoneria.size(); i++){
            //caja tomará el valor de cada caja en la cajonería
            Caja<T> caj = cajoneria.get(i);
            if(caj.contiene(elemento)==true){
                System.out.println("Posición: "+caj.getContenido().get(i)+" Color caja: "+caj.getColor());
            }
        }
    }

    //método para eliminar un elemento
    public T delete(T elemento){
        for(Caja<T> caja : cajoneria){
            T objeto = caja.eliminar(elemento);
            if(objeto!=null){
                return objeto;
            }
        }
        return null;
    }

    @Override
    //método que devuelve cadena de datos
    public String toString() {
        System.out.println("Posicion\tColor Caja\tObjeto");
        for (int i = 0; i < cajoneria.size(); i++) {
            Caja<T> caja = cajoneria.get(i);
            for (T objeto : caja.getContenido()) {
                System.out.printf("%d\t%s\t%s%n", 
                    (i + 1), 
                    caja.getColor(), 
                    objeto.toString()
                );
            }
        }
        return "";
    }
    //implementamos método abstracto de la interfaz Iterable
    public Iterator<Caja<T>> iterator() {
        return cajoneria.iterator();
    }
}
