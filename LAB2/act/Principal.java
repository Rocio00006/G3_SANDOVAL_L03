package LAB2.act;

public class Principal {
    public static void main(String[] args) {
        //creamos un objeto de bolsas de tipo genérico= Chocolatina
        Bolsa<Chocolatina> bolsaCho = new Bolsa<Chocolatina>(0);
        //creamos las chocolatinas que irán en la bolsa
        Chocolatina c=new Chocolatina("milka");
        Chocolatina c1=new Chocolatina("milka");
        Chocolatina c2=new Chocolatina("ferrero");
        bolsaCho.add(c);
        bolsaCho.add(c1);
        bolsaCho.add(c2);

        for (Chocolatina chocolatina : bolsaCho){
            System.out.println(chocolatina.getMarca());
        }

        //creación de otra bolsa de tipo Golosinas
        Bolsa <Golosina> bolsaGolo = new Bolsa<>(3);
        Golosina g1 = new Golosina("gomitas", 10);
        Golosina g2 = new Golosina("cHICLES", 5);
        Golosina g3 = new Golosina("Dulces", 3);

        bolsaGolo.add(g1);
        bolsaGolo.add(g2);
        bolsaGolo.add(g3);

        for(Golosina golosina : bolsaGolo){
            System.out.println(golosina.getNombre()+" "+golosina.getPeso());
        }
    }
}

