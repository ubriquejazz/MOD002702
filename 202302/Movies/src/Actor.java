import java.time.LocalDate;

public class Actor {

    private int id;

    private String nombre;
    private LocalDate fNac;

    public Actor (int id, String nombre, LocalDate fNac) {
        this.fNac = fNac;
        this.id = id;
        this.nombre = nombre;
    }

    public LocalDate getfNac() {
        return fNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Actor " + this.nombre + " (" + id + ")";
    }
}
