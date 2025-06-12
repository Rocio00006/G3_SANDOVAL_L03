package LAB9.graph5;

import java.util.*;

public class Graph {
    private Map<Integer, GraphLink> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addVertex(int v) {
        vertices.putIfAbsent(v, null);
    }

    public void addEdge(int v1, int v2) {
        vertices.put(v1, new GraphLink(v2, vertices.get(v1)));
        vertices.put(v2, new GraphLink(v1, vertices.get(v2))); // No dirigido
    }

    public int getDegree(int v) {
        int degree = 0;
        GraphLink current = vertices.get(v);
        while (current != null) {
            degree++;
            current = current.getNext();
        }
        return degree;
    }

    public Map<Integer, Integer> getAllDegrees() {
        Map<Integer, Integer> degrees = new HashMap<>();
        for (Integer v : vertices.keySet()) {
            degrees.put(v, getDegree(v));
        }
        return degrees;
    }

    public boolean isPath() {
        int ones = 0, twos = 0;
        for (int degree : getAllDegrees().values()) {
            if (degree == 1) ones++;
            else if (degree == 2) twos++;
            else return false;
        }
        return ones == 2 && twos == vertices.size() - 2;
    }

    public boolean isCycle() {
        for (int degree : getAllDegrees().values()) {
            if (degree != 2) return false;
        }
        return true;
    }

    public boolean isComplete() {
        int n = vertices.size();
        for (int degree : getAllDegrees().values()) {
            if (degree != n - 1) return false;
        }
        return true;
    }

    public boolean isWheel() {
        int n = vertices.size();
        int centerCount = 0;
        int cycleCount = 0;

        for (int degree : getAllDegrees().values()) {
            if (degree == n - 1) centerCount++;
            else if (degree == 3) cycleCount++;
            else if (degree == 2) cycleCount++;
            else return false;
        }

        return centerCount == 1 && cycleCount == n - 1;
    }

    public void printDegrees() {
        for (Map.Entry<Integer, Integer> entry : getAllDegrees().entrySet()) {
            System.out.println("Nodo " + entry.getKey() + ": G" + entry.getValue());
        }
    }

    public void identifyGraphType() {
        printDegrees();
        if (isComplete()) System.out.println("Es un grafo completo: K" + vertices.size());
        else if (isCycle()) System.out.println("Es un ciclo: C" + vertices.size());
        else if (isWheel()) System.out.println("Es una rueda: W" + vertices.size());
        else if (isPath()) System.out.println("Es un camino: P" + vertices.size());
        else System.out.println("No es un tipo especial reconocido.");
    }
}
