
public class CPersona
{
	private String nombre;
	private String direccion;
	private long telefono;
	
	public CPersona(){}
	
	public CPersona(String nom, String dir, long tel){
		nombre = nom;
		direccion = dir;
		telefono = tel;
	}
	
	public void setNombre(String nom) {
		nombre = nom;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setDireccion(String dir) {
		direccion = dir;
	}
	
	public String getDireccion() {
		return direccion;
	}	
	
	public void setTelefono(long tel) {
		telefono = tel;
	}
	
	public long getTelefono() {
		return telefono;
	}	
}
