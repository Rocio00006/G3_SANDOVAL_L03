package LAB2.act;

public class Golosina {
    private String nombre;
    private double peso;

    public Golosina(String nombre, double peso){
        this.nombre=nombre;
        this.peso=peso;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    @Override
    public String toString() {
        return "Golosina [nombre=" + nombre + ", peso=" + peso + "]";
    }
    
}
