package LAB1.act;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        double x1r1, x2r1, y1r1, y2r1;
        double x1r2, x2r2, y1r2, y2r2;

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una esquina del 1° rectangulo: ");
        x1r1 = sc.nextDouble();
        y1r1 = sc.nextDouble();
        System.out.println("Ingrese la esquina opuesta del 1° rectangulo: ");
        x2r1 = sc.nextDouble();
        y2r1 = sc.nextDouble();

        System.out.println("Ingrese una esquina del 2° rectangulo: ");
        x1r2 = sc.nextDouble();
        y1r2 = sc.nextDouble();
        System.out.println("Ingrese la esquina opuesta del 2° rectangulo: ");
        x2r2 = sc.nextDouble();
        y2r2 = sc.nextDouble();

        Coordenada e1a = new Coordenada(x1r1, y1r1);
        Coordenada e2a = new Coordenada(x2r1, y2r1);

        Coordenada e1b = new Coordenada(x1r2, y1r2);
        Coordenada e2b = new Coordenada(x2r2, y2r2);

        Rectangulo rA = new Rectangulo(e1a, e2a);
        Rectangulo rB = new Rectangulo(e1b, e2b);

        mostrarRectangulos(rA, rB);
        relacionRectangulos(rA, rB);

        sc.close();
    }
    //mostrar la información de cada rectángulo
    public static void mostrarRectangulos(Rectangulo a, Rectangulo b){
        System.out.println("Rectangulo A;  "+a.toString());
        System.out.println("Rectangulo B: "+b.toString());
    }
    //método para verificar las relaciones entre los rectangulos
    public static void relacionRectangulos(Rectangulo a, Rectangulo b){
        if(Verificador.esSobrePos(a, b)){
            System.out.println("Rectangulos A y B se sopreonen");
            System.out.println("Áera de sobreposición; "+rectanguloSobre(a, b).calculoArea());
        }
        if(Verificador.esJunto(a, b)){
            System.out.println("Rectángluos A y B se juntan");
        }
        if(Verificador.esDisjunto(a, b)){
            System.out.println("Rectangulos A y B son dijuntos");
        }
    }
    //método para caluclar coordenadas del retangulo interseción
    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2){
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

        double x1, y1, x2, y2; //valores para el nuevo rectángulo
        x1=Math.max(x1r1, x1r2);
        y1=Math.max(y1r1, y1r2);
        x2=Math.min(x2r1, x2r2);
        y2= Math.min(y2r1,y2r2);

        //coordenadas para el nuevo rectangulo
        Coordenada c1 = new Coordenada(x1, y1);
        Coordenada c2 = new Coordenada(x2, y2);

        Rectangulo r = new Rectangulo(c1, c2);
        return r;
    }

}
