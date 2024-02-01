public class Pizzita {

    // variable de instancia
    private String size;
    private String type;
    private int state;

    // variable de clase
    static int count_pedidas = 0;
    static int count_servidas = 0;

    Pizzita(String type, String size) {
        this.type = type;
        this.size = size;
        this.state = 0; // pedida
        count_pedidas++;
    }

    public void sirve() {
        if (this.state == 1) 
            System.err.println("esa pizza ya servida");
        else {
            this.state = 1; // servida
            count_servidas++;
            count_pedidas--;
        }
    }

    public String getState() {
        if (this.state == 1) 
            return "servida";
        else
            return "pedida";
    }

    public String toString() {
        return "pizza " + this.type + ", " 
            + this.size + " " + this.getState();
    }

    public static int getTotalServidas() {
        return count_servidas;
    }

    public static int getTotalPedidas() {
        return count_pedidas;
    }

    
}
