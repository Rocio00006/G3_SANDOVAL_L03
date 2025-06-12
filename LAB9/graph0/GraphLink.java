package LAB9.graph0;

public class GraphLink<E> {
    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<>();
    }

    //método para insertar un vértice
    public void insertVertex(E data) {
        if (!searchVertex(data)) {
            Vertex<E> v = new Vertex<>(data);
            listVertex.add(v);
        }
    }

    //método para insertar una arista
    public void insertEdge(E verOri, E verDes) {
        Vertex<E> vOri = findVertex(verOri);
        Vertex<E> vDes = findVertex(verDes);

        if (vOri != null && vDes != null) {
            Edge<E> edge = new Edge<>(vDes);
            vOri.listAdj.add(edge);
        }
    }

    //método para buscar un vértice
    public boolean searchVertex(E data) {
        return findVertex(data) != null;
    }
    //método que busca y devuelve un vértice 
    private Vertex<E> findVertex(E data) {
        ListLinked.Node<Vertex<E>> aux = listVertex.getHead();
        while (aux != null) {
            if (aux.data.getData().equals(data)) {
                return aux.data;
            }
            aux = aux.next;
        }
        return null;
    }

    //método para buscar una arista
    public boolean searchEdge(E verOri, E verDes) {
        Vertex<E> vOri = findVertex(verOri);
        Vertex<E> vDes = findVertex(verDes);
        if (vOri != null && vDes != null) {
            ListLinked.Node<Edge<E>> aux = vOri.listAdj.getHead();
            while (aux != null) {
                if (aux.data.getRefDest().equals(vDes)) {
                    return true;
                }
                aux = aux.next;
            }
        }
        return false;
    }

    //método para eliminar un vértice
    public void removeVertex(E data) {
        Vertex<E> v = findVertex(data);
        if (v != null) {
            //primero eliminamos las aristas que apuntan a este vértice
            ListLinked.Node<Vertex<E>> auxV = listVertex.getHead();
            while (auxV != null) {
                Vertex<E> temp = auxV.data;
                temp.listAdj.remove(new Edge<>(v));
                auxV = auxV.next;
            }
            //finalmente eliminamos el vértice
            listVertex.remove(v);
        }
    }

    //método para eliminar una arista
    public void removeEdge(E verOri, E verDes) {
        Vertex<E> vOri = findVertex(verOri);
        Vertex<E> vDes = findVertex(verDes);
        if (vOri != null && vDes != null) {
            vOri.listAdj.remove(new Edge<>(vDes));
        }
    }

    //método para el recorrido en profundidad DFS desde v
    public void dfs(E v) {
        Vertex<E> vertexIncio = findVertex(v);
        if (vertexIncio == null) {
            System.out.println("El vértice " + v + " no existe en el grafo");
            return;
        }
        //lista para marcar los vértices visitados
        ListLinked<Vertex<E>> visitados = new ListLinked<>();
        
        System.out.print("DFS desde " + v + ": ");
        dfsRecursive(vertexIncio, visitados);
        System.out.println(); // Nueva línea al final
    }
    private void dfsRecursive(Vertex<E> vertex, ListLinked<Vertex<E>> visitados) {
        // Marcar el vértice actual como visitado
        visitados.add(vertex);
        
        // Mostrar el vértice visitado
        System.out.print(vertex.getData() + " ");
        
        // Recorrer todos los vértices adyacentes
        ListLinked.Node<Edge<E>> aux = vertex.listAdj.getHead();
        while (aux != null) {
            Vertex<E> adjacent = aux.data.getRefDest();
            
            //Si el vértice adyacente no ha sido visitado, visitarlo recursivamente
            if (!isvisitados(adjacent, visitados)) {
                dfsRecursive(adjacent, visitados);
            }
            aux = aux.next;
        }
    }
    private boolean isvisitados(Vertex<E> vertex, ListLinked<Vertex<E>> visitados) {
        ListLinked.Node<Vertex<E>> aux = visitados.getHead();
        while (aux != null) {
            if (aux.data.equals(vertex)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    @Override
    public String toString() {
        return listVertex.toString();
    }
}

