package LAB2.act;

public class TestGen3 {
    public static void main(String[] args) {
        //ejercicio 6

        //creamos un objeto cajoneria que almacene chocolaitnas
        Cajoneria<Chocolatina> cajoneria2 = new Cajoneria<>(5);

        //primero creamos cajas
        Caja<Chocolatina> cajaRoja = new Caja<>("roja");
        Caja<Chocolatina> cajaNegra = new Caja<>("negra");

        //creamos chocolatinas que irán en las cajas
        Chocolatina c1=new Chocolatina("milka");
        Chocolatina c2=new Chocolatina("Donofrio");
        Chocolatina c3=new Chocolatina("Sublime");
        Chocolatina c4=new Chocolatina("Princesa");
        Chocolatina c5=new Chocolatina("ferrero");

        //agregamos golosinas a las cajas, por ende a la cajonería
        cajaRoja.add(c1);
        cajaRoja.add(c2);
        cajaRoja.add(c3);
        cajaNegra.add(c4);
        cajaNegra.add(c5);
        
        //agregamos cajas a la cajoneria
        cajoneria2.add(cajaRoja);
        cajoneria2.add(cajaNegra);

        //verificamos que hayan golosinas en la cajonería
        cajoneria2.search(c4);
        
        // Imprimir el contenido de la cajoneria
        System.out.println("Contenido de la Cajonería:");
        cajoneria2.toString();

        //eliminamos una golosina de la cajonería
        cajoneria2.delete(c3);

        // Imprimir el contenido de la cajoneria
        System.out.println("Contenido de la Cajonería:");
        cajoneria2.toString();
    }
}
