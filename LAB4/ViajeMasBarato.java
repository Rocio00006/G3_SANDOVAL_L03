package LAB4;

public class ViajeMasBarato {

    // Función para encontrar el costo mínimo entre todos los embarcaderos
    public static int[][] calcularCostosMinimos(int[][] T) {
        int n = T.length;   //representa el número de filas
        int[][] C = new int[n][n];  //creación de una matriz cuadrada 

        // Inicializar la matriz C con valores máximos, excepto la diagonal con 0
        for (int i = 0; i < n; i++) {       //i recorre las filas
            for (int j = 0; j < n; j++) {   //j recorre las columnas de cada fila
                if (i == j) {           //cuando i=j, tonces están en la diagonal
                    C[i][j] = 0;        //diagonal se establece en 0
                } else {
                    C[i][j] = T[i][j];  // si hay valor, lo copia; si no, asumimos que T[i][j] = Integer.MAX_VALUE
                }
            }
        }

        // Aplicar programación dinámica
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {   //parte superior de la matriz 
                for (int k = i + 1; k < j; k++) {
                    //if verifica si tanto T[i][k] como C[k][j] son diferentes de Integer.MAX_VALUE
                    if (T[i][k] != Integer.MAX_VALUE && C[k][j] != Integer.MAX_VALUE) {
                        //calcula suma de T[i][k] y C[k][j], y compara con el valor actual C[i][j]
                        C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]); //asigna valor mínimo
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

//impresión de los casos de prueba en gpt
