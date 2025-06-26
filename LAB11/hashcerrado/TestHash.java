package LAB11.hashcerrado;

public class TestHash {
    public static void main(String[] args) {
        //creamos tabla de tamaño 11
        HashC<String> tabla = new HashC<>(11);

        System.out.println("Insertando claves y valores: ");
        //insertar claves con valores tipo String
        int[] claves = {34, 3, 7, 30, 11, 8, 7, 23, 41, 16, 34};
        for (int clave : claves) {
            tabla.insert(new Register<>(clave, "Valor" + clave));
        }

        //tabla después de la inserción
        System.out.println("\nTabla actual: ");
        tabla.showTable();

        //eliminar una clave
        System.out.println("\nEliminando clave 30...");
        tabla.delete(30);
        System.out.println("\nTabla actual: ");
        tabla.showTable();

        //buscamos una clave
        System.out.println("\n--- Buscando clave 23 ---");
        //creamos un registro para mostrar el resultado
        Register<String> resultado = tabla.search(23);
        if (resultado != null) {
            System.out.println("Encontrado: " + resultado);
        } else {
            System.out.println("Clave no encontrada.");
        }

        //estado finalde la tabla
        tabla.showTable();
    }
}
