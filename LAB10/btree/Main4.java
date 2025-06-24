package LAB10.btree;

public class Main4 {
    public static void main(String[] args) {
        //Crear árbol B de orden 4 para RegistroEstudiante
        BTree<RegistroEstudiante> arbol = new BTree<>(4);

        //Insertar estudiantes
        RegistroEstudiante[] estudiantes = {
            new RegistroEstudiante(103, "Ana"),
            new RegistroEstudiante(110, "Luis"),
            new RegistroEstudiante(101, "Carlos"),
            new RegistroEstudiante(120, "Lucía"),
            new RegistroEstudiante(115, "David"),
            new RegistroEstudiante(125, "Jorge"),
            new RegistroEstudiante(140, "Camila"),
            new RegistroEstudiante(108, "Rosa"),
            new RegistroEstudiante(132, "Ernesto"),
            new RegistroEstudiante(128, "Denis"),
            new RegistroEstudiante(145, "Enrique"),
            new RegistroEstudiante(122, "Karina"),
            new RegistroEstudiante(108, "Juan") // Duplicado
        };

        System.out.println("Insertando estudiantes...");
        for (RegistroEstudiante est : estudiantes) {
            arbol.insert(est);
        }

        System.out.println("\nÁrbol B actual:");
        System.out.println(arbol);

        //Búsquedas
        System.out.println("\nBuscar estudiante con código 115:");
        System.out.println(arbol.buscarNombre(115)); // David

        System.out.println("\nBuscar estudiante con código 132:");
        System.out.println(arbol.buscarNombre(132)); // Ernesto

        System.out.println("\nBuscar estudiante con código 999:");
        System.out.println(arbol.buscarNombre(999)); // No encontrado

        //Eliminar
        System.out.println("\nEliminar estudiante con código 101:");
        arbol.remove(new RegistroEstudiante(101, ""));
        System.out.println(arbol);

        //Insertar nuevo
        System.out.println("\nInsertar nuevo estudiante: (106, 'Sara')");
        arbol.insert(new RegistroEstudiante(106, "Sara"));

        // Buscar nuevo insertado
        System.out.println("\nBuscar estudiante con código 106:");
        System.out.println(arbol.buscarNombre(106));

        System.out.println("\nÁrbol B final:");
        System.out.println(arbol);
    }
}
