package LAB6.actividad1;

//en las pilas: el ultimo sale
//STACK: LIFO-> Last In Last Out
public class StackArray<E extends Object> {
    private E[] array;  //arreglo en sí
    private int tope;   //posicion el último elemento
    private int tmñMax; //tamaño maximo del arreglo

    public StackArray(int n){ 
        this.array = (E[]) new Object[n]; 
        tope = -1;  //arreglo vacio
        tmñMax = n;
    } 
    public void push(E ele){
        //primero verificar si está lleno
        if(isFull()){
            System.out.println("Stack está re lleno");
            return;
        }
        array[tope+1] = ele;
        tope = tope +1;
    }
    public void pop(){
        System.out.println("Este es el tope: "+tope);
        array[tope] = null;
        tope--;
    }
    public boolean isEmpty(){
        if(tope==-1){
            return false;
        }
        return false;
    }
    public boolean isFull(){
        if(tope==tmñMax-1){ //signidica que ha llegado al máximo
            return true;
        }
        return false;
    }
    public void printStack(){
        for(int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }
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
