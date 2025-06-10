package LAB9.EJER;

import java.util.*;

public class GraphLink {
    private Map<Integer, List<Integer>> adjacencyList;

    public GraphLink() {
        adjacencyList = new HashMap<>();
    }

    // Agrega un vértice si no existe
    public void addVertex(int v) {
        adjacencyList.putIfAbsent(v, new LinkedList<>());
    }

    //Agrega una arista no dirigida entre v1 y v2
    public void addEdge(int v1, int v2) {
        addVertex(v1);
        addVertex(v2);
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }

    //Retorna los vecinos de un nodo
    public List<Integer> getNeighbors(int v) {
        return adjacencyList.getOrDefault(v, new LinkedList<>());
    }

    //Retorna el conjunto de todos los vértices
    public Set<Integer> getVertices() {
        return adjacencyList.keySet();
    }

    // Retorna el grado de un nodo (cantidad de conexiones)
    public int getDegree(int v) {
        return getNeighbors(v).size();
    }

    // Retorna el número de vértices
    public int size() {
        return adjacencyList.size();
    }

    // Retorna el número total de aristas
    public int edgeCount() {
        int count = 0;
        for (int v : getVertices()) {
            count += getDegree(v);
        }
        return count / 2; // Cada arista se cuenta dos veces
    }

    // ---------------------------
    // Métodos de análisis del grafo
    // ---------------------------

    // a) Grado del nodo (Gx)
    public int gradoDelNodo(int nodo) {
        return getDegree(nodo);
    }

    // b) Verifica si es camino Px
    public boolean esCamino() {
        int extremos = 0;

        for (int v : getVertices()) {
            int grado = getDegree(v);
            if (grado == 1) {
                extremos++;
            } else if (grado != 2) {
                return false;
            }
        }

        return extremos == 2;
    }

    // c) Verifica si es ciclo Cx
    public boolean esCiclo() {
        if (size() < 3) return false;

        for (int v : getVertices()) {
            if (getDegree(v) != 2) {
                return false;
            }
        }

        return true;
    }

    // d) Verifica si es rueda Wx
    public boolean esRueda() {
        int n = size();
        if (n < 4) return false;

        int centros = 0;
        int periferia = 0;

        for (int v : getVertices()) {
            int grado = getDegree(v);
            if (grado == n - 1) {
                centros++;
            } else if (grado == 3 || grado == 2) {
                periferia++;
            } else {
                return false;
            }
        }

        return centros == 1 && periferia == n - 1;
    }

    // e) Verifica si es completo Kx
    public boolean esCompleto() {
        int n = size();
        for (int v : getVertices()) {
            if (getDegree(v) != n - 1) {
                return false;
            }
        }
        return true;
    }
}
