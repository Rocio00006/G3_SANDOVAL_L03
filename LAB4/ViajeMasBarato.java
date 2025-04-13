package LAB4;

public class ViajeMasBarato {

    // Función para encontrar el costo mínimo entre todos los embarcaderos
    public static int[][] calcularCostosMinimos(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];

        // Inicializar la matriz C con valores máximos, excepto la diagonal con 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    C[i][j] = 0;
                } else {
                    C[i][j] = T[i][j];  // si hay valor, lo copia; si no, asumimos que T[i][j] = Integer.MAX_VALUE
                }
            }
        }

        // Aplicar programación dinámica
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    if (T[i][k] != Integer.MAX_VALUE && C[k][j] != Integer.MAX_VALUE) {
                        C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]);
                    }
                }
            }
        }

        return C;
    }

    // Función para imprimir la matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(valor + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de matriz de tarifas (triangular superior)
        int INF = Integer.MAX_VALUE;
        int[][] T = {
            {0,   3,   INF, 10},
            {INF, 0,   2,   6},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
        };

        int[][] C = calcularCostosMinimos(T);

        System.out.println("Matriz de costos mínimos:");
        imprimirMatriz(C);
    }
}
