public class Pizzita {

    // atributos de clase
    private static int total = 0;
    private static int contServidas = 0;

    // atributos de objeto
    private String tipo;
    private String tamano;
    private int estado; // 0 - pedido; 1 - servido

    public Pizzita (String tipo, String tamano) {
        this.tipo = tipo;
        this.tamano = tamano;
        this.estado = 0;    
        Pizzita.total += 1;
    }

    public void sirve() {
        if (estado == 0) {    
            this.estado = 1; // atributo de estado 
            Pizzita.contServidas += 1;
        }
        else
            System.out.println("esa pizza ya se ha servido");
    }

    public static int getTotalPedidas() {
        return Pizzita.total; // atributo de clase
    }

    public static int getTotalServidas() {
        return Pizzita.contServidas; // atributo de clase
    }

    private String estadoActual(int estado) {
        return  (estado == 0)? "pedida" : "servida";
    }

    @Override
    public String toString() {
        return "pizza " + this.tipo + " " + this.tamano + ", " + estadoActual(this.estado);
    }
}