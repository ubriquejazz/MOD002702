public class Profesor {
    private String nombre;
    private String dni;
    private int genero; // (0=hombre, 1=mujer)

    public Profesor(String nombre, String dni, int genero) {
        this.nombre = nombre;
        this.dni = dni;
        this.genero = genero;
    }

    public int getGenero() {
        return genero;
    }

    public String toString() {
        return genero + " - " + nombre;
    }
    
}