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

        if(Verificador.esSobrePos(rA, rB)== true){
            System.out.println("se sobreponene");
        }
        else
            System.out.println("no se sobreponen");

        sc.close();
    }
}
