public class Videojuego {

    String nombre;  // no podrá estar vacío.
    int anno;       // deberá estar entre 1970 y 2100
    int valoracion; // número entre 0 y 100.

    public Videojuego(String nombre, int anno, int valoracion) {
        this.nombre = nombre;
        this.anno = anno;
        this.valoracion = valoracion;
    }

    // los sets deberán tener en cuenta las restricciones para cada atributo
    public void  setNombre(String nuevo) {
        this.nombre = nuevo;
    }

    public void setAnno(int nuevo) {
        this.anno = nuevo;
    }

    @Override
    public String toString() {
        return nombre + "\t" + anno + "\t" + valoracion;
    }
}