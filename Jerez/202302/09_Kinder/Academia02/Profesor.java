public class Profesor extends Persona{
    String asignatura;
    double salario;

    public Profesor(String nombre, int edad, String asignatura, double salario) {
        super(nombre, edad);
        this.asignatura = asignatura;
        this.salario = salario;
    }
    
}
