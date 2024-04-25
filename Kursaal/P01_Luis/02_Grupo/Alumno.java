public class Alumno {

    // de clase
    static final String[] ErrorMsgs = {
        null, 
        "Name cannot be null or empty",
        "Age cannot be negative",
        "Age between 17 and 100",
        "Grade between 0 and 10"
    };

    // atributos de instancia
    private String nombre;
    private int edad;
    private int error; 
    private double grade;

    public Alumno(String nombre, int edad, double grade) {
        this.error = 0;
        setNombre(nombre);
        setEdad(edad);
        setCalificacion(grade);
    }

    public int getError() {
        return this.error;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            this.error = 1;
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.nombre = nombre;        
    }
    
    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            this.error = 2;
            throw new IllegalArgumentException("Age cannot be negative");
        }
        else if (edad < 17 && edad > 100) {
            this.error = 3;
            throw new IllegalArgumentException("Age between 17 and 100");
        }
        this.edad = edad;
    }

    public double getCalificacion() {
        return this.grade;
    }

    public void setCalificacion(double grade) {
        if (grade < 0 || grade > 10) {
            this.error = 4;
            throw new IllegalArgumentException("Grade between 0 and 10");
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Calificacion: " + grade;
    }
}
