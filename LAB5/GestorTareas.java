package LAB5;

public class GestorTareas<T>{
    private LinkedList<T> listaTareas;

    public GestorTareas(){
        this.listaTareas = new LinkedList<>();
    }

    public void agregarTarea(T tarea){
        if(listaTareas.isEmpty()){
            listaTareas.insertFirst(tarea);
        } else {
            listaTareas.insertFinal(tarea);
        }
    }
    public boolean contineneTarea(T tarea){
        if(listaTareas.search(tarea)){
            return true;
        }
        return false;
    }
    public boolean eliminarTarea(T tarea){
        if(contineneTarea(tarea)){
            listaTareas.removeNode(tarea);
            return true;
        }
        return false;
    }
    public void imprimirTareas(){
        listaTareas.print();
    }
    public int contarTarea(){
        return listaTareas.length();
    }
    public int obtenerMayorPrioridad(){
        LinkedList<T> listaaux = listaTareas;
        int prioMax = 0;
        
        Node<T> aux = listaaux.getFirstNode();  //primer nodo
        while(aux!=null){
            Tarea t = (Tarea) aux.getValor();   //tomar solo el valor
            if(t.getPrioridad()>prioMax){
                prioMax= t.getPrioridad();
            }
            aux = aux.getNext();
            
        }
        return prioMax;
    }
    public void invertirTareas(){
        listaTareas.invertir();
    }
    
    public static void main(String[] args) {
        GestorTareas<Tarea> gestor = new GestorTareas<>();

        Tarea t1 = new Tarea("Algoritmos", 1);
        Tarea t2 = new Tarea("SIA", 10);
        Tarea t3 = new Tarea("REDES", 4);

        System.out.println("=== Agregando tareas ===");
        gestor.agregarTarea(t3);
        gestor.agregarTarea(t2);
        gestor.agregarTarea(t1);
        gestor.imprimirTareas();

        System.out.println("\n=== Mostrando lista de tareas ===");
        gestor.imprimirTareas();

        System.out.println("\n=== Verificando si existe una tarea ===");
        System.out.println("¿Contiene tarea SIA: " + gestor.contineneTarea(t2));

        System.out.println("\n=== Eliminando tarea REDES ===");
        boolean eliminada = gestor.eliminarTarea(t3);
        System.out.println("¿Se eliminó la tarea?: " + eliminada);
        gestor.imprimirTareas();

        System.out.println("\n=== Total de tareas ===");
        System.out.println("Total: " + gestor.contarTarea());

        System.out.println("\n=== Tarea más prioritaria ===");
        System.out.println("Más prioritaria: " + gestor.obtenerMayorPrioridad());

        System.out.println("\n=== Mostrando lista de tareas ===");
        gestor.imprimirTareas();
        System.out.println("\n=== Invirtiendo la lista de tareas ===");
        gestor.invertirTareas();
        gestor.imprimirTareas();
    }
    
/*
    public static void main(String[] args) {
        Tarea t1 = new Tarea("Algoritmos", 1);
        Tarea t2 = new Tarea("SIA", 10);
        Tarea t3 = new Tarea("redes", 4);

        GestorTareas<Tarea> gestor = new GestorTareas<>();
        gestor.agregarTarea(t3);
        gestor.agregarTarea(t2);
        gestor.agregarTarea(t1);

        gestor.imprimirTareas();
        System.out.println("Buscar Tarea 1");
        System.out.println(gestor.contineneTarea(t1));

        System.out.println("Eliminar tarea 2");
        gestor.eliminarTarea(t3);
        gestor.imprimirTareas();
        System.out.println(gestor.contarTarea());

        gestor.invertirTareas();
        gestor.imprimirTareas();
        gestor.obtenerMayorPrioridad();
    }*/
}
