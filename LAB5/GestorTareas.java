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
    public void obtenerMayorPrioridad(){
        int[] arrPrioridades = new int[listaTareas.length()];
        LinkedList<T> listaaux = listaTareas;
        int prioMax = 0;

        for(int i=0; i<listaaux.length(); i++){
            Node<T> aux = listaaux.getFirstNode();
            Tarea t = (Tarea) aux.getValor();
            //Tarea tar = (Tarea) listaaux.getFirst();
            prioMax = t.getPrioridad();   //suponer que es de la 1er tarea
            aux = aux.getNext();    //pasa al siguiente nodo
            if(prioMax<= t.getPrioridad()){
                prioMax = t.getPrioridad();
            }
        }
        System.out.println("Prioridad Máxima"+prioMax);

        /*while(listaaux != null){
            Tarea tar = (Tarea) listaaux.getFirst();
            int prioMax = tar.getPrioridad();   //suponer que es de la 1er tarea
            if(prioMax>= t)
            arrPrioridades[listaTareas.length()-listaTareas.length()-1]
            listaaux = listaaux.
        }*/
    }
    public void invertirTareas(){
        listaTareas.invertir();
    }

    public static void main(String[] args) {
        Tarea t1 = new Tarea("Algoritmos", 5);
        Tarea t2 = new Tarea("SIA", 3);
        Tarea t3 = new Tarea("redes", 4);

        GestorTareas<Tarea> gestor = new GestorTareas<>();
        gestor.agregarTarea(t3);
        gestor.agregarTarea(t2);
        gestor.agregarTarea(t1);

        gestor.imprimirTareas();
        System.out.println(gestor.contineneTarea(t1));

        gestor.eliminarTarea(t3);
        gestor.imprimirTareas();
        System.out.println(gestor.contarTarea());

        gestor.invertirTareas();
        gestor.imprimirTareas();
        gestor.obtenerMayorPrioridad();
    }
}
