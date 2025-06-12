package LAB9.graph5;

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
        // Verificar que no exista ya la arista para evitar duplicados
        if (!searchEdge(verOri, verDes)) {
            Edge<E> edge1 = new Edge<>(vDes);
            vOri.listAdj.add(edge1);
            
            // Solo agregar la arista inversa si no es un self-loop
            if (!vOri.equals(vDes)) {
                Edge<E> edge2 = new Edge<>(vOri);
                vDes.listAdj.add(edge2);
            }
        }
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


    @Override
    public String toString() {
        return listVertex.toString();
    }

    //JERCICIO 5

    // a) Grado de un nodo (Gx) - cantidad de aristas conectadas del nodo
    public int gradoNodo(E data) {
        Vertex<E> vertex = findVertex(data);
        if (vertex == null) {
            throw new IllegalArgumentException("El vértice " + data + " no existe en el grafo");
        }

        int grado = 0;
        ListLinked.Node<Edge<E>> aux = vertex.listAdj.getHead();
        while (aux != null) {
            grado++;
            aux = aux.next;
        }
        return grado;
    }

    // Método auxiliar para contar el número total de vértices
    public int contarVertices() {
        int count = 0;
        ListLinked.Node<Vertex<E>> aux = listVertex.getHead();
        while (aux != null) {
            count++;
            aux = aux.next;
        }
        return count;
    }

    // b) Camino (Px) - si todas las aristas están conectadas, sin conectar inicio y
    // final
    public boolean esCamino() {
        if (!isConexo()) {
            return false;
        }
        int totalVertices = contarVertices();
        if (totalVertices < 2) {
            return false;
        }
        // Para ser un camino: exactamente 2 nodos de grado 1 y el resto de grado 2
        int nodosGrado1 = 0;
        int nodosGrado2 = 0;
        ListLinked.Node<Vertex<E>> aux = listVertex.getHead();
        while (aux != null) {
            int grado = gradoNodo(aux.data.getData());
            if (grado == 1) {
                nodosGrado1++;
            } else if (grado == 2) {
                nodosGrado2++;
            } else {
                return false; // Si hay nodos con grado diferente a 1 o 2
            }
            aux = aux.next;
        }
        return nodosGrado1 == 2 && nodosGrado2 == (totalVertices - 2);
    }

    // c) Ciclo (Cx) - si todas las aristas están conectadas, conectando inicio y
    // final
    public boolean esCiclo() {
        if (!isConexo()) {
            return false;
        }
        int totalVertices = contarVertices();
        if (totalVertices < 3) {
            return false;
        }
        // Para ser un ciclo: todos los nodos deben tener grado 2
        ListLinked.Node<Vertex<E>> aux = listVertex.getHead();
        while (aux != null) {
            if (gradoNodo(aux.data.getData()) != 2) {
                return false;
            }
            aux = aux.next;
        }
        return true;
    }

    //d) Rueda (Wx) - todos los nodos conectados menos uno formando ciclo,
    //el suelto conectado con todos los demás
    public boolean esRueda() {
        int totalVertices = contarVertices();
        if (totalVertices < 4) {
            return false; // Una rueda necesita al menos 4 nodos
        }
        if (!isConexo()) {
            return false;
        }
        // Buscar el nodo central (debe tener grado n-1)
        Vertex<E> nodoCentral = null;
        int nodosConGradoMaximo = 0;

        ListLinked.Node<Vertex<E>> aux = listVertex.getHead();
        while (aux != null) {
            int grado = gradoNodo(aux.data.getData());
            if (grado == totalVertices - 1) {
                nodoCentral = aux.data;
                nodosConGradoMaximo++;
            }
            aux = aux.next;
        }
        if (nodosConGradoMaximo != 1) {
            return false; // Debe haber exactamente un nodo central
        }
        // Los demás nodos deben tener grado 3
        // (conectados al centro y a 2 vecinos en el ciclo)
        aux = listVertex.getHead();
        while (aux != null) {
            if (!aux.data.equals(nodoCentral)) {
                if (gradoNodo(aux.data.getData()) != 3) {
                    return false;
                }
            }
            aux = aux.next;
        }
        // Verificar que los nodos no centrales formen un ciclo
        // (cada nodo externo debe estar conectado exactamente a 2 otros nodos externos)
        aux = listVertex.getHead();
        while (aux != null) {
            if (!aux.data.equals(nodoCentral)) {
                int conexionesExternas = 0;
                ListLinked.Node<Edge<E>> auxEdge = aux.data.listAdj.getHead();
                while (auxEdge != null) {
                    if (!auxEdge.data.getRefDest().equals(nodoCentral)) {
                        conexionesExternas++;
                    }
                    auxEdge = auxEdge.next;
                }
                if (conexionesExternas != 2) {
                    return false;
                }
            }
            aux = aux.next;
        }
        return true;
    }

    //e) Completo (Kx) - si todos los nodos y sus vértices están conectados entre SI
    public boolean esCompleto() {
        int totalVertices = contarVertices();
        if (totalVertices < 2) {
            return totalVertices <= 1; // Un grafo vacío o con 1 vértice es completo
        }
        //En un grafo completo, cada nodo debe tener grado (n-1)
        ListLinked.Node<Vertex<E>> aux = listVertex.getHead();
        while (aux != null) {
            if (gradoNodo(aux.data.getData()) != totalVertices - 1) {
                return false;
            }
            aux = aux.next;
        }
        //Verificar que efectivamente cada nodo esté conectado a todos los demás
        aux = listVertex.getHead();
        while (aux != null) {
            Vertex<E> vertexActual = aux.data;
            //Verificar conexiones con todos los otros vértices
            ListLinked.Node<Vertex<E>> auxOtros = listVertex.getHead();
            while (auxOtros != null) {
                if (!auxOtros.data.equals(vertexActual)) {
                    // Buscar si existe arista entre vertexActual y auxOtros.data
                    boolean encontrada = false;
                    ListLinked.Node<Edge<E>> auxEdge = vertexActual.listAdj.getHead();
                    while (auxEdge != null) {
                        if (auxEdge.data.getRefDest().equals(auxOtros.data)) {
                            encontrada = true;
                            break;
                        }
                        auxEdge = auxEdge.next;
                    }
                    if (!encontrada) {
                        return false;
                    }
                }
                auxOtros = auxOtros.next;
            }
            aux = aux.next;
        }
        return true;
    }

    // Métodos auxiliares para crear grafos específicos (útiles para testing)

    // Crear un camino P_n
    public static GraphLink<Integer> crearCamino(int n) {
        GraphLink<Integer> grafo = new GraphLink<>();

        // Insertar vértices
        for (int i = 0; i < n; i++) {
            grafo.insertVertex(i);
        }

        // Conectar en secuencia
        for (int i = 0; i < n - 1; i++) {
            grafo.insertEdge(i, i + 1);
            grafo.insertEdge(i + 1, i); // Para grafo no dirigido
        }

        return grafo;
    }

    // Crear un ciclo C_n
    public static GraphLink<Integer> crearCiclo(int n) {
        GraphLink<Integer> grafo = new GraphLink<>();

        // Insertar vértices
        for (int i = 0; i < n; i++) {
            grafo.insertVertex(i);
        }

        // Conectar en secuencia
        for (int i = 0; i < n - 1; i++) {
            grafo.insertEdge(i, i + 1);
            grafo.insertEdge(i + 1, i); // Para grafo no dirigido
        }

        // Cerrar el ciclo
        grafo.insertEdge(n - 1, 0);
        grafo.insertEdge(0, n - 1);

        return grafo;
    }

    // Crear una rueda W_n
    public static GraphLink<Integer> crearRueda(int n) {
        GraphLink<Integer> grafo = new GraphLink<>();

        // Insertar vértices
        for (int i = 0; i < n; i++) {
            grafo.insertVertex(i);
        }

        // El nodo 0 será el centro, conectarlo con todos los demás
        for (int i = 1; i < n; i++) {
            grafo.insertEdge(0, i);
            grafo.insertEdge(i, 0); // Para grafo no dirigido
        }

        // Crear ciclo con los nodos externos (1 a n-1)
        for (int i = 1; i < n - 1; i++) {
            grafo.insertEdge(i, i + 1);
            grafo.insertEdge(i + 1, i); // Para grafo no dirigido
        }

        // Cerrar el ciclo externo
        grafo.insertEdge(n - 1, 1);
        grafo.insertEdge(1, n - 1);

        return grafo;
    }

    // Crear un grafo completo K_n
    public static GraphLink<Integer> crearCompleto(int n) {
        GraphLink<Integer> grafo = new GraphLink<>();

        // Insertar vértices
        for (int i = 0; i < n; i++) {
            grafo.insertVertex(i);
        }

        // Conectar cada vértice con todos los demás
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                grafo.insertEdge(i, j);
                grafo.insertEdge(j, i); // Para grafo no dirigido
            }
        }

        return grafo;
    }

    // EJERCICIO 6
    // REPRESENTACIÓN FORMAL
    public void mostrarRepresentacionFormal() {
        System.out.println("=== REPRESENTACIÓN FORMAL ===");
        System.out.print("V = {");
        ListLinked.Node<Vertex<E>> aux = listVertex.getHead();
        boolean first = true;
        while (aux != null) {
            if (!first)
                System.out.print(", ");
            System.out.print(aux.data.getData());
            first = false;
            aux = aux.next;
        }
        System.out.println("}");

        System.out.print("E = {");
        first = true;
        aux = listVertex.getHead();
        while (aux != null) {
            ListLinked.Node<Edge<E>> edge = aux.data.listAdj.getHead();
            while (edge != null) {
                // Solo mostrar una vez cada arista (evitar duplicados)
                if (aux.data.getData().toString().compareTo(edge.data.getRefDest().getData().toString()) < 0) {
                    if (!first)
                        System.out.print(", ");
                    System.out.print("(" + aux.data.getData() + "," + edge.data.getRefDest().getData() + ")");
                    first = false;
                }
                edge = edge.next;
            }
            aux = aux.next;
        }
        System.out.println("}");
    }
}

