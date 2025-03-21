package LAB1.ejer;

public class Verificador {

    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {

        double x1r1, y1r1, x2r1, y2r1;
        double x1r2, y1r2, x2r2, y2r2;

        //asignar valores rectangulo 1
        x1r1 = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        x2r1 = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        y1r1 = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        y2r1 = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        
        //asignar valores rectangulo 2
        x1r2 = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        x2r2 = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        y1r2 = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        y2r2 = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());

        
        if(x1r1<x2r2 || x1r2< x2r1 || y1r1<y2r2 || y1r2<y2r1){
            return true;
        }
        else
            return false;

        //condiciones para que se sobrepongan
        //no hay intersección si r1 está a ña derecho, izquierdo, arriba o debajo de r2
        /*
        if(x1r1 >=x2r2 || x2r1 <= x1r2 || y1r1 >= y2r2 || y2r1 <= y1r2){
            return false;
        }
        else
            return true;*/
    }

    public static boolean esJunto(Rectangulo r1, Rectangulo r2){
        if (esSobrePos(r1, r2)) {
            return false;
        }

        double x1r1, y1r1, x2r1, y2r1;
        double x1r2, y1r2, x2r2, y2r2;
        
        //establecer esquinas de r1
        x1r1 = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        x2r1 = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        y1r1 = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        y2r1 = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());

        //establecer esquinas del rectángulo r2
        x1r2 = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        x2r2 = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        y1r2 = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        y2r2 = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());

        //para que se "junten" deben compartir un lado vertical u horizontal o esquinas
        boolean ladoVertical =false;
        boolean ladoHorizontal =false;

        //comparten lado vertical o un punto en el eje vertical
        if ((x1r1 == x2r2 || x2r1 == x1r2) && !(y1r1 > y2r2 || y2r1 < y1r2)){
            ladoVertical = true;
        }
        //comparten el lado horizontal o un punto en el eje horizontal
        if((y2r1 == y1r2 || y1r1 == y2r2) && !(x1r1 > x2r2 || x2r1 < x1r2)){
            ladoHorizontal = true;
        }
        
        if(ladoVertical==true || ladoHorizontal==true){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2){

        if(esJunto(r1, r2)==true){
            return false;
        }
        double x1r1, y1r1, x2r1, y2r1;
        double x1r2, y1r2, x2r2, y2r2;
        
        // Establecer esquinas de r1
        x1r1 = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        x2r1 = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        y1r1 = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        y2r1 = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());

        // Establecer esquinas del rectángulo r2
        x1r2 = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        x2r2 = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        y1r2 = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        y2r2 = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());

        //condiciones para que se sobrepongan
        //no hay intersección si r1 está a ña derecho, izquierdo, arriba o debajo de r2
        if(x1r1 > x2r2 || x2r1 < x1r2 || y2r1 < y1r2 || y1r1 > y2r2){
            return true;
        }
        else
            return false;
    }
}
