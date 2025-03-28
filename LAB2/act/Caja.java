package LAB2.act;

import java.util.ArrayList;

public class Caja <T> {
    private String color; 
    private ArrayList<T> contenido;

    public Caja(String color){
        this.color = color;
        this.contenido = new ArrayList<>();
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public void setContenido(ArrayList<T> contenido){
        this.contenido = contenido;
    }
    public ArrayList<T> getContenido(){
        return contenido;
    }

    //método para añadir elementos T a la caja/arrayList
    public void add(T elemento){
        contenido.add(elemento);
    }
    //método para buscar un elemento en la caja
    public boolean contiene(T elemento){
        if(contenido.contains(elemento))
            return true;
        return false;
        /*for(T e: contenido){
            if(e==elemento)
                return true;
        }
        return false;*/
    }
    //método para eliminar un objeto de la caja
    public T eliminar(T objeto){
        int index = contenido.indexOf(objeto);
        if (index != -1) {
            return contenido.remove(index);
        }
        return null;
        /*if(contiene(objeto))
            contenido.remove(objeto);
            return objeto;
        return null;*/
    }

    @Override
    public String toString(){
        System.out.println("Color   Objeto");
        for(int i=0; i<contenido.size();i++){
            T elemCaja = contenido.get(i);
            System.out.println("Color: "+color+" Objetos: "+elemCaja.toString());
        }
        return "";
    }
}
