package LAB9.graph7;

public class VertexObj<V, E> {
    protected V info;
    protected int position;
    
    public VertexObj(V info, int position) {
        this.info = info;
        this.position = position;
    }
    public V getInfo() {
        return info;
    }  
    public int getPosition() {
        return position;
    }
    public void setInfo(V info) {
        this.info = info;
    }  
    public void setPosition(int position) {
        this.position = position;
    } 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        @SuppressWarnings("unchecked")
        VertexObj<V, E> vertex = (VertexObj<V, E>) obj;
        
        return info != null ? info.equals(vertex.info) : vertex.info == null;
    }
    @Override
    public int hashCode() {
        return info != null ? info.hashCode() : 0;
    }
    @Override
    public String toString() {
        return "Vertex{" + "info=" + info + ", position=" + position + '}';
    }
}