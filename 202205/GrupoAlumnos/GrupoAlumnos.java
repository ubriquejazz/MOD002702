import java.util.*;

public class GrupoAlumnos 
{
	// private Alumno[] alumnos;
	// private int numAlumnos;
	// private int maxAlumnos;
	private ArrayList<Alumno> alumnos;
	
	public GrupoAlumnos(int capacidad) {
		alumnos = new ArrayList<Alumno>(capacidad);
	}
	
	public int getNumAlumnos() {
			return alumnos.size();
	}
	
	public Alumno[] getAlumnos() {
			return (Alumno[])alumnos.toArray();
	}
	
	public void anadirAlumno(Alumno nuevo) {
			alumnos.add(nuevo);
	}
	
	public void listarAlumnos() {
		for (int i=0; i<alumnos.size(); i++) {
			String nombre = (alumnos.get(i)).getNombre();
			double nota = (alumnos.get(i)).getNotaFinal();
			System.out.println(nombre + ". Nota: "+ nota);
		}
	}
	
	
}
