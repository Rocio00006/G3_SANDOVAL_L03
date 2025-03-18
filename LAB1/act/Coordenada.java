package lab01.act;

public class Coordenada {
    private double x;
    private double y;

    //constructor
    public Coordenada(){
        this.x = 0;
        this.y = 0;
    }
    public Coordenada(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Coordenada(Coordenada c){
        this.x = c.getX();
        this.y = c.getY();
    }
    //setters y getters
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    //metodos
    public double distancia(Coordenada c){
        double dis;
        dis = Math.sqrt((c.getX()*c.getX())+(c.getY()*c.getY()));
        return dis;
    }
    //método static para calcular distancia entre 2 puntos
    public static double distancia(Coordenada c1, Coordenada c2){
        double x1 = c1.getX();
        double y1 = c1.getX();
        double x2 = c2.getY();
        double y2 = c2.getX();

        double resX = x1-x2;
        double resY = y1-y2;
        double dis;
        dis = Math.sqrt(resX*resX+ resY*resY);
        return dis;
    }
    //toString devuelve valores en formato específico
    @Override
    public String toString(){
        return ("("+x+", "+y+")");
    }
}
