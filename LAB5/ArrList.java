package LAB5;

public class ArrList <E> {
    private int tmñActual;
    private E[] lista;

    public ArrList(int capacidad){
        //forzaremos la creación de un arreglo genérico
        this.lista = (E[]) new Object[capacidad];
        this.tmñActual = 0;
    }
    //método para ver si la lsita está vacia
    public boolean listaVacia(){
        if(tmñActual == 0)
            return true;
        return false;
    }
    //método para ver si la lista está llena
    public boolean listaLlena(){
        if(tmñActual==lista.length)
            return true;
        return false;
    }
    //método para agregar un elemento al final
    public void insertarElemento(E ele){
        if(listaVacia()){
            lista[0] = ele;
            tmñActual++;
            return;
        }
        if(listaLlena())
            System.out.println("LISTA LLENA");
        //o podría ser lista[tmñActual++] = ele;
        for(int i=0; i<lista.length;i++){
            if(lista[i]==null){
                lista[i] = ele;
                tmñActual++;
                break;
            }
        }  
    }
    //método par aeliminar un elemento especi
    public void eliminar(E elemento){
        //primero debe existir en la lista
        if(!buscar(elemento)){
            System.out.println("No existe!!!!");
            return;
        }
        //si el elemento está al final
        if(lista[tmñActual-1].equals(elemento)){
            lista[tmñActual-1]= null;
            tmñActual--;
            return;
        }
        //obtenemos la posicion del elemento
        int posi = indiceDe(elemento);
        lista[posi] = null; //la "eliminamos"
        //luego debemos recorrer al siguiete
        for(int i=posi; i<tmñActual;i++){
            lista[i]=lista[i+1];
        }
    }
    public boolean buscar(E elemento){
        for(E ele : lista){
            if(ele.equals(elemento))
                return true;
        }
        return false;
    }
    //método para contar elementos
    public int contarLista(){
        return tmñActual;
    }
    //metodo para mostrar la lista
    public void mostrarLista(){
        for(int i=0; i<tmñActual; i++){
            if(lista[i]!=null)
                System.out.println(lista[i]);
        }
    }
    //método para invertir una lista
    //al invertir solo se debe recorrer n/2
    public void invertirLista(){
        E[] cLista = lista;
        E temp = null;
        int posiUlt = tmñActual-1;
        for(int i =0; i<tmñActual/2;i++){
            temp = cLista[i]; //guarda el un ele
            cLista[i] = cLista[posiUlt];
            cLista[posiUlt]=temp;
            posiUlt--;
        }
        lista = cLista;
    }
    //método q devuleve posicion de una elemento
    public int indiceDe(E elemento){
        for(int i=0;i<tmñActual;i++){
            if(lista[i].equals(elemento))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Tarea t1 = new Tarea("Algoritmos", 5);
        Tarea t2 = new Tarea("SIA", 1);
        Tarea t3 = new Tarea("redes", 4);

        ArrList<Tarea> listaTa = new ArrList<>(5);
        System.out.println("*** Insertar tareas:");
        listaTa.insertarElemento(t1);
        listaTa.insertarElemento(t2);
        listaTa.insertarElemento(t3);
        listaTa.mostrarLista();

        System.out.println("\n***Eliminamos una tarea: "+t1.getTitulo());
        listaTa.eliminar(t1);
        listaTa.mostrarLista();

        System.out.println("\n***Verificar si una tarea existe:");
        System.out.println("Existe tarea SIA: "+listaTa.buscar(t3));

        System.out.println("\n***Invertimos lista");
        listaTa.invertirLista();
        listaTa.mostrarLista();
    }
}
