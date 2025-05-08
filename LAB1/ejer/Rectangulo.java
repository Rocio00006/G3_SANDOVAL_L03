package LAB1.ejer;

public class Rectangulo{
    private Coordenada esquina1;
    private Coordenada esquina2;
    //constructor
    public Rectangulo(Coordenada c1, Coordenada c2  ){
        this.esquina1 = c1;
        this.esquina2 = c2;
    }

    //getters y setters
    public Coordenada getEsquina1() {
        return esquina1;
    }
    public void setEsquina1(Coordenada esquina1) {
        this.esquina1 = esquina1;
    }
    public Coordenada getEsquina2() {
        return esquina2;
    }
    public void setEsquina2(Coordenada esquina2) {
        this.esquina2 = esquina2;
    }

    //método de instancia 
    public double calculoArea(){
        double base, altura;
        base = Math.abs(esquina1.getX()-esquina2.getX());
        altura = Math.abs(esquina2.getY()-esquina1.getY());
        return base*altura;
    }

    @Override
    public String toString(){
        return "Rectangulo = (["+esquina1.toString()+"], ["+esquina2.toString()+"])";
    }
}