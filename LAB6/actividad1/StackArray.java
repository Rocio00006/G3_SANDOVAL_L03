package LAB6.actividad1;

//pilas LIFO last in last out
public class StackArray<E extends Object> {
    private E[] array;  //arreglo en sí
    private int tope;   //posicion el último elemento

    public StackArray(int n){ 
        this.array = (E[]) new Object[n]; 
        tope = -1;  //arreglo vacio
    } 
    //agrega un elemento al tope de la pila
    public void push(E ele){
        //primero verificar si está lleno
        if(isFull()){
            System.out.println("Stack está re lleno");
            return;
        }
        array[tope+1] = ele;
        tope++;
    }
    //elimina y devuelve el el elemento en el tope
    public E pop(){
        //si está vacio
        if(isEmpty()){
            System.out.println("Stack está vacío");
            return null;
        }
        E t = array[tope];
        array[tope] = null;
        tope--;
        return t;
    }
    //solo devuleve el elemento en el tope del stack
    public E top(){
        return array[tope];
    }
    public boolean isEmpty(){
        if(tope==-1){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(tope==array.length-1){
            return true;
        }
        return false;
    }
    public void printStack(){
        for(int i = 0; i<array.length; i++){
            if(array[i]!=null)
                System.out.println(array[i]);
        }
    }
    @Override
    public String toString(){
        for(int i = 0; i<array.length; i++){
            if(array[i]!=null)
            return (String) array[i].toString();
        }
        return "";
    }
    public static void main(String[] args) {
        StackArray<Integer> pila = new StackArray<Integer>(5);
        pila.push(5);
        pila.push(10);
        pila.push(25);
        pila.printStack();
        pila.pop();
        pila.printStack();
        
    }

}
