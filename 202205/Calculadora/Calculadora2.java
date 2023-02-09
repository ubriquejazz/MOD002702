public class Calculadora2 {
	private double num1;
	private double num2;
	private char operador;
	private String resultado;
	
	public Calculadora2 (){
		this.num1=0;
		this.num2=0;
		this.operador='+';
		calcularOperacion();	
	}
	
	public Calculadora2 (double num1, double num2,char operador){
		this.num1=num1;
		this.num2=num2;
		this.operador=operador;
		calcularOperacion();	
	}
	
	public double getNum1(){
		return num1;
	}
	
	public double getNum2(){
		return num2;
	}
	
	public char getOperador(){
		return operador;
	}
	
	public String getResultado(){
		return resultado;
	}
	
	public void setNum1(double num1){
		this.num1=num1;
		calcularOperacion();
	}
	
	public void setNum2(double num2){
		this.num2=num2;
		calcularOperacion();
	}
	
	public void setOperador(char operador){
		this.operador=operador;
		calcularOperacion();
	}
	
	private void calcularOperacion(){
		double result;
		switch(operador){
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
			case'd':
			case'w':
				if(num2==0)
					result = Integer.MIN_VALUE;
				else
					result = num1/num2;
				break;
			default:
				result = Integer.MIN_VALUE;
		}	
		if(result==Integer.MIN_VALUE)
			resultado = "La expresión es incorrecta.";	
		else
			resultado = num1 + " " + operador + " " + num2 +" = " + result; 
	}
}
