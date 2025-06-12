package LAB9.graph5;

import java.util.*;

public class Grafo {
    private int numVertices;
    private List<List<Integer>> listaAdyacencia;
    
    // Constructor
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.listaAdyacencia = new ArrayList<>();
        
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }
    
    // Método para agregar una arista
    public void agregarArista(int origen, int destino) {
        listaAdyacencia.get(origen).add(destino);
        listaAdyacencia.get(destino).add(origen); // Para grafo no dirigido
    }
    
    // a) Grado de un nodo (Gx)
    public int gradoNodo(int nodo) {
        if (nodo < 0 || nodo >= numVertices) {
            throw new IllegalArgumentException("Nodo fuera de rango");
        }
        return listaAdyacencia.get(nodo).size();
    }
    
    // Método auxiliar para verificar si el grafo está conectado
    private boolean esConexo() {
        boolean[] visitado = new boolean[numVertices];
        Queue<Integer> cola = new LinkedList<>();
        
        // Comenzar DFS desde el primer nodo
        cola.offer(0);
        visitado[0] = true;
        int nodoVisitados = 1;
        
        while (!cola.isEmpty()) {
            int nodoActual = cola.poll();
            
            for (int vecino : listaAdyacencia.get(nodoActual)) {
                if (!visitado[vecino]) {
                    visitado[vecino] = true;
                    cola.offer(vecino);
                    nodoVisitados++;
                }
            }
        }
        
        return nodoVisitados == numVertices;
    }
    
    // b) Camino (Px): grafo conexo sin ciclos
    public boolean esCamino() {
        if (!esConexo()) {
            return false;
        }
        
        // Para ser un camino, debe tener exactamente 2 nodos de grado 1 
        // y el resto de grado 2
        int nodosGrado1 = 0;
        int nodosGrado2 = 0;
        
        for (int i = 0; i < numVertices; i++) {
            int grado = gradoNodo(i);
            if (grado == 1) {
                nodosGrado1++;
            } else if (grado == 2) {
                nodosGrado2++;
            } else {
                return false; // Si hay nodos con grado diferente a 1 o 2
            }
        }
        
        return nodosGrado1 == 2 && nodosGrado2 == (numVertices - 2);
    }
    
    // c) Ciclo (Cx): grafo conexo donde todos los nodos tienen grado 2
    public boolean esCiclo() {
        if (!esConexo()) {
            return false;
        }
        
        // Para ser un ciclo, todos los nodos deben tener grado 2
        for (int i = 0; i < numVertices; i++) {
            if (gradoNodo(i) != 2) {
                return false;
            }
        }
        
        return true;
    }
    
    // d) Rueda (Wx): un nodo central conectado a todos los demás que forman un ciclo
    public boolean esRueda() {
        if (numVertices < 4) {
            return false; // Una rueda necesita al menos 4 nodos
        }
        
        if (!esConexo()) {
            return false;
        }
        
        // Buscar el nodo central (debe tener grado n-1)
        int nodoCentral = -1;
        for (int i = 0; i < numVertices; i++) {
            if (gradoNodo(i) == numVertices - 1) {
                if (nodoCentral == -1) {
                    nodoCentral = i;
                } else {
                    return false; // Más de un nodo con grado n-1
                }
            }
        }
        
        if (nodoCentral == -1) {
            return false; // No hay nodo central
        }
        
        // Los demás nodos deben tener grado 3 (conectados al centro y a 2 vecinos en el ciclo)
        for (int i = 0; i < numVertices; i++) {
            if (i != nodoCentral && gradoNodo(i) != 3) {
                return false;
            }
        }
        
        // Verificar que los nodos no centrales formen un ciclo
        // (excluyendo las conexiones con el nodo central)
        List<Integer> nodosExternos = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (i != nodoCentral) {
                nodosExternos.add(i);
            }
        }
        
        // Verificar que cada nodo externo esté conectado exactamente a 2 otros nodos externos
        for (int nodo : nodosExternos) {
            int conexionesExternas = 0;
            for (int vecino : listaAdyacencia.get(nodo)) {
                if (vecino != nodoCentral) {
                    conexionesExternas++;
                }
            }
            if (conexionesExternas != 2) {
                return false;
            }
        }
        
        return true;
    }
    
    // e) Completo (Kx): todos los nodos están conectados entre sí
    public boolean esCompleto() {
        // En un grafo completo, cada nodo debe estar conectado a todos los demás
        // Por lo tanto, cada nodo debe tener grado (n-1)
        for (int i = 0; i < numVertices; i++) {
            if (gradoNodo(i) != numVertices - 1) {
                return false;
            }
        }
        
        // Verificar que efectivamente cada nodo esté conectado a todos los demás
        for (int i = 0; i < numVertices; i++) {
            Set<Integer> vecinos = new HashSet<>(listaAdyacencia.get(i));
            for (int j = 0; j < numVertices; j++) {
                if (i != j && !vecinos.contains(j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    // Método auxiliar para imprimir el grafo
    public void imprimirGrafo() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Nodo " + i + ": ");
            for (int vecino : listaAdyacencia.get(i)) {
                System.out.print(vecino + " ");
            }
            System.out.println();
        }
    }
    
    // Métodos para crear grafos específicos (útiles para testing)
    
    // Crear un camino P_n
    public static Grafo crearCamino(int n) {
        Grafo grafo = new Grafo(n);
        for (int i = 0; i < n - 1; i++) {
            grafo.agregarArista(i, i + 1);
        }
        return grafo;
    }
    
    // Crear un ciclo C_n
    public static Grafo crearCiclo(int n) {
        Grafo grafo = new Grafo(n);
        for (int i = 0; i < n - 1; i++) {
            grafo.agregarArista(i, i + 1);
        }
        grafo.agregarArista(n - 1, 0); // Cerrar el ciclo
        return grafo;
    }
    
    // Crear una rueda W_n
    public static Grafo crearRueda(int n) {
        Grafo grafo = new Grafo(n);
        // El nodo 0 será el centro
        for (int i = 1; i < n; i++) {
            grafo.agregarArista(0, i); // Conectar centro con todos
        }
        // Crear ciclo con los nodos externos
        for (int i = 1; i < n - 1; i++) {
            grafo.agregarArista(i, i + 1);
        }
        grafo.agregarArista(n - 1, 1); // Cerrar el ciclo externo
        return grafo;
    }
    
    // Crear un grafo completo K_n
    public static Grafo crearCompleto(int n) {
        Grafo grafo = new Grafo(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                grafo.agregarArista(i, j);
            }
        }
        return grafo;
    }
        // Método main para testing
    public static void main(String[] args) {
        System.out.println("=== TESTING MÉTODOS DE GRAFO ===\n");
        
        // Test Camino P4
        System.out.println("--- Test Camino P4 ---");
        Grafo p4 = crearCamino(4);
        p4.imprimirGrafo();
        System.out.println("Es camino: " + p4.esCamino());
        System.out.println("Grado del nodo 0: " + p4.gradoNodo(0));
        System.out.println("Grado del nodo 1: " + p4.gradoNodo(1));
        System.out.println();
        
        // Test Ciclo C5
        System.out.println("--- Test Ciclo C5 ---");
        Grafo c5 = crearCiclo(5);
        c5.imprimirGrafo();
        System.out.println("Es ciclo: " + c5.esCiclo());
        System.out.println("Grado del nodo 0: " + c5.gradoNodo(0));
        System.out.println();
        
        // Test Rueda W5
        System.out.println("--- Test Rueda W5 ---");
        Grafo w5 = crearRueda(5);
        w5.imprimirGrafo();
        System.out.println("Es rueda: " + w5.esRueda());
        System.out.println("Grado del nodo central (0): " + w5.gradoNodo(0));
        System.out.println("Grado del nodo externo (1): " + w5.gradoNodo(1));
        System.out.println();
        
        // Test Completo K4
        System.out.println("--- Test Completo K4 ---");
        Grafo k4 = crearCompleto(4);
        k4.imprimirGrafo();
        System.out.println("Es completo: " + k4.esCompleto());
        System.out.println("Grado del nodo 0: " + k4.gradoNodo(0));
        System.out.println();
        
        // Test casos negativos
        System.out.println("--- Test Casos Negativos ---");
        System.out.println("P4 es ciclo: " + p4.esCiclo());
        System.out.println("C5 es camino: " + c5.esCamino());
        System.out.println("W5 es completo: " + w5.esCompleto());
        System.out.println("K4 es rueda: " + k4.esRueda());
    }
}