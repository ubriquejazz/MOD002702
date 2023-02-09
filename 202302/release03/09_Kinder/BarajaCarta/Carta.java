public class Carta {
    private int numero;     // 0 - 6; 7 - 9 son figuras
    private int palo;       // 0: oro; 1: copas; 2: esp; 3: bast
    private boolean used;

    public Carta(int palo, int numero) {
        this.numero = numero;
        this.palo = palo;
        this.used = false;
    }

    public Carta(int id) {
        // id entre 1 y 40 que representa la carta  
        this.palo = id/10;
        this.numero = id%10;        
    }

    public int getNumero() {
        return this.numero;
    }

    public int getPalo() {
        return this.palo;
    }

    public void use() {
        this.used = true;
    }
    
    public boolean getUsed() {
        return this.used;
    }

    public String nombreNumero(int numero) {
        String[] aux = {"as", "dos", "tres", "cuatro", "five", "six", "siete", "sota", "caballo", "rey"};
        return aux[numero];
    }

    public String nombrePalo(int palo) {
        String[] aux = {"oro", "copas", "espadas", "bastos"};
        return aux[palo];
    }
    
    public String toString() {
        int id = this.palo*10 + this.numero;
        return nombreNumero(this.numero) + " de " + nombrePalo(this.palo) + " (" + id + " " + used + ")";
    }

    public double valor7ymedia() {
        return (this.numero > 6) ? 0.5 : (this.numero + 1);
    }
}