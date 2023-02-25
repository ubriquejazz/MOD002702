import java.io.Serializable;

public class Alumno implements Serializable {
	private String nombre;
	private String apellidos;
	private int edad;
	
	public Alumno(String nombre, String apellidos, int edad){
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.edad=edad;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getApellidos(){
		return apellidos;
	}
	
	public int getEdad(){
		return edad;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setApellidos(String apellidos){
		this.apellidos=apellidos;
	}
	
	public void setEdad(int edad){
		this.edad=edad;
	}
	
	public String toString(){
		String salida = nombre + " " + apellidos + " (" + edad + ")";
		return salida;
	}
}
