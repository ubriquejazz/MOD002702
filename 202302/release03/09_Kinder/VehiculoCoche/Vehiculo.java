public class Vehiculo {

    // atributos de clase
    private static int kilometrosTotales = 0;
    private static int vehiculosCreados = 0;
    
    // atributos de instancia
    private int kilometrosRecorridos;

    public Vehiculo() {
        Vehiculo.vehiculosCreados += 1; // atributo de clase
        this.kilometrosRecorridos = 0; // atributo de instancia
    }

    // atributos de clase
    public static int getVehiculosCreados() {
        return Vehiculo.vehiculosCreados;
    }

    public static int getKilometrosTotales() {
        return Vehiculo.kilometrosTotales;
    }

    // atributos de instancia
    public int getKilometrosRecorridos() {
        return this.kilometrosRecorridos;
    }

    // Hace que un vehículo recorra una distancia determinada.
    public void recorre(int km) {
        this.kilometrosRecorridos += km;
        Vehiculo.kilometrosTotales += km;
    }

}