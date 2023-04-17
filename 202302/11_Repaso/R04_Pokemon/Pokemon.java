public class Pokemon {
    private int id;
    private String nombre;
    private String tipo1, tipo2;          // habilidad;
    private int ataque, ataqueespecial;
    private int defensa, defensaespecial;
    private int vida, velocidad;
    private boolean capturado;

    public Pokemon(int id, String nombre, String tipo1,  String tipo2, 
        int ataque, int ataqueespecial, int defensa, int defensaespecial, 
        int vida, int velocidad, boolean capturado) {
        this.id             = id;
        this.nombre         = nombre;
        this.tipo1          = tipo1;
        this.tipo2          = tipo2;
        this.ataque         = ataque;
        this.ataqueespecial = ataqueespecial;
        this.defensa        = defensa;
        this.defensaespecial= defensaespecial;
        this.velocidad      = velocidad;
        this.vida           = vida;
        this.capturado      = capturado;        
    }

    // una propiedad de sólo lectura para cada atributo 
    public int getId() {
        return this.id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getTipo1() {
        return this.tipo1;
    }
    public String getTipo2() {
        return this.tipo2;
    }
    public boolean getCapturado() {
        return this.capturado;
    }

    // excepto para capturado, que será de lectura y escritura.
    public void setCapturado(boolean newValue) {
        this.capturado = newValue;
    }

    public String toString() {
        String s = id + " - " + nombre;
        if (capturado) {
            s = " (" + tipo1 +  ", " + tipo2 + ") " + 
                "v1:" + ataque + "; v2:" + ataqueespecial+
                "v3:" + defensa + "; v4:" + defensaespecial+
                "v5:" + vida + "; v6:" + velocidad;
        }
        return s;
    }
}
