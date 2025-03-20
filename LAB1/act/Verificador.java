package LAB1.act;

public class Verificador {
    public static boolean esSobrePos(LAB1.act.Rectangulo r1, Rectangulo r2){
        double r1x1, r1y1, r1x2, r1y2;  //esquinas de r1
        double r2x1, r2y1, r2x2, r2y2;  //esquinas de r2

        //definir x1, x2, y1, y2 de r1
        r1x1 = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        r1x2 = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        r1y1 = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        r1y2 = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        
        //definir x1, x2, y1, y2 de r2
        r2x1 = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        r2x2 = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        r2y1 = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        r2y2 = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());

        //condiciones para que se sobrepongan
        //no hay intersección si r1 está arriba, debajo, a la izquierda o derecha de r2
        if(r1y2 < r2y1 || r1y1>r2y2 || r1x2<r2x1 || r1x1>r2x2){
            return false;
        }
        else
            return true;

    }
    public static boolean esJunto(Rectangulo r1, Rectangulo r2){

        return true;
    }
    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2){
        double r1x1, r1y1, r1x2, r1y2;  //esquinas de r1
        double r2x1, r2y1, r2x2, r2y2;  //esquinas de r2
        //definir x1, x2, y1, y2 de r1
        r1x1 = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        r1x2 = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        r1y1 = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        r1y2 = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        
        //definir x1, x2, y1, y2 de r2
        r2x1 = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        r2x2 = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        r2y1 = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        r2y2 = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        return true;
    }
}
