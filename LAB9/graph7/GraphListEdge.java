package LAB9.graph7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphListEdge<V, E> {
    ArrayList<VertexObj<V, E>> secVertex;
    ArrayList<EdgeObj<V, E>> secEdge;
    private boolean isDirected; // Nuevo campo para indicar si el grafo es dirigido
    
    public GraphListEdge() {
        this.secVertex = new ArrayList<VertexObj<V, E>>();
        this.secEdge = new ArrayList<EdgeObj<V, E>>();
        this.isDirected = false; // Por defecto no dirigido
    }
    
    public GraphListEdge(boolean isDirected) {
        this.secVertex = new ArrayList<VertexObj<V, E>>();
        this.secEdge = new ArrayList<EdgeObj<V, E>>();
        this.isDirected = isDirected;
    }
    
    // Método para establecer si el grafo es dirigido
    public void setDirected(boolean directed) {
        this.isDirected = directed;
    }
    
    public boolean isDirected() {
        return this.isDirected;
    }
    
    //a
    //método que inserta el vértice 'v' en caso no exista
    public void insertVertex(V data) {
        //verificar si el vértice ya existe
        if (searchVertex(data)) {
            return; // El vértice ya existe
        }
        
        //crear nuevo vértice con posición igual al tamaño actual de la lista
        VertexObj<V, E> newVertex = new VertexObj<>(data, secVertex.size());
        secVertex.add(newVertex);
    }
    
    //b
    //método q inserta la arista entre los vértices 'v' y 'z' en caso aún no haya sido insertada
    public void insertEdge(V data1, V data2) {
        // Buscar los vértices
        VertexObj<V, E> vertex1 = findVertex(data1);
        VertexObj<V, E> vertex2 = findVertex(data2);
        
        // Verificar que ambos vértices existan
        if (vertex1 == null || vertex2 == null) {
            System.out.println("Error: Uno o ambos vértices no existen");
            return;
        }
        
        // Verificar si la arista ya existe
        if (searchEdge(data1, data2)) {
            return; // La arista ya existe
        }
        
        // Crear nueva arista con posición igual al tamaño actual de la lista
        EdgeObj<V, E> newEdge = new EdgeObj<>(vertex1, vertex2, secEdge.size());
        secEdge.add(newEdge);
    }
    
    //c
    //método que busca un vertice y verifica si se ha encontrado
    public boolean searchVertex(V data) {
        return findVertex(data) != null;
    }
    
    // d) searchEdge(v, z): busca la arista entre los vértices 'v' y 'z'
    //métod que busca una arista entre dos vertices 
    public boolean searchEdge(V data1, V data2) {
        VertexObj<V, E> vertex1 = findVertex(data1);
        VertexObj<V, E> vertex2 = findVertex(data2);
        
        if (vertex1 == null || vertex2 == null) {
            return false;
        }
        //buscar la arista en la lista de aristas
        for (EdgeObj<V, E> edge : secEdge) {
            if (isDirected) {
                // En grafo dirigido, verificar dirección específica
                if (edge.getEndVertex1().equals(vertex1) && edge.getEndVertex2().equals(vertex2)) {
                    return true;
                }
            } else {
                // En grafo no dirigido, verificar ambas direcciones
                if (edge.connects(vertex1, vertex2)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // e) bfs(v): realiza el recorrido en anchura desde el vértice 'v'
    //método que hace DFS desde un vértice especídfico
    public void bfs(V inicio) {
        VertexObj<V, E> startVertex = findVertex(inicio);
        if (startVertex == null) {
            System.out.println("Vértice de inicio no encontrado");
            return;
        }
        
        Set<VertexObj<V, E>> visited = new HashSet<>();
        Queue<VertexObj<V, E>> queue = new LinkedList<>();
        queue.offer(startVertex);
        visited.add(startVertex);
        System.out.print("BFS desde " + inicio + ": ");
        while (!queue.isEmpty()) {
            VertexObj<V, E> current = queue.poll();
            System.out.print(current.getInfo() + " ");
            //obtener vertices adyacentes
            ArrayList<VertexObj<V, E>> adjacents = getAdjacentVertices(current);
            for (VertexObj<V, E> adjacent : adjacents) {
                if (!visited.contains(adjacent)) {
                    visited.add(adjacent);
                    queue.offer(adjacent);
                }
            }
        }
        System.out.println();
    }
    
    // ==================== NUEVOS MÉTODOS PARA IDENTIFICACIÓN DE TIPOS DE GRAFO ====================
    
    /**
     * Calcula el grado de entrada de un vértice (para grafos dirigidos)
     */
    public int getInDegree(V data) {
        VertexObj<V, E> vertex = findVertex(data);
        if (vertex == null) {
            return -1;
        }
        
        int inDegree = 0;
        for (EdgeObj<V, E> edge : secEdge) {
            if (edge.getEndVertex2().equals(vertex)) {
                inDegree++;
            }
        }
        return inDegree;
    }
    
    /**
     * Calcula el grado de salida de un vértice (para grafos dirigidos)
     */
    public int getOutDegree(V data) {
        VertexObj<V, E> vertex = findVertex(data);
        if (vertex == null) {
            return -1;
        }
        
        int outDegree = 0;
        for (EdgeObj<V, E> edge : secEdge) {
            if (edge.getEndVertex1().equals(vertex)) {
                outDegree++;
            }
        }
        return outDegree;
    }
    
    /**
     * Obtiene información completa del grado de un nodo
     */
    public String getNodeDegreeInfo(V data) {
        VertexObj<V, E> vertex = findVertex(data);
        if (vertex == null) {
            return "Vértice no encontrado";
        }
        
        if (isDirected) {
            int inDegree = getInDegree(data);
            int outDegree = getOutDegree(data);
            int totalDegree = inDegree + outDegree;
            return String.format("Nodo %s - Grado de entrada: %d, Grado de salida: %d, Grado total: %d", 
                               data, inDegree, outDegree, totalDegree);
        } else {
            int degree = getDegree(data);
            return String.format("Nodo %s - Grado: %d", data, degree);
        }
    }
    
    /**
     * Verifica si el grafo dirigido es de tipo camino
     * Un camino dirigido tiene exactamente un vértice con grado de entrada 0 y grado de salida 1,
     * exactamente un vértice con grado de entrada 1 y grado de salida 0,
     * y todos los demás vértices con grado de entrada 1 y grado de salida 1
     */
    public boolean isDirectedPath() {
        if (!isDirected || secVertex.size() < 2) {
            return false;
        }
        
        int startVertices = 0; // vértices con in-degree 0, out-degree 1
        int endVertices = 0;   // vértices con in-degree 1, out-degree 0
        int middleVertices = 0; // vértices con in-degree 1, out-degree 1
        
        for (VertexObj<V, E> vertex : secVertex) {
            int inDegree = getInDegree(vertex.getInfo());
            int outDegree = getOutDegree(vertex.getInfo());
            
            if (inDegree == 0 && outDegree == 1) {
                startVertices++;
            } else if (inDegree == 1 && outDegree == 0) {
                endVertices++;
            } else if (inDegree == 1 && outDegree == 1) {
                middleVertices++;
            } else {
                return false; // Grado inválido para un camino
            }
        }
        
        return startVertices == 1 && endVertices == 1 && middleVertices == (secVertex.size() - 2);
    }
    
    /**
     * Verifica si el grafo dirigido es de tipo ciclo
     * Un ciclo dirigido tiene todos los vértices con grado de entrada 1 y grado de salida 1
     */
    public boolean isDirectedCycle() {
        if (!isDirected || secVertex.size() < 3) {
            return false;
        }
        
        for (VertexObj<V, E> vertex : secVertex) {
            int inDegree = getInDegree(vertex.getInfo());
            int outDegree = getOutDegree(vertex.getInfo());
            
            if (inDegree != 1 || outDegree != 1) {
                return false;
            }
        }
        
        // Verificar que realmente forme un ciclo (sea fuertemente conexo)
        return isStronglyConnected();
    }
    
    /**
     * Verifica si el grafo dirigido es de tipo rueda
     * Una rueda dirigida tiene un vértice central conectado a todos los demás vértices,
     * y los vértices del borde forman un ciclo dirigido
     */
    public boolean isDirectedWheel() {
        if (!isDirected || secVertex.size() < 4) {
            return false;
        }
        
        // Buscar el vértice central (debe tener grado de salida n-1 y grado de entrada n-1)
        VertexObj<V, E> centerVertex = null;
        int n = secVertex.size();
        
        for (VertexObj<V, E> vertex : secVertex) {
            int inDegree = getInDegree(vertex.getInfo());
            int outDegree = getOutDegree(vertex.getInfo());
            
            if (inDegree == n-1 && outDegree == n-1) {
                if (centerVertex == null) {
                    centerVertex = vertex;
                } else {
                    return false; // Más de un vértice central
                }
            }
        }
        
        if (centerVertex == null) {
            return false; // No hay vértice central
        }
        
        // Verificar que los vértices del borde formen un ciclo
        // Cada vértice del borde debe tener grado de entrada 2 y grado de salida 2
        // (uno del centro y uno del ciclo del borde)
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.equals(centerVertex)) {
                continue;
            }
            
            int inDegree = getInDegree(vertex.getInfo());
            int outDegree = getOutDegree(vertex.getInfo());
            
            if (inDegree != 2 || outDegree != 2) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Verifica si el grafo dirigido es de tipo estrella
     * Una estrella dirigida tiene un vértice central conectado a todos los demás,
     * pero los vértices periféricos no están conectados entre sí
     */
    public boolean isDirectedStar() {
        if (!isDirected || secVertex.size() < 2) {
            return false;
        }
        
        // Buscar el vértice central
        VertexObj<V, E> centerVertex = null;
        int n = secVertex.size();
        
        for (VertexObj<V, E> vertex : secVertex) {
            int totalDegree = getInDegree(vertex.getInfo()) + getOutDegree(vertex.getInfo());
            
            if (totalDegree == n - 1) {
                if (centerVertex == null) {
                    centerVertex = vertex;
                } else {
                    return false; // Más de un vértice central
                }
            }
        }
        
        if (centerVertex == null) {
            return false;
        }
        
        // Verificar que los vértices periféricos solo estén conectados al centro
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.equals(centerVertex)) {
                continue;
            }
            
            int totalDegree = getInDegree(vertex.getInfo()) + getOutDegree(vertex.getInfo());
            if (totalDegree != 1) {
                return false;
            }
        }
        
        return secEdge.size() == n - 1;
    }
    
    /**
     * Verifica si el grafo dirigido es fuertemente conexo
     */
    public boolean isStronglyConnected() {
        if (!isDirected || secVertex.isEmpty()) {
            return true;
        }
        
        // Realizar DFS desde el primer vértice
        Set<VertexObj<V, E>> visited = new HashSet<>();
        dfsDirected(secVertex.get(0), visited, true);
        
        if (visited.size() != secVertex.size()) {
            return false;
        }
        
        // Realizar DFS en el grafo transpuesto
        visited.clear();
        dfsDirected(secVertex.get(0), visited, false);
        
        return visited.size() == secVertex.size();
    }
    
    /**
     * DFS para grafos dirigidos
     */
    private void dfsDirected(VertexObj<V, E> vertex, Set<VertexObj<V, E>> visited, boolean forward) {
        visited.add(vertex);
        
        for (EdgeObj<V, E> edge : secEdge) {
            VertexObj<V, E> neighbor = null;
            
            if (forward) {
                // DFS normal: seguir aristas hacia adelante
                if (edge.getEndVertex1().equals(vertex)) {
                    neighbor = edge.getEndVertex2();
                }
            } else {
                // DFS en grafo transpuesto: seguir aristas hacia atrás
                if (edge.getEndVertex2().equals(vertex)) {
                    neighbor = edge.getEndVertex1();
                }
            }
            
            if (neighbor != null && !visited.contains(neighbor)) {
                dfsDirected(neighbor, visited, forward);
            }
        }
    }
    
    /**
     * Identifica el tipo de grafo dirigido
     */
    public String identifyGraphType() {
        if (!isDirected) {
            return "Este método es solo para grafos dirigidos";
        }
        
        ArrayList<String> types = new ArrayList<>();
        
        if (isDirectedPath()) {
            types.add("Camino dirigido");
        }
        
        if (isDirectedCycle()) {
            types.add("Ciclo dirigido");
        }
        
        if (isDirectedWheel()) {
            types.add("Rueda dirigida");
        }
        
        if (isDirectedStar()) {
            types.add("Estrella dirigida");
        }
        
        if (types.isEmpty()) {
            return "Grafo dirigido general (no es camino, ciclo, rueda o estrella)";
        }
        
        return String.join(", ", types);
    }
    
    /**
     * Muestra información completa del grafo dirigido
     */
    public void analyzeDirectedGraph() {
        if (!isDirected) {
            System.out.println("Este análisis es solo para grafos dirigidos");
            return;
        }
        
        System.out.println("=== ANÁLISIS DE GRAFO DIRIGIDO ===");
        System.out.println("Número de vértices: " + secVertex.size());
        System.out.println("Número de aristas: " + secEdge.size());
        
        System.out.println("\nInformación de grados:");
        for (VertexObj<V, E> vertex : secVertex) {
            System.out.println("  " + getNodeDegreeInfo(vertex.getInfo()));
        }
        
        System.out.println("\nTipo de grafo: " + identifyGraphType());
        System.out.println("¿Es fuertemente conexo? " + isStronglyConnected());
        System.out.println();
    }
    
    // ==================== MÉTODOS ORIGINALES ====================
    
    //método para encontrar un vértice y devolverlo
    private VertexObj<V, E> findVertex(V data) {
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getInfo().equals(data)) {
                return vertex;
            }
        }
        return null;
    }
    
    // Método auxiliar para obtener vértices adyacentes a un vértice dado
    private ArrayList<VertexObj<V, E>> getAdjacentVertices(VertexObj<V, E> vertex) {
        ArrayList<VertexObj<V, E>> adjacents = new ArrayList<>();
        
        for (EdgeObj<V, E> edge : secEdge) {
            if (isDirected) {
                // En grafo dirigido, solo seguir aristas salientes
                if (edge.getEndVertex1().equals(vertex)) {
                    adjacents.add(edge.getEndVertex2());
                }
            } else {
                // En grafo no dirigido, seguir aristas en ambas direcciones
                if (edge.contains(vertex)) {
                    VertexObj<V, E> opposite = edge.getOpposite(vertex);
                    if (opposite != null) {
                        adjacents.add(opposite);
                    }
                }
            }
        }
        
        return adjacents;
    }
    
    // Método para obtener todas las aristas incidentes a un vértice
    public ArrayList<EdgeObj<V, E>> getIncidentEdges(V data) {
        VertexObj<V, E> vertex = findVertex(data);
        ArrayList<EdgeObj<V, E>> incidentEdges = new ArrayList<>();
        
        if (vertex != null) {
            for (EdgeObj<V, E> edge : secEdge) {
                if (edge.contains(vertex)) {
                    incidentEdges.add(edge);
                }
            }
        }
        
        return incidentEdges;
    }
    
    // Método para eliminar un vértice
    public boolean removeVertex(V data) {
        VertexObj<V, E> vertexToRemove = findVertex(data);
        if (vertexToRemove == null) {
            return false;
        }
        
        // Eliminar todas las aristas que contienen este vértice
        secEdge.removeIf(edge -> edge.contains(vertexToRemove));
        
        // Eliminar el vértice
        secVertex.remove(vertexToRemove);
        
        // Actualizar posiciones de los vértices restantes
        for (int i = 0; i < secVertex.size(); i++) {
            secVertex.get(i).setPosition(i);
        }
        
        // Actualizar posiciones de las aristas restantes
        for (int i = 0; i < secEdge.size(); i++) {
            secEdge.get(i).setPosition(i);
        }
        
        return true;
    }
    
    // Método para eliminar una arista
    public boolean removeEdge(V data1, V data2) {
        VertexObj<V, E> vertex1 = findVertex(data1);
        VertexObj<V, E> vertex2 = findVertex(data2);
        
        if (vertex1 == null || vertex2 == null) {
            return false;
        }
        
        // Buscar y eliminar la arista
        for (int i = 0; i < secEdge.size(); i++) {
            EdgeObj<V, E> edge = secEdge.get(i);
            if (isDirected) {
                if (edge.getEndVertex1().equals(vertex1) && edge.getEndVertex2().equals(vertex2)) {
                    secEdge.remove(i);
                    // Actualizar posiciones
                    for (int j = i; j < secEdge.size(); j++) {
                        secEdge.get(j).setPosition(j);
                    }
                    return true;
                }
            } else {
                if (edge.connects(vertex1, vertex2)) {
                    secEdge.remove(i);
                    // Actualizar posiciones
                    for (int j = i; j < secEdge.size(); j++) {
                        secEdge.get(j).setPosition(j);
                    }
                    return true;
                }
            }
        }
        
        return false;
    }
    
    // Método para verificar si el grafo es conexo
    public boolean isConnected() {
        if (secVertex.isEmpty()) {
            return true;
        }
        
        Set<VertexObj<V, E>> visited = new HashSet<>();
        Queue<VertexObj<V, E>> queue = new LinkedList<>();
        
        VertexObj<V, E> startVertex = secVertex.get(0);
        queue.offer(startVertex);
        visited.add(startVertex);
        
        while (!queue.isEmpty()) {
            VertexObj<V, E> current = queue.poll();
            
            ArrayList<VertexObj<V, E>> adjacents = getAdjacentVertices(current);
            for (VertexObj<V, E> adjacent : adjacents) {
                if (!visited.contains(adjacent)) {
                    visited.add(adjacent);
                    queue.offer(adjacent);
                }
            }
        }
        
        return visited.size() == secVertex.size();
    }
    
    // Método para mostrar el grafo
    public void printGraph() {
        String graphType = isDirected ? "DIRIGIDO" : "NO DIRIGIDO";
        System.out.println("=== GRAFO " + graphType + " (Lista de Estructura de Aristas) ===");
        
        System.out.println("Vértices:");
        for (VertexObj<V, E> vertex : secVertex) {
            System.out.println("  Posición " + vertex.getPosition() + ": " + vertex.getInfo());
        }
        
        System.out.println("Aristas:");
        for (EdgeObj<V, E> edge : secEdge) {
            String arrow = isDirected ? " --> " : " -- ";
            System.out.println("  Posición " + edge.getPosition() + ": " + 
                             edge.getEndVertex1().getInfo() + arrow + 
                             edge.getEndVertex2().getInfo());
        }
        
        System.out.println("Total vértices: " + secVertex.size());
        System.out.println("Total aristas: " + secEdge.size());
        
        if (isDirected) {
            System.out.println("¿Es fuertemente conexo? " + isStronglyConnected());
        } else {
            System.out.println("¿Es conexo? " + isConnected());
        }
        System.out.println();
    }
    
    // Método para obtener el grado de un vértice (para grafos no dirigidos)
    public int getDegree(V data) {
        VertexObj<V, E> vertex = findVertex(data);
        if (vertex == null) {
            return -1;
        }
        
        int degree = 0;
        for (EdgeObj<V, E> edge : secEdge) {
            if (edge.contains(vertex)) {
                degree++;
            }
        }
        
        return degree;
    }
    
    // Getters para acceso a las listas (útil para pruebas)
    public ArrayList<VertexObj<V, E>> getVertices() {
        return secVertex;
    }
    
    public ArrayList<EdgeObj<V, E>> getEdges() {
        return secEdge;
    }
    
    // Método para obtener el número de vértices
    public int getVertexCount() {
        return secVertex.size();
    }
    
    // Método para obtener el número de aristas
    public int getEdgeCount() {
        return secEdge.size();
    }
}