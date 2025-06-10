package LAB9.graph3;

public class EdgeObj<V, E> {
    protected E info;
    protected VertexObj<V, E> endVertex1;
    protected VertexObj<V, E> endVertex2;
    protected int position;
    
    public EdgeObj(VertexObj<V, E> vert1, VertexObj<V, E> vert2, E info, int position) {
        this.endVertex1 = vert1;
        this.endVertex2 = vert2;
        this.info = info;
        this.position = position;
    }
    
    //Constructor sin información de arista (para aristas simples)
    public EdgeObj(VertexObj<V, E> vert1, VertexObj<V, E> vert2, int position) {
        this.endVertex1 = vert1;
        this.endVertex2 = vert2;
        this.info = null;
        this.position = position;
    }
    public E getInfo() {
        return info;
    }
    public VertexObj<V, E> getEndVertex1() {
        return endVertex1;
    }
    public VertexObj<V, E> getEndVertex2() {
        return endVertex2;
    }
    
    public int getPosition() {
        return position;
    }
    public void setInfo(E info) {
        this.info = info;
    }
    public void setEndVertex1(VertexObj<V, E> endVertex1) {
        this.endVertex1 = endVertex1;
    }
    public void setEndVertex2(VertexObj<V, E> endVertex2) {
        this.endVertex2 = endVertex2;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    //método para verificar si la arista contiene un vértice específico
    public boolean contains(VertexObj<V, E> vertex) {
        return endVertex1.equals(vertex) || endVertex2.equals(vertex);
    }
    
    //método para obtener el vértice opuesto dado uno de los vértices
    public VertexObj<V, E> getOpposite(VertexObj<V, E> vertex) {
        if (endVertex1.equals(vertex)) {
            return endVertex2;
        } else if (endVertex2.equals(vertex)) {
            return endVertex1;
        }
        return null;
    }
    
    //método para verificar si conecta dos vértices específicos
    public boolean connects(VertexObj<V, E> v1, VertexObj<V, E> v2) {
        return (endVertex1.equals(v1) && endVertex2.equals(v2)) ||
               (endVertex1.equals(v2) && endVertex2.equals(v1));
    }
    
    @Override
    public String toString() {
        return "Edge{" + 
               "vertex1=" + endVertex1.getInfo() + 
               ", vertex2=" + endVertex2.getInfo() + 
               ", info=" + info + 
               ", position=" + position + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        @SuppressWarnings("unchecked")
        EdgeObj<V, E> edge = (EdgeObj<V, E>) obj;
        return connects(edge.endVertex1, edge.endVertex2);
    }
    
    @Override
    public int hashCode() {
        // Hash basado en los vértices (sin importar el orden)
        int hash1 = endVertex1.hashCode();
        int hash2 = endVertex2.hashCode();
        return hash1 + hash2; // Suma para que sea simétrico
    }
}