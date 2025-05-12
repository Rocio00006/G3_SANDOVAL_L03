package LAB6.ejercicio4;

public class Aplication {
    //funcion que verifica si se cumplen las condiciones
    public static boolean symbolBalancing(String s) throws ExceptionIsEmpty {
        //creamos una pila de tipo Character 
        StackLink<Character> stack = new StackLink<>();

        //usaremos un for para recorrer cada caracter de la cadena s
        //el método toCharArray que convierte String a un arr de chars
        for (char ch : s.toCharArray()) {
            //si ch (el caracter) es de apertura
            if (ch == '(' || ch == '[' || ch == '{') {
                //se agrega a la pila usando push
                stack.push(ch);
            }
            //si el caracter es de cierre
            else if (ch == ')' || ch == ']' || ch == '}') {
                //y la lista está vacía hay un ERROR
                if (stack.isEmpty())
                    return false;
                try {
                    char open = stack.pop();
                    if (!hacePar(open, ch))
                        return false;
                } catch (ExceptionIsEmpty e) {
                    return false;
                }
            }
        }

        for (char ch : s.toCharArray()) {
            //si ch (el caracter) es de apertura
            if (ch == '(' || ch == '[' || ch == '{') {
                //se agrega a la pila usando push
                stack.push(ch);
            } 
            //si el caracter es de cierre
            else if (ch == ')' || ch == ']' || ch == '}') {
                //y la lista está vacía hay un ERROR=false
                if (stack.isEmpty())
                    return false;
                //si no está vacía, toma el último caracte
                char apertura = stack.pop();
                //y verifica si hace par con el de cierre
                if (!hacePar(apertura, ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }
    //método que verifica si son del mismo tipo
    private static boolean hacePar(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '[' && cierre == ']') ||
               (apertura == '{' && cierre == '}');
    }
}
