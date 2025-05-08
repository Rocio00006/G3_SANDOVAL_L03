package LAB5;

public class LinkedList<E>  {
    private Node<E> lista;  //representa el primero valor de la lista

    //constructor
    public LinkedList(){
        this.lista = null;  //lista vacia tiene la cabecera como null
    }
    
    //--metodo para ver si la lista está vacía
    public boolean isEmpty(){
        if(lista == null)
            return true;
        return false;
    }

    //--número elementos en la lista
    public int length(){
        int conta =0;
        Node<E> aux = lista;    //tomar el primero nodo
        while(aux != null){     //si no es null empieza a ocntar
            conta++;
            aux = aux.getNext();    //pasa al siguiente nodo
        }
        return conta;
    }

    //--metodo para eliminar la lista
    public void destroyList(){
        lista = null;
    }

    //--método para buscar un elemento específico 
    public boolean search(E elemento){
        boolean existe = false;

        Node<E> aux = lista;
        while (aux!= null){
            if(aux.getValor().equals(elemento)){
                existe = true;
                return existe;  //cuando lo encuentra, ya no busca 
            }
            aux = aux.getNext();
        }
        return existe;
    }

    //--método para insertar un dato/valor al inicio
    public void insertFirst(E dato){
        Node<E> nuevo = new Node<E>(dato);
        if(isEmpty()){
            lista = nuevo;
        }
        else{
            nuevo.setNext(lista);
            lista = nuevo;
        }
    }

    //--método para insertar un dato al final
    public void insertFinal(E dato){
        Node<E> nuevo = new Node<E>(dato);
        if(isEmpty()){
            lista = nuevo;
            return; //terminar
        }
        Node<E> actual = lista;
        //while para moverse al final
        while (actual.getNext()!=null) {
            actual = actual.getNext();
        }
        actual.setNext(nuevo);
    }

    //--método par eliminar un nodo
    public void removeNode(E elemento){
        //verificar que la lista no sea vacía;
        if(isEmpty()){
            System.out.println("No existe ese elemento");
            return; //omite las siguiente líneas
        } 
        //si el nodo a eliminar es el primero
        if(lista.getValor().equals(elemento)){
            lista = lista.getNext();
            return; 
        }

        //el nodo está después del primer elemento
        Node<E> aux = lista;
        while (aux.getNext()!=null) {
            if(aux.getNext().getValor().equals(elemento)){
                aux.setNext(aux.getNext().getNext());
            } else{
                aux = aux.getNext();
            }
        }
    }

    //--método para mostrar la lista
    public void print(){
        if(isEmpty()){
            System.out.println("Lista vacía");
            return;
        }
        Node<E> aux = lista;
        while(aux!=null){
            //System.out.println(aux.toString());
            System.out.println(aux.getValor());
            aux = aux.getNext();
        }
    }

    //--métpdp para ordenar una lista
    public void ordenar(){
        if(isEmpty() || length()==1){
            System.out.println("Lista vacía u ya ordenada");
            return;
        }
        System.out.println("...");
        //para odernar usar mergeSort o bubble sort
    }

    //--método para insertar un valor en una posi específica
    public void insertEnNodo(E ele, E posi){
        Node<E> nuevo = new Node<E>(ele);   //elemento nuevo
        Node<E> posicion = new Node<E>(posi);   //después de este nodo

        //verificar si el nodo existe
        if(!search(posi)){
            System.out.println("La posición no existe");
            return;
        } 
        else{
            Node<E> aux = lista;
            while (aux !=null) {
                if(aux.equals(posicion)){
                    nuevo.setNext(aux.getNext());
                }else{
                    aux = aux.getNext();
                }
            }
        }
    }

    //--método para invertir la lista
    public void invertir(){
        //usaremos 3 "punteros": ant, act, sig
        //para gestionar las posiciones
        Node<E> ante = null;    //nodo que se ha procesado
        Node<E> actu = lista;   //nodo siendo procesado
        Node<E> sigu= null;     //guard tempo nodo siguiente
        while(actu!=null){
            sigu = actu.getNext();  //guarda el siguie nodo
            //el sigu de act apunta al anterior
            actu.setNext(ante);//invierte
            ante = actu;    //avanza al anterior
            actu = sigu;    //avanza la actual
        }
        lista = ante;   //actualiza el inicia de la lista
    }
    //método para obtener el primer elemento de la lista
    public E getFirst(){
        return lista.getValor();
    }
    //--método para obetener el primer nodo de la lista
    public Node<E> getFirstNode(){
        return lista;
    }
}
