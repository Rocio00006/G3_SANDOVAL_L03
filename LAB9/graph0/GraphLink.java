package LAB9.graph0;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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

    // *******************EJERCICIOS
    // 1.A
    // método para bfs recorrido en amplitud BFS
    public void bfs(E v) {
        Vertex<E> startVertex = findVertex(v);
        if (startVertex == null) {
            System.out.println("El vértice " + v + " no existe en el grafo");
            return;
        }

        // Cola para el recorrido
        Queue<Vertex<E>> queue = new LinkedList<>();
        // Lista para marcar los visitados
        ListLinked<Vertex<E>> visitados = new ListLinked<>();

        // Agregar el vértice inicial
        queue.offer(startVertex);
        visitados.add(startVertex);

        System.out.print("BFS desde " + v + ": ");

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            System.out.print(current.getData() + " ");

            ListLinked.Node<Edge<E>> aux = current.listAdj.getHead();
            while (aux != null) {
                Vertex<E> neighbor = aux.data.getRefDest();
                if (!isvisitados(neighbor, visitados)) {
                    queue.offer(neighbor);
                    visitados.add(neighbor);
                }
                aux = aux.next;
            }
        }
        System.out.println();
    }


    //e1.2.
    public ArrayList<E> bfsPath(E dataInicio, E dataFinal) {
        Vertex<E> start = findVertex(dataInicio);
        Vertex<E> end = findVertex(dataFinal);

        if (start == null || end == null) {
            return null;
        }
        Map<Vertex<E>, Vertex<E>> parentMap = new HashMap<>(); // para reconstruir el camino
        Set<Vertex<E>> visited = new HashSet<>();
        Queue<Vertex<E>> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);
        parentMap.put(start, null); // el inicio no tiene padre

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();

            if (current.equals(end)) {
                break; // se encontró el destino
            }

            ListLinked.Node<Edge<E>> adj = current.getListAdj().getHead();
            while (adj != null) {
                Vertex<E> neighbor = adj.data.getRefDest();
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, current); // se registra el padre
                }
                adj = adj.next;
            }
        }

        //reconstruir el camino desde end hasta start usando parentMap
        if (!parentMap.containsKey(end)) {
            return null; // no hay camino
        }
        ArrayList<E> path = new ArrayList<>();
        for (Vertex<E> v = end; v != null; v = parentMap.get(v)) {
            path.add(0, v.getData()); // insertar al inicio
        }
        return path;
    }

    //EJERCICIO 2
    //2.A
    //insertar una arista con peso
    public void insertEdgeWeight(E v, E z, int w) {
        Vertex<E> vOri = findVertex(v);
        Vertex<E> vDes = findVertex(z);

        if (vOri != null && vDes != null) {
            Edge<E> edge = new Edge<>(vDes, w);
            vOri.listAdj.add(edge);
        }
    }
   
    // 2.B.
    // método que calcula la ruta más corta
    public ArrayList<E> shortPath2(E v, E z) {
        return bfsPath(v, z); // Para grafos no ponderados, BFS da la ruta más corta
    }

    //método para para el camino más corto pero según el peso
    public ArrayList<E> shortPath(E dataInicio, E dataFinal) {
        Vertex<E> start = findVertex(dataInicio);
        Vertex<E> end = findVertex(dataFinal);
        if (start == null || end == null)
            return null;

        Map<Vertex<E>, Double> dist = new HashMap<>();
        Map<Vertex<E>, Vertex<E>> prev = new HashMap<>();
        PriorityQueue<Vertex<E>> queue = new PriorityQueue<>(Comparator.comparingDouble(dist::get));

        for (ListLinked.Node<Vertex<E>> n = listVertex.getHead(); n != null; n = n.next) {
            dist.put(n.data, Double.POSITIVE_INFINITY);
            prev.put(n.data, null);
        }
        dist.put(start, 0.0);
        queue.offer(start);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            if (current.equals(end))
                break;

            ListLinked.Node<Edge<E>> adj = current.getListAdj().getHead();
            while (adj != null) {
                Vertex<E> neighbor = adj.data.getRefDest();
                double weight = adj.data.getWeight();
                double alt = dist.get(current) + weight;
                if (alt < dist.get(neighbor)) {
                    dist.put(neighbor, alt);
                    prev.put(neighbor, current);
                    queue.remove(neighbor); // reinsert to update priority
                    queue.offer(neighbor);
                }
                adj = adj.next;
            }
        }

        if (dist.get(end) == Double.POSITIVE_INFINITY)
            return null;

        ArrayList<E> path = new ArrayList<>();
        for (Vertex<E> at = end; at != null; at = prev.get(at)) {
            path.add(0, at.getData());
        }

        return path;
    }

    // 2.c.
    //método para ver si es conexo
    //todos los vertices son alcanzables desde cualquier otro
    public boolean isConexo() {
        if (listVertex.getHead() == null)
            return true;

        Set<Vertex<E>> visitados = new HashSet<>();
        Queue<Vertex<E>> queue = new LinkedList<>();

        Vertex<E> start = listVertex.getHead().data;
        queue.offer(start);
        visitados.add(start);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            ListLinked.Node<Edge<E>> adj = current.listAdj.getHead();
            while (adj != null) {
                Vertex<E> neighbor = adj.data.getRefDest();
                if (!visitados.contains(neighbor)) {
                    visitados.add(neighbor);
                    queue.offer(neighbor);
                }
                adj = adj.next;
            }
        }
        //Revisamos si todos los vértices fueron visitados
        int totalVertices = 0;
        for (ListLinked.Node<Vertex<E>> aux = listVertex.getHead(); aux != null; aux = aux.next) {
            totalVertices++;
        }
        return visitados.size() == totalVertices;
    }

    // 2.d dijkstra
    public Stack<E> dijkstra(E dataInicio, E dataFinal) {
        Vertex<E> start = findVertex(dataInicio);
        Vertex<E> end = findVertex(dataFinal);
        if (start == null || end == null)
            return null;

        Map<Vertex<E>, Double> dist = new HashMap<>();
        Map<Vertex<E>, Vertex<E>> prev = new HashMap<>();
        PriorityQueue<Vertex<E>> queue = new PriorityQueue<>(Comparator.comparingDouble(dist::get));

        for (ListLinked.Node<Vertex<E>> n = listVertex.getHead(); n != null; n = n.next) {
            dist.put(n.data, Double.POSITIVE_INFINITY);
            prev.put(n.data, null);
        }
        dist.put(start, 0.0);
        queue.offer(start);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            if (current.equals(end))
                break;

            ListLinked.Node<Edge<E>> adj = current.getListAdj().getHead();
            while (adj != null) {
                Vertex<E> neighbor = adj.data.getRefDest();
                double weight = adj.data.getWeight();
                double alt = dist.get(current) + weight;
                if (alt < dist.get(neighbor)) {
                    dist.put(neighbor, alt);
                    prev.put(neighbor, current);
                    queue.remove(neighbor);
                    queue.offer(neighbor);
                }
                adj = adj.next;
            }
        }
        if (dist.get(end) == Double.POSITIVE_INFINITY)
            return null;
        Stack<E> path = new Stack<>();
        for (Vertex<E> at = end; at != null; at = prev.get(at)) {
            path.push(at.getData());
        }
        return path;
    }



    /*//2.c extra método para verificar si el grafo es conexo
    public boolean isConexo() {
        if (listVertex.isEmpty()) {
            return true; // Un grafo vacío se considera conexo
        }

        // Obtener el primer vértice
        Vertex<E> primerVertice = listVertex.get(0);
        
        // Realizar DFS desde el primer vértice
        ListLinked<Vertex<E>> visitados = new ListLinked<>();
        dfsParaConexo(primerVertice, visitados);
        
        // Verificar si todos los vértices fueron visitados
        return visitados.size() == listVertex.size();
    }

    private void dfsParaConexo(Vertex<E> vertex, ListLinked<Vertex<E>> visitados) {
        visitados.add(vertex);
        
        ListLinked.Node<Edge<E>> aux = vertex.listAdj.getHead();
        while (aux != null) {
            Vertex<E> adjacent = aux.data.getRefDest();
            
            if (!isvisitados(adjacent, visitados)) {
                dfsParaConexo(adjacent, visitados);
            }
            aux = aux.next;
        }
    }*/

    @Override
    public String toString() {
        return listVertex.toString();
    }
}

