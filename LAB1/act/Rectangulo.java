package LAB1.act;

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
    @Override
    public String toString(){
        return ("Rectangulo A = (["+esquina1.getX()+", "+esquina1.getY()+"], ["+esquina2.getX()+", "+esquina2.getY()+"])");
    }
}