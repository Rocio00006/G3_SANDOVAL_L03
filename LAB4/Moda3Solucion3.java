package LAB4;

import java.util.*;

import LAB4.Moda3Solucion3;

public class Moda3Solucion3 {

    //creamos TDA que piden, Limits representa los límite de un subarreglo
    static class Limits{
        int[] a;      // Referencia al arreglo
        int prim;     // Índice inicial
        int ult;      // Índice final
        
        //Constructor
        public Limits(int[] a, int prim, int ult) {
            this.a = a;
            this.prim = prim; //primero
            this.ult = ult;     //ultimo
        }
         //Constructor de copia
         public Limits(Limits other) {
            this.a = other.a;
            this.prim = other.prim;
            this.ult = other.ult;
        }
        // Longitud del subarreglo
        public int length() {
            return ult - prim + 1;
        }
    }

    //clase que implementa el conjunto de subarreglos
    static class SetVectors {
        private List<Limits> elements;
        
        public SetVectors() {
            this.elements = new ArrayList<>();
        }
        // Insertar un elemento en el conjunto
        public void Insertar(Limits p) {
            elements.add(new Limits(p));
        }
        // Verificar si el conjunto está vacío
        public boolean Esvacio() {
            return elements.isEmpty();
        }
        // Extraer y devolver el elemento con mayor longitud
        public Limits Mayor() {
            if (elements.isEmpty()) {
                return null;
            }
            // Encontrar el elemento con la longitud máxima
            Limits maxLimits = elements.stream()
                    .max(Comparator.comparingInt(Limits::length))
                    .orElse(null);
            
            // Eliminar el elemento encontrado del conjunto
            if (maxLimits != null) {
                elements.remove(maxLimits);
            }
            return maxLimits;
        }
        // Devolver la longitud máxima de los subarreglos
        public int Long_Mayor() {
            if (elements.isEmpty()) {
                return 0;
            }
            
            return elements.stream()
                    .mapToInt(Limits::length)
                    .max()
                    .orElse(0);
        }
        // Vaciar el conjunto
        public void Destruir() {
            elements.clear();
        }
    }

    //función Pivote2
    public static void Pivote2(int[] a, int mediana, int prim, int ult, int[] indices) {
        int i = prim;
        int j = prim;
        int k = ult;
        
        // Particionar el arreglo
        while (j <= k) {
            if (a[j] < mediana) {
                // Intercambia a[i] con a[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j++;
            } else if (a[j] > mediana) {
                // Intercambia a[j] con a[k]
                int temp = a[j];
                a[j] = a[k];
                a[k] = temp;
                k--;
            } else {
                // a[j] == mediana
                j++;
            }
        }
        
        // Devuelve los índices donde comienzan y terminan los elementos iguales a la mediana
        indices[0] = i;     // izq
        indices[1] = j;     // der
    }

    //función moda3
    public static int Moda3(int[] a, int prim, int ult) {
        SetVectors homogeneo = new SetVectors();
        SetVectors heterogeneo = new SetVectors();
        
        // Crear y añadir el arreglo completo al conjunto heterogéneo
        Limits p = new Limits(a, prim, ult);
        heterogeneo.Insertar(p);
        
        //Mientras el conj heterogéneo tenga elementos con mayor longitud que el homogéneo
        while (heterogeneo.Long_Mayor() > homogeneo.Long_Mayor()) {
            p = heterogeneo.Mayor();
            
            // Calcula la mediana del subarreglo
            int mediana = a[(p.prim + p.ult) / 2];
            
            // Variables para almacenar los índices de partición
            int[] indices = new int[2];
            int izq, der;
            
            // Dividir el arreglo en tres partes
            Pivote2(a, mediana, p.prim, p.ult, indices);
            izq = indices[0];
            der = indices[1];
            
            // Crear los tres subarreglos resultantes
            Limits p1 = new Limits(a, p.prim, izq - 1);  // elementos < mediana
            Limits p2 = new Limits(a, izq, der - 1);     // elementos = mediana
            Limits p3 = new Limits(a, der, p.ult);       // elementos > mediana
            
            // Modificar los conjuntos heterogéneo y homogéneo
            if (p1.prim <= p1.ult) {
                heterogeneo.Insertar(p1);
            }
            if (p3.prim <= p3.ult) {
                heterogeneo.Insertar(p3);
            }
            if (p2.prim <= p2.ult) {
                homogeneo.Insertar(p2);
            }
        }
        // Si el conjunto homogéneo está vacío, devuelve el primer elemento
        if (homogeneo.Esvacio()) {
            return a[prim];
        }
        
        // De lo contrario, devuelve el primer elemento del subarreglo homogéneo más grande
        p = homogeneo.Mayor();
        homogeneo.Destruir();
        heterogeneo.Destruir();
        
        return a[p.prim];
    }

    //método main para probar
    public static void main(String[] args) {
        // Ejemplo de uso
        int[] arr = {1, 2, 3, 4, 2, 2, 5, 2, 6, 7, 8, 2, 9};
        int moda = Moda3(arr, 0, arr.length - 1);
        System.out.println("La moda del arreglo es: " + moda);
        
        // Otro ejemplo
        int[] arr2 = {5, 5, 5, 3, 3, 4, 4, 4, 4, 4, 1, 1};
        moda = Moda3(arr2, 0, arr2.length - 1);
        System.out.println("La moda del arreglo es: " + moda);
    }
}

