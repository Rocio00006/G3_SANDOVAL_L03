package LAB1.ejer;

public class ContainerRect {
    private Rectangulo[] arregloRec; 
    private double [] arregloDistancias;
    private double[] arregloAreas;
    private int n; //número máximo de rectángulos
    public static int numRec; //contador variable de clase 

    //constructor
    public ContainerRect(int n){
        this.n = n;
        this.arregloRec = new Rectangulo[n]; //inicializar arreglo
        this.arregloDistancias = new double[n];
        this.arregloAreas = new double[n];
        //this.numRec = 0;
    }

    //metodos setters y getters
    public Rectangulo[] getArregloRec() {
        for(int i=0; i<arregloRec.length;i++){
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
    public void addRectangulo(Rectangulo r1){
        //verificar que haya espacio en el arreglo
        if(numRec<n){
            double areaRec = r1.calculoArea();
            double distanciaRec = Coordenada.distancia(r1.getEsquina1(), r1.getEsquina2());

            for(int i=0; i<numRec;i++){
                arregloRec[i] = r1;
                arregloAreas[i] = areaRec;
                arregloDistancias[i] = distanciaRec;
                numRec++;
            }
            System.out.println("Rectangulo agregado");
        }
        else{
            System.out.println("El arreglo está lleno");
        }
    }
    @Override
    public String toString(){
        System.out.println("Rectangulo   Coordenadas     Distancia   Area");
        for(int i = 0; i<numRec; i++){
            System.out.println((n+1)+"     "+arregloRec[i].toString()+"    "+arregloDistancias[i]+"   "+arregloAreas[i]);
        }
        return "";
    }

}
