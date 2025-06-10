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

    //ejercicios 
    //método para eliminar un nodo
    public void remove(E data) throws ItemNotFoundException {
        root = removeRecu(root, data);
    }

    private NodeAVL<E> removeRecu(NodeAVL<E> node, E data) throws ItemNotFoundException {
        if (node == null)
            throw new ItemNotFoundException("Elemento no encontrado: " + data);

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = removeRecu(node.left, data);
        } else if (cmp > 0) {
            node.right = removeRecu(node.right, data);
        } else {
            //Nodo encontrado, cmp =0
            if (node.left == null || node.right == null) {
                NodeAVL<E> temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    node = null; // sin hijos
                } else {
                    node = temp; // un hijo
                }
            } else {
                // Tiene dos hijos
                NodeAVL<E> successor = minValueNode(node.right);
                node.data = successor.data;
                node.right = removeRecu(node.right, successor.data);
            }
        }
        if (node == null)
            return null;
        //Actualizar altura
        node.height = 1 + Math.max(altura(node.left), altura(node.right));

        //Verificar balance
        int balance = getBalance(node);

        //Rebalancear
        //Caso 1 - Izquierda Izquierda
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateSR(node);
        }
        //Caso 2 - Izquierda Derecha
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateSL(node.left);
            return rotateSR(node);
        }
        //Caso 3 - Derecha Derecha
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateSL(node);
        }
        //Caso 4 - Derecha Izquierda
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateSR(node.right);
            return rotateSL(node);
        }
        return node;
    }

    //método para encontrar el nodo con el menor valor (sucesor)
    private NodeAVL<E> minValueNode(NodeAVL<E> node) {
        NodeAVL<E> current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(NodeAVL<E> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    public int getHeight() {
        return altura(root);
    }
    //ejercicio 3
    //recorrido por amplitud o sea por niveles
    public void printLevels() {
        //primero calcular la altura del árbol
        int h = altura(root);
        //como es iterativo usar for
        for (int i = 1; i <= h; i++) {
            System.out.print("Nivel " + (i - 1) + ": ");
            printGivenLevel(root, i);
            System.out.println();
        }
    }
    //imprime nodo de un nivel específico
    private void printGivenLevel(NodeAVL<E> node, int level) {
        if (node == null)
            return;
        //casos base
        if (level == 1)
            System.out.print(node.data + " ");
        //si está en otros niveles, imprime recursivamente
        else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }

    //ejercicio 4
    //recorrido preorden
    // RECORRIDO PREORDER RAIZ - IZQ - DER
    public void preOrder() {
        preOrderRecursive(root);
        System.out.println(); // Salto de línea al final
    }
    private void preOrderRecursive(NodeAVL<E> node) {
        if (node != null) {
            System.out.print(node.data + " "); //Visita el nodo actual
            preOrderRecursive(node.left); // Recorre el subárbol izquierdo
            preOrderRecursive(node.right); // Recorre el subárbol derecho
        }
    }




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

