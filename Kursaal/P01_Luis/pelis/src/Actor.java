public class Actor {
    
    private int id;
    private String nombre;
    private String pais;

    public Actor (int id, String nombre, String pais) {
        this.pais = pais;
        this.id = id;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Actr " + id + ", " + nombre + " (" + pais + ")";
    }   
}
