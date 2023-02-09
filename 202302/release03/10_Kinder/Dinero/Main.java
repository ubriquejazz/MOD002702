public class Main {
    public static void main(String []args) {


       Dinero pocket = new Dinero(2.1899999, TipoMoneda.euro);
       System.out.println("Euritos: " + pocket);
       System.out.println("Dollars: " + pocket.toString(TipoMoneda.dollar));
       //System.out.println(pocket + " = " + pocket.valorEn(TipoMoneda.pound) + TipoMoneda.pound);
       Dinero libritas = pocket.convertirEn(TipoMoneda.pound);
       System.out.println("Libritas: " + libritas);

       System.out.println("\nUpdating change rate...");
       pocket.actualizaListaInternet();

    }
}
