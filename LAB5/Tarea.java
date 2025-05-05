package LAB5;

public class Tarea {
    private String titulo;
    private int prioridad;
    
    //constructor
    public Tarea(){
        this.titulo = "";
        this.prioridad = 0;
    }
    public Tarea(String titulo, int prioridad){
        this.titulo = titulo;
        this.prioridad = prioridad;
    }
    //getters y setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    @Override
    public String toString() {
        return "Tarea [titulo=" + titulo + ", prioridad=" + prioridad + "]";
    }
    
}
