package LAB5;

public class Tarea {
    private String titulo;
    private int prioridad;
    
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
        return "Tarea [" + titulo + ", P:" + prioridad + "]";
    }
    //sobreescribir para poder comparar
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;

        Tarea tarea = (Tarea) obj;
        return prioridad == tarea.prioridad &&
               (titulo != null ? titulo.equals(tarea.titulo) : tarea.titulo == null);
    }
}
