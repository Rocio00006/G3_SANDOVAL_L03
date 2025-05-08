package LAB4;

public class ViajeMasBarato2 {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // Ejemplo de matriz de tarifas
        int[][] T = {
            {0, 3, INF, 10},
            {INF, 0, 2, 6},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };

        int n = T.length;
        int[][] C = new int[n][n];
        int[][] P = new int[n][n]; // Para guardar puntos intermedios

        calcularCostosMinimos(T, C, P);

        System.out.println("Matriz de costos mínimos:");
        imprimirMatriz(C);

        System.out.println("\nCamino más barato del embarcadero 0 al 3:");
        imprimirCamino(0, 3, P);
        System.out.println();
    }

    public static void calcularCostosMinimos(int[][] T, int[][] C, int[][] P) {
        int n = T.length;

        // Inicializar matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = T[i][j];
                P[i][j] = -1; // -1 indica que no hay punto intermedio
            }
        }

        // Programación dinámica
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    if (T[i][k] != INF && C[k][j] != INF && T[i][k] + C[k][j] < C[i][j]) {
                        C[i][j] = T[i][k] + C[k][j];
                        P[i][j] = k; // Guardar el punto intermedio óptimo
                    }
                }
            }
        }
    }

    // Imprimir matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int val : fila) {
                if (val == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(val + " ");
                }
            }
            System.out.println();
        }
    }

    // Imprimir el camino mínimo desde i a j
    public static void imprimirCamino(int i, int j, int[][] P) {
        if (i == j) {
            System.out.print(i);
        } else if (P[i][j] == -1) {
            System.out.print(i + " -> " + j);
        } else {
            imprimirCamino(i, P[i][j], P);
            System.out.print(" -> ");
            imprimirCamino(P[i][j], j, P);
        }
    }
}
