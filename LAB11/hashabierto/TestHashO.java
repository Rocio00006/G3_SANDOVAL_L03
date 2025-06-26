package LAB11.hashabierto;

public class TestHashO {
    public static void main(String[] args) {
        //creamos tabla de tamaño 5
        HashO<String> tabla = new HashO<>(5);

        //Insertamos elementos
        tabla.insert(new Register<>(10, "Juan"));
        tabla.insert(new Register<>(15, "Ana"));
        tabla.insert(new Register<>(13, "Luis"));
        tabla.insert(new Register<>(25, "Rosa"));
        tabla.insert(new Register<>(30, "Carlos")); //Colisión con 10

        //mostrar la tabla después de inserciones
        System.out.println("\nTabla después de insertar");
        tabla.showTable();

        // Buscar la clave 20
        System.out.println("\nBuscando clave 20 ");
        Register<String> r = tabla.search(20);
        //si r es diferente de null, se ha encontrado
        System.out.println(r != null ? "Encontrado: " + r : "No encontrado");

        //buscar clave que no existe
        System.out.println("\nBuscando clave 100 ");
        r = tabla.search(100);
        System.out.println(r != null ? "Encontrado: " + r : "No encontrado");

        // Eliminar la clave 15
        System.out.println("\nEliminando clave 15..");
        tabla.delete(15);
        tabla.showTable();
    }
}
