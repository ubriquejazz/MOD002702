public class Pizza {

    // atributos de clase
    private static int total = 0;
    private static int contServidas = 0;

    // atributos de objeto
    private String tipo;
    private String tamano;
    private int estado; // 0 - pedido; 1 - servido

    public Pizza (String tipo, String tamano) {
        this.tipo = tipo;
        this.tamano = tamano;
        this.estado = 0;    
        Pizza.total += 1;
    }

    public void sirve() {
        if (estado == 0) {    
            this.estado = 1; // atributo de estado 
            Pizza.contServidas += 1;
        }
        else
            System.out.println("esa pizza ya se ha servido");
    }

    public static int getTotalPedidas() {
        return Pizza.total; // atributo de clase
    }

    public static int getTotalServidas() {
        return Pizza.contServidas; // atributo de clase
    }

    private String estadoActual(int estado) {
        return  (estado == 0)? "pedida" : "servida";
    }

    @Override
    public String toString() {
        return "pizza " + this.tipo + " " + this.tamano + ", " + estadoActual(this.estado);
    }
}