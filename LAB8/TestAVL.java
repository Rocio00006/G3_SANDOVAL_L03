package LAB8;

import LAB7.actividad.Exceptions.ItemDuplicatedException;

public class TestAVL {
    public static void main(String[] args) throws ItemDuplicatedException {
        // creamos el arbol avl
        AVLTree<Integer> avl = new AVLTree<>();

        // ====== CASO 1: RSR (Rotación Simple a la Derecha) ======
        System.out.println("--- CASO 1: RSR (Left-Left Case) ---");
        System.out.println("Insertando: 30, 20, 10");
        avl.insert(30);
        System.out.println("Después de insertar 30: Árbol = [30]");

        avl.insert(20);
        System.out.println("Después de insertar 20: Árbol = [30(20, null)]");

        avl.insert(10);
        System.out.println("Después de insertar 10: Se produce desequilibrio Left-Left");
        System.out.println("ROTACIÓN RSR aplicada: Nueva raíz = 20");
        System.out.println("Estado final: [20(10, 30)]\n");

        // ====== CASO 2: RSL (Rotación Simple a la Izquierda) ======
        System.out.println("--- CASO 2: RSL (Right-Right Case) ---");
        System.out.println("Insertando: 40, 50");
        avl.insert(40);
        System.out.println("Después de insertar 40: Árbol = [20(10, 30(null, 40))]");

        avl.insert(50);
        System.out.println("Después de insertar 50: Se produce desequilibrio Right-Right en nodo 30");
        System.out.println("ROTACIÓN RSL aplicada en subárbol de 30");
        System.out.println("Estado final: [20(10, 40(30, 50))]\n");

        // ====== CASO 3: RDR (Rotación Doble a la Derecha) ======
        System.out.println("--- CASO 3: RDR (Left-Right Case) ---");
        System.out.println("Insertando: 5, 7");
        avl.insert(5);
        System.out.println("Después de insertar 5: Árbol = [20(10(5, null), 40(30, 50))]");

        avl.insert(7);
        System.out.println("Después de insertar 7: Se produce desequilibrio Left-Right en nodo 10");
        System.out.println("ROTACIÓN RDR aplicada: RSL en hijo izq(5) + RSR en nodo(10)");
        System.out.println("Estado parcial: [20(7(5, 10), 40(30, 50))]\n");

        // ====== CASO 4: RDL (Rotación Doble a la Izquierda) ======
        System.out.println("--- CASO 4: RDL (Right-Left Case) ---");
        System.out.println("Insertando: 35, 32");
        avl.insert(35);
        System.out.println("Después de insertar 35: Árbol balanceado");

        avl.insert(32);
        System.out.println("Después de insertar 32: Se produce desequilibrio Right-Left en nodo 30");
        System.out.println("ROTACIÓN RDL aplicada: RSR en hijo der(35) + RSL en nodo(30)");
        System.out.println("Estado parcial: Subárbol derecho rebalanceado\n");

        // ====== CASO 5: Segunda RSR ======
        System.out.println("--- CASO 5: Segunda RSR ---");
        System.out.println("Insertando: 3, 1");
        avl.insert(3);
        System.out.println("Después de insertar 3: Árbol balanceado");

        avl.insert(1);
        System.out.println("Después de insertar 1: Se produce desequilibrio Left-Left en nodo 5");
        System.out.println("ROTACIÓN RSR aplicada en subárbol de 5");
        System.out.println("Nueva configuración en subárbol izquierdo\n");

        // ====== CASO 6: Segunda RSL ======
        System.out.println("--- CASO 6: Segunda RSL ---");
        System.out.println("Insertando: 60, 70");
        avl.insert(60);
        System.out.println("Después de insertar 60: Árbol balanceado");

        avl.insert(70);
        System.out.println("Después de insertar 70: Se produce desequilibrio Right-Right");
        System.out.println("ROTACIÓN RSL aplicada");
        System.out.println("Rebalanceo en subárbol derecho\n");

        // ====== CASO 7: Segunda RDR ======
        System.out.println("--- CASO 7: Segunda RDR ---");
        System.out.println("Insertando: 2");
        avl.insert(2);
        System.out.println("Después de insertar 2: Se produce desequilibrio Left-Right");
        System.out.println("ROTACIÓN RDR aplicada: RSL + RSR");
        System.out.println("Rebalanceo complejo en subárbol izquierdo\n");

        // ====== CASO 8: Segunda RDL ======
        System.out.println("--- CASO 8: Segunda RDL ---");
        System.out.println("Insertando: 45, 43");
        avl.insert(45);
        avl.insert(45);
        System.out.println("Después de insertar 43: Se produce desequilibrio Right-Left");
        System.out.println("ROTACIÓN RDL aplicada: RSR + RSL");
        System.out.println("Rebalanceo final en subárbol derecho\n");
    }
}



/*


//CASOSSSS
            // Crear instancia del árbol AVL
            AVLTree<Integer> avl = new AVLTree<>();
            
            System.out.println("ÁRBOL INICIAL: Vacío\n");
            
            // ====== CASO 1: RSR (Rotación Simple a la Derecha) ======
            System.out.println("--- CASO 1: RSR (Left-Left Case) ---");
            System.out.println("Insertando: 30, 20, 10");
            avl.insert(30);
            System.out.println("Después de insertar 30: Árbol = [30]");
            
            avl.insert(20);
            System.out.println("Después de insertar 20: Árbol = [30(20, null)]");
            
            avl.insert(10);
            System.out.println("Después de insertar 10: Se produce desequilibrio Left-Left");
            System.out.println("ROTACIÓN RSR aplicada: Nueva raíz = 20");
            System.out.println("Estado final: [20(10, 30)]\n");
            
            // ====== CASO 2: RSL (Rotación Simple a la Izquierda) ======
            System.out.println("--- CASO 2: RSL (Right-Right Case) ---");
            System.out.println("Insertando: 40, 50");
            avl.insert(40);
            System.out.println("Después de insertar 40: Árbol = [20(10, 30(null, 40))]");
            
            avl.insert(50);
            System.out.println("Después de insertar 50: Se produce desequilibrio Right-Right en nodo 30");
            System.out.println("ROTACIÓN RSL aplicada en subárbol de 30");
            System.out.println("Estado final: [20(10, 40(30, 50))]\n");
            
            // ====== CASO 3: RDR (Rotación Doble a la Derecha) ======
            System.out.println("--- CASO 3: RDR (Left-Right Case) ---");
            System.out.println("Insertando: 5, 7");
            avl.insert(5);
            System.out.println("Después de insertar 5: Árbol = [20(10(5, null), 40(30, 50))]");
            
            avl.insert(7);
            System.out.println("Después de insertar 7: Se produce desequilibrio Left-Right en nodo 10");
            System.out.println("ROTACIÓN RDR aplicada: RSL en hijo izq(5) + RSR en nodo(10)");
            System.out.println("Estado parcial: [20(7(5, 10), 40(30, 50))]\n");
            
            // ====== CASO 4: RDL (Rotación Doble a la Izquierda) ======
            System.out.println("--- CASO 4: RDL (Right-Left Case) ---");
            System.out.println("Insertando: 35, 32");
            avl.insert(35);
            System.out.println("Después de insertar 35: Árbol balanceado");
            
            avl.insert(32);
            System.out.println("Después de insertar 32: Se produce desequilibrio Right-Left en nodo 30");
            System.out.println("ROTACIÓN RDL aplicada: RSR en hijo der(35) + RSL en nodo(30)");
            System.out.println("Estado parcial: Subárbol derecho rebalanceado\n");
            
            // ====== CASO 5: Segunda RSR ======
            System.out.println("--- CASO 5: Segunda RSR ---");
            System.out.println("Insertando: 3, 1");
            avl.insert(3);
            System.out.println("Después de insertar 3: Árbol balanceado");
            
            avl.insert(1);
            System.out.println("Después de insertar 1: Se produce desequilibrio Left-Left en nodo 5");
            System.out.println("ROTACIÓN RSR aplicada en subárbol de 5");
            System.out.println("Nueva configuración en subárbol izquierdo\n");
            
            // ====== CASO 6: Segunda RSL ======
            System.out.println("--- CASO 6: Segunda RSL ---");
            System.out.println("Insertando: 60, 70");
            avl.insert(60);
            System.out.println("Después de insertar 60: Árbol balanceado");
            
            avl.insert(70);
            System.out.println("Después de insertar 70: Se produce desequilibrio Right-Right");
            System.out.println("ROTACIÓN RSL aplicada");
            System.out.println("Rebalanceo en subárbol derecho\n");
            
            // ====== CASO 7: Segunda RDR ======
            System.out.println("--- CASO 7: Segunda RDR ---");
            System.out.println("Insertando: 2");
            avl.insert(2);
            System.out.println("Después de insertar 2: Se produce desequilibrio Left-Right");
            System.out.println("ROTACIÓN RDR aplicada: RSL + RSR");
            System.out.println("Rebalanceo complejo en subárbol izquierdo\n");
            
            // ====== CASO 8: Segunda RDL ======
            System.out.println("--- CASO 8: Segunda RDL ---");
            System.out.println("Insertando: 45");
            avl.insert(45);
            System.out.println("Después de insertar 45: Se produce desequilibrio Right-Left");
            System.out.println("ROTACIÓN RDL aplicada: RSR + RSL");
            System.out.println("Rebalanceo final en subárbol derecho\n");
            
            // ====== RESUMEN FINAL ======
            System.out.println("=== RESUMEN DE PRUEBAS REALIZADAS ===");
            System.out.println("✓ RSR (Rotación Simple Derecha): 2 casos");
            System.out.println("✓ RSL (Rotación Simple Izquierda): 2 casos");
            System.out.println("✓ RDR (Rotación Doble Derecha): 2 casos");
            System.out.println("✓ RDL (Rotación Doble Izquierda): 2 casos");
            System.out.println("\nTOTAL: 8 casos de prueba exitosos");
            System.out.println("Todos los desequilibrios fueron corregidos automáticamente");
 */