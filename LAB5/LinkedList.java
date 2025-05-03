package LAB5;

public class LinkedList<E>  {
    private Node<E> lista;      //representa el primero valor
    private int tmñ;

    public LinkedList(){
        this.lista = null;      //lista vacia tiene la cabecera como null
        this.tmñ= 0;
    }
    
    //metodos de las listas
    //ver si está vacío
    public boolean isEmpty(Node<E> lista){
        if(lista.valor == null)
            return true;
        return false;
        //o si el tmñ está en 0
    }
    public void insertFirst(Node<E> ele){
        Node<E> nuevo = new Node<E>(ele);
        lista.next 

    }
}
