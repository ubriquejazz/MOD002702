/*	Author:
 *  Date: 20220431 (sesion 15)
 * 	Class: 
 * 		Expresion matematica formadas por varios términos, en los cuales intervienen coefientes 
 * 		y letras relacionados dentro de operaciones como suma, resta, o potenciacion.	
 * */

public class Polinomio 
{
	private int[] coeficientes;
	private int grado;

	public Polinomio(int g) {
		grado=g;
		coeficientes = new int[grado+1];
		for(int i=0; i<coeficientes.length; i++){
			coeficientes[i]=0;
		}
	}

	public Polinomio(int[] coef, int g) {
		if(coef.length == (g+1)){
			grado=g;
			coeficientes = new int[grado+1];
			for(int i=0; i<coeficientes.length; i++){
				coeficientes[i]=coef[i];
			}	
		}
		else {
			grado=-1;
			coeficientes=null;
		}
	}

	public int getGrado() {
		return grado;
	}

	public int getCoeficiente(int pos) {
		if(pos<=grado)
			return coeficientes[pos];
		else
			return 0;
	}

	public void setCoeficiente(int pos, int coe) {
		if(pos<=grado)
			coeficientes[pos]=coe;
	}

	// regresa c = a + b
	public Polinomio suma(Polinomio b) 
	{
		int gradoS;
		if(this.grado>=b.getGrado())
			gradoS=this.grado;
		else
			gradoS = b.getGrado();
		//int gradoS = this.grado >= b.getGrado()? this.grado : b.getGrado();

		int[] coefS = new int[gradoS+1];
		for(int i=0; i<coefS.length; i++){
			coefS[i] = this.getCoeficiente(i) + b.getCoeficiente(i);
		}
		return new Polinomio(coefS, gradoS);
 	}

	public Polinomio multiplicaEscalar(int escalar) 
	{
		int gradoNuevo = this.getGrado();
		int[]coefNuevo = new int[coeficientes.length];
		for(int i=0; i<coefNuevo.length; i++){
			coefNuevo[i] = coeficientes[i] * escalar;
		}
		return new Polinomio(coefNuevo, gradoNuevo);
	}

	public Polinomio multiplicar(Polinomio otro) 
	{
		int gradoM = this.grado + otro.getGrado();
		int[] coefM = new int[gradoM+1];

		// voy acumulando las multiplicaciones parciales en coefM
		for(int i=0;i<coefM.length;i++)
			coefM[i]=0;
		
		// recorremos en dos dimensiones
		for(int i=0; i<coeficientes.length; i++){
			for(int j=0; j<otro.getGrado()+1; j++){
				coefM[i+j] = coefM[i+j] + this.getCoeficiente(i) * otro.getCoeficiente(j);
			}
		}
		return new Polinomio(coefM,gradoM);
	}

	public int evaluar(int x) {
		int sol=0;
		int xAcum;
		for(int i=0; i<coeficientes.length; i++){
			xAcum=0;
			for(int j=0; j<=i; j++){
				xAcum = xAcum + x;	
			}
			sol = sol + xAcum * coeficientes[i];
		}
		return sol;
	}

	public String toString() {
		String salida = "";
		for(int i=0; i<coeficientes.length; i++)
			if(i < coeficientes.length-1)
				salida = salida + coeficientes[i] + "x^" + i + " +";
			else
				salida = salida + coeficientes[i] + "x^" + i;
		return salida;
	}

}	// Class
