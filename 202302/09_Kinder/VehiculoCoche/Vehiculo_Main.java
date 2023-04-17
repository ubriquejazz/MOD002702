public class Vehiculo_Main {

    public static void main(String[] args) {
        Coche seiscientos = new Coche("Seat");
        Coche fordCourier = new Coche("Ford");
        Bicicleta bici1 = new Bicicleta("Orbea");
        seiscientos.recorre(100);
        fordCourier.recorre(200);
        seiscientos.recorre(200);
        bici1.recorre(10);
        System.out.println("Ford kms = " + fordCourier.getKilometrosRecorridos());
        System.out.println("Total kms = " + Vehiculo.getKilometrosTotales());  
        System.out.println("Instancias = " + Vehiculo.getVehiculosCreados());

        seiscientos.quemaRueda();
        bici1.hazCaballito();

    }

    public static void pintaMenu() {
        System.out.println("1. Anda en bici");
        System.out.println("2. Haz el caballito en bici");
        System.out.println("3. Anda en coche");
        System.out.println("4. Quema rueda en coche");
        System.out.println("5. Kilometraje de un coche");
        System.out.println("6. Kilometraje de una bici");
        System.out.println("7. Kilometraje total de todo");
        System.out.println("8. Salir");
        System.out.println("Elige una opcion (1-8):");
    }


}