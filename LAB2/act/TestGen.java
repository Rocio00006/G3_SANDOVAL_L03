package LAB2.act;

public class TestGen {
    public static void main(String[] args) {
        String[] v = {"Perez", "Sanchez","Rodriguez"};
        Integer[] w = {12,34,56};

        System.out.println(exist(v,"Sanchez")); 
        System.out.println(exist(w,34)); 
        System.out.println(exist(w,"Salas"));
    }
}
