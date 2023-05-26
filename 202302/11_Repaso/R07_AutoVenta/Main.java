public class Main {


    public static void test01() {
        AutoVenta tienda = new AutoVenta("errores.csv");
    }

    public static void test02() {
        AutoVenta tienda = new AutoVenta("coches.csv");
        tienda.imprimeListado();
        Coche miCoche = tienda.buscaCoche("9878DRT");
        if (miCoche != null)
            System.out.println(miCoche);
        
        tienda.guardaCSV("buenos.csv");
    }

    public static void main(String[] args) {
        test02();       
    }
}
