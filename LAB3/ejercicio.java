package LAB3;

public class ejercicio {
    double potencia (double x, int y)  { 
        double t;       //O(1)
        if (y == 0)     //O(1)
         return 1.0; 
        if (y % 2 == 1) 
         return x * potencia(x, y - 1); 
        else { 
         t = potencia(x, y / 2); 
         return t * t; 
        } 
    } 
    public static void main(String[] args) {
    }
}
