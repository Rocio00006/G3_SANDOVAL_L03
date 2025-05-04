package LAB5;

public class LinkedList<E>  {
    private Node<E> lista;  //representa el primero valor de la lista

    //constructor
    public LinkedList(){
        this.lista = null;  //lista vacia tiene la cabecera como null
    }
    
    //**metodo para ver si la lista está vacía
    public boolean isEmpty(){
        if(lista == null)
            return true;
        return false;
    }

    //**número elementos en la lista
    public int length(){
        int conta =0;
        Node<E> aux = lista;    //tomar el primero nodo
        while(aux != null){     //si no es null empieza a ocntar
            conta++;
            aux = aux.getNext();    //pasa al siguiente nodo
        }
        return conta;
    }

    //**método para insertarun dato/valor al inicio
    public void insertFirst(E dato){
        Node<E> nuevo = new Node<E>(dato);
        if(isEmpty()){
            lista = nuevo;
        }
        nuevo.setNext(lista);
        lista = nuevo;
    }

    //**método para insertar un dato al final
    public void insetarFinal(E dato){
        Node<E> nuevo = new Node<E>(dato);
        if(isEmpty()){
            lista = nuevo;
        }

        Node<E> actual = lista;
        //while para moverse al final
        while (actual.getNext()!=null) {
            actual = actual.getNext();
        }
        actual.setNext(nuevo);
        //nuevo.setNext(null); no es necesario
    }

}
