public class Alumno {

    // atributos
    private String nombre;
    private int edad;
    private int error;      // code
    private double calificacion;

    public Alumno(String nombre, int edad, double calificacion) {
        this.error = 0;
        setNombre(nombre);
        setEdad(edad);
        setCalificacion(calificacion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.isEmpty()) {
            this.nombre = nombre;
        }
        else {
            this.error = -1;
        }
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 17 && edad <= 100) {
            this.edad = edad;
        } 
        else {
            this.error = -2;
        }
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        if (calificacion >= 0 && calificacion <= 10) {
            this.calificacion = calificacion;
        }
        else {
            this.error = -3;
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Calificacion: " + calificacion;
    }
}
