package LAB8;

import LAB7.actividad.Exceptions.*;

public class AVLTree<E extends Comparable<E>> {

    private NodeAVL<E> root;

    //CONSTRUCTOR
    public AVLTree(){
        this.root = null;
    }
    //método devuelve la altura de un nodo
    private int altura(NodeAVL<E> nodo) {
        if(nodo==null)
            return 0;
        else{
            return nodo.height;
        }
    }
    //método que retorna el factor balance de un nodo
    public int getBalance(NodeAVL<E> nodo){
        if(nodo==null)
            return 0;
        else{
            return altura(nodo.left)-altura(nodo.right);
        }
    }

    //@Override
    public void insert(E data) throws ItemDuplicatedException {
        root = insertRecu((NodeAVL<E>) root, data);
    }

    private NodeAVL<E> insertRecu(NodeAVL<E> node, E data) throws ItemDuplicatedException {
        if (node == null) {
            return new NodeAVL<>(data);
        }
        int cmp = data.compareTo((E) node.data);
        if(cmp==0)
            throw new ItemDuplicatedException(data +" ya existe.");
        if(cmp<0){
            node.left=insertRecu(node.left, data);
        }else if (cmp>0){
            node.right = insertRecu(node.right, data);
        } else{
            return node;
        }
        //una vez se haya insertado, actualizar altura nodo actual
        //la altura es el mayor camino de sus hijos
        node.height = 1 + Math.max(altura(node.left), altura(node.right));

        int balance = getBalance(node);
        //SEGÚN EL RESULTADO DEL BALANCE HAREMOS LAS ROTACIONES RESPECTIVAS

        //Caso 1: el nodo está muy a la izquierda izquierda
        //cuando su balance es >1 y el valor ingresado es < que el hijo izq del nodo
        if(balance>1 && data.compareTo(node.left.data)<0){
            return rotateSR(node);
        }
        //Caso 2: nodo está muy a la derecha derecha
        //cuando su balance es <1 y el valor ingresao es > que el hijo der del nodo
        if(balance<-1 && data.compareTo(node.right.data)>0){
            return rotateSL(node);
        }
        //caso 3: nodo estaá a la izquierda - derecha
        //cuando se inserta en el hijo derecho del hijo izquierdo 
        //su balance es >1 y el valor ingresado es > que el hijo izquierdo
        if(balance>1 && data.compareTo(node.left.data)>0){
            //hacer rotacion doble a la derecha: 1° RSI en el hijo izq y 2° RSD en el nodo
            node.left = rotateSL(node.left);
            return rotateSR(node);
        }
        //Caso 4: nodo está a la derecha - izquierda
        //cuando se inserta en el hijo izquierdo del hijo derecho
        //su balance es <1 y el valor ingresado es menor que el hijo derecho
        if(balance<-1 && data.compareTo(node.right.data)<0){
            //hacer rotación doble a la izquierda
            //1° RSD en el hijo derecho y luego RDI en el nodo
            node.right = rotateSR(node.right);
            return rotateSL(node);
        }
        return node;
    }

    // método para rotación simple a derecha
    //se usa en el caso izquierda-izquierda
    private NodeAVL<E> rotateSR(NodeAVL<E> node) {

        if (node == null || node.left == null) {
            return node; // No se puede rotar
        }

        //guardar el hijo izq
        NodeAVL<E> leftChild = node.left;
        //mover el subarbol derecho del hijo izq a la izq del nodo 
        node.left = leftChild.right;
        //node ahora seá el hijo derecho de leftchild
        leftChild.right = node;

        //Ajustar factores de equilibrio
        node.bf = 0;
        leftChild.bf = 0;

        // Actualizar alturas
        node.height = 1 + Math.max(altura(node.left), altura(node.right));
        leftChild.height = 1 + Math.max(altura(leftChild.left), altura(leftChild.right));

        return leftChild; //nueva raíz del subárbol
    }

    // método para rotación simple a la izquierda
    //se usa en el caso derecha-derecha
    private NodeAVL<E> rotateSL(NodeAVL<E> node) {

        if (node == null || node.right == null) {
            return node; // No se puede rotar
        }
        //guardar el hijo derecho
        NodeAVL<E> rightChild = node.right;
        //mover el subárbol izquierdo del hijo derecha a la der del nodo
        node.right = rightChild.left;
        //ahora node será el hijo izq de rightChild
        rightChild.left = node;

        //Ajustar factores de equilibrio
        node.bf = 0;
        rightChild.bf = 0;

         // Actualizar alturas
        node.height = 1 + Math.max(altura(node.left), altura(node.right));
        rightChild.height = 1 + Math.max(altura(rightChild.left), altura(rightChild.right));

        return rightChild; //nueva raíz del subárbol
    }


    /*
    INSERTAR UN NODO, PERO CON EL FB
    int cmp = data.compareTo((E) node.data);
        if(cmp==0)
            throw new ItemDuplicatedException(data +" ya existe.");

        if (cmp < 0) {
            node.left = insertRecu((NodeAVL<E>) node.left, data);
            node.bf--;

            if (node.bf == -2) {
                NodeAVL<E> leftChild = (NodeAVL<E>) node.left;
                if (leftChild.bf <= 0) {
                    node = rotateSR(node); // RSR
                } else {
                    node.left = rotateSL(leftChild); // RDR
                    node = rotateSR(node);
                }
            }

        } else if (cmp > 0) {
            node.right = insertRecu((NodeAVL<E>) node.right, data);
            node.bf++;

            if (node.bf == 2) {
                NodeAVL<E> rightChild = (NodeAVL<E>) node.right;
                if (rightChild.bf >= 0) {
                    node = rotateSL(node); // RSL
                } else {
                    node.right = rotateSR(rightChild); // RDL
                    node = rotateSL(node);
                }
            }
        }
        return node;
     */
}

