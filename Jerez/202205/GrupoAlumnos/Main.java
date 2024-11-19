public class Main {
    public static void main(String[] args) {

        double notas[];
        notas = new double [10];

        Alumno diego = new Alumno("Diego Gay", notas);
        Alumno juan = new Alumno("Juan Gago", notas);

        GrupoAlumnos daw1 = new GrupoAlumnos(5);
        daw1.anadirAlumno(diego);
        daw1.anadirAlumno(juan);
        daw1.listarAlumnos();
    }
}