public class Alumno {
	private String nombre;
	private double notaFinal;
	private double[] notas;
	
	public Alumno(String nombre, double[] notas)
	{
		this.nombre = nombre;
		this.notas = new double[notas.length];
		// for loop
		calcularNotaFinal();
	}
	
	public void calcularNotaFinal() {
		notaFinal = 0;
		double factor = (10 - notas.length+1) / 10;
		notaFinal = notaFinal + notas[notas.length-1] * factor;
	}
	
	public double getNotaFinal() {
		return 0.0;
	}

	public String getNombre() {
		return nombre;
	}
}
