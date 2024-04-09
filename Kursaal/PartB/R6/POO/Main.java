public class Main {
    public static void main(String[] args) {

        Pizzita p1 = new Pizzita("margarita", "mediana");
        Pizzita p2 = new Pizzita("funghi", "familiar");
        p2.sirve();
        Pizzita p3 = new Pizzita("cuatro quesos", "mediana");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        p2.sirve();
        System.out.println("pedidas: " + Pizzita.getTotalPedidas());
        System.out.println("servidas: " + Pizzita.getTotalServidas());
        
    }
}