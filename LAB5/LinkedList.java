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

    //** metodo para eliminar la lista
    public void destroyList(){
        lista = null;
    }

    //**método para buscar un elemento específico 
    public boolean search(E elemento){
        boolean existe = false;

        Node<E> aux = lista;
        while (aux!= null){
            if(aux.getValor().equals(elemento)){
                existe = true;
            }
            aux = aux.getNext();
        }
        return existe;
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

    //*** método par eliminar un nodo
    public void removeNode(E elemento){
        //verificar que la lista no sea vacía;
        if(isEmpty()){
            System.out.println("No existe ese elemento");
        } 
        //si el nodo a eliminar es el primero
        if(lista.getValor().equals(elemento)){
            lista.setNext(lista);
        }

        //el nodo está después del primer elemento
        Node<E> aux = lista;
        while (aux.getNext()!=null) {
            if(aux.getNext().getValor().equals(elemento)){
                aux.setNext(aux.getNext().getNext());
            }
            aux = aux.getNext();
        }
    }
}
