package LAB4;

import java.util.*;

public class Moda3 {

    static class VectorRange {
        int[] a;
        int prim, ult;

        public VectorRange(int[] a, int prim, int ult) {
            this.a = a;
            this.prim = prim;
            this.ult = ult;
        }

        int length() {
            return ult - prim + 1;
        }
    }

    static class SetVectors {
        PriorityQueue<VectorRange> vectores;

        public SetVectors() {
            vectores = new PriorityQueue<>((v1, v2) -> Integer.compare(v2.length(), v1.length()));
        }

        void insertar(VectorRange vr) {
            vectores.add(vr);
        }

        VectorRange mayor() {
            return vectores.poll();
        }

        int longitudMayor() {
            if (vectores.isEmpty()) return 0;
            return vectores.peek().length();
        }

        boolean esVacio() {
            return vectores.isEmpty();
        }
    }

    // Función que separa el arreglo en 3 partes con respecto al pivote
    static void pivote2(int[] a, int mediana, int prim, int ult, int[] izqDer) {
        int[] temp = new int[ult - prim + 1];
        int izq = 0, mid = 0, der = temp.length;

        for (int i = prim; i <= ult; i++) {
            if (a[i] < mediana) {
                temp[izq++] = a[i];
            } else if (a[i] > mediana) {
                temp[--der] = a[i];
            } else {
                mid++;
            }
        }

        for (int i = 0; i < mid; i++) {
            temp[izq + i] = mediana;
        }

        // Copiamos de nuevo al arreglo original
        for (int i = 0; i < temp.length; i++) {
            a[prim + i] = temp[i];
        }

        izqDer[0] = prim + izq;
        izqDer[1] = prim + izq + mid;
    }

    public static int moda3(int[] a, int prim, int ult) {
        SetVectors heterogeneo = new SetVectors();
        SetVectors homogeneo = new SetVectors();

        VectorRange p = new VectorRange(a, prim, ult);
        heterogeneo.insertar(p);

        while (heterogeneo.longitudMayor() > homogeneo.longitudMayor()) {
            p = heterogeneo.mayor();
            int mediana = a[(p.prim + p.ult) / 2];

            int[] izqDer = new int[2];
            pivote2(a, mediana, p.prim, p.ult, izqDer);

            VectorRange p1 = new VectorRange(a, p.prim, izqDer[0] - 1);
            VectorRange p2 = new VectorRange(a, izqDer[0], izqDer[1] - 1);
            VectorRange p3 = new VectorRange(a, izqDer[1], p.ult);

            if (p1.prim <= p1.ult) heterogeneo.insertar(p1);
            if (p3.prim <= p3.ult) heterogeneo.insertar(p3);
            if (p2.prim <= p2.ult) homogeneo.insertar(p2);
        }

        if (homogeneo.esVacio()) {
            return a[prim];
        }

        VectorRange modaRango = homogeneo.mayor();
        return a[modaRango.prim]; // Todos son iguales en ese rango
    }

    public static void main(String[] args) {
        int[] arreglo = {4, 2, 3, 2, 5, 2, 3, 3, 3, 3, 4, 4, 4, 4};
        int moda = moda3(arreglo, 0, arreglo.length - 1);
        System.out.println("La moda del arreglo es: " + moda);
    }
}

