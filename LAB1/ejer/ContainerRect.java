package LAB1.ejer;

public class ContainerRect {
    private Rectangulo[] arregloRec; 
    private double [] arregloDistancias;
    private double[] arregloAreas;
    private int n; //número máximo de rectángulos
    private int numRec; //contador 

    //constructor
    public ContainerRect(int cant){
        this.arregloRec = new Rectangulo[cant]; //inicializar arreglo
        this.arregloDistancias = new double[cant];
        this.arregloAreas = new double[cant];
        this.numRec = 0;
        this.n = cant;
    }

    //metodos setters y getters
    public Rectangulo[] getArregloRec() {
        for(int i=0; i<n;i++){
            System.out.println(arregloRec[i].toString());
        }
        return arregloRec;
    }
    public void setArregloRec(Rectangulo[] arregloRec) {
        this.arregloRec = arregloRec;
    }
    public double[] getArregloDistancias() {
        return arregloDistancias;
    }
    public void setArregloDistancias(double[] arregloDistancias) {
        this.arregloDistancias = arregloDistancias;
    }
    public double[] getArregloAreas() {
        return arregloAreas;
    }
    public void setArregloAreas(double[] arregloAreas) {
        this.arregloAreas = arregloAreas;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public int getNumRec() {
        return numRec;
    }
    public void setNumRec(int numRec) {
        this.numRec = numRec;
    }
    public void addRectangulo(Rectangulo r1){
        //verificar que haya espacio en el arreglo
        if(numRec<n){
            for(int i=0; i<n;i++){
                
            }
        }
        else{
            System.out.println("el arreglo está full");
        }
    }

}
