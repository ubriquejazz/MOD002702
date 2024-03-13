public class Carta {
    private String palo;
    private String nombre;
    private double valor;

    public Carta(String palo, String nombre, double valor) {
        this.palo = palo;
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

    public String toString() {
        return nombre + " de " + palo;
    }
}
