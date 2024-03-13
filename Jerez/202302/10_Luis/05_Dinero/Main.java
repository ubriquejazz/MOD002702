public class Main {
    public static void main(String []args) {

       Dinero suelto = new Dinero(2.1899999, TipoMoneda.euro);
       System.out.println("Euritos: " + suelto);
       System.out.println("Dollars: " + suelto.toString(TipoMoneda.dollar));
       System.out.println("Euritos: " + suelto);
       System.out.println(Dinero.cont);

       Dinero wallet = new Dinero(9.995, TipoMoneda.dollar);
       System.out.println("Euritos: " + wallet);
       System.out.println("Dollars: " + wallet.toString(TipoMoneda.dollar));
       System.out.println(Dinero.cont);


       Dinero pounds = new Dinero(21.495, TipoMoneda.pound);
       System.out.println("Euritos: " + pounds);
       System.out.println("Dollars: " + pounds.toString(TipoMoneda.pound));
       System.out.println(Dinero.cont);

       System.out.println("\nUpdating change rate...");
       Dinero.actualizaListaInternet();
       
    }
}
