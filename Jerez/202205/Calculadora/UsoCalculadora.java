import java.io.*;
import java.util.*;
import java.util.Scanner;

public class UsoCalculadora{

	public static void pintaMenu() {
		System.out.println("PRUEBA DE IMPLEMENTACION DE UNA CALCULADORA");
		System.out.println("Pulse 1 si quiere hacer una suma");
		System.out.println("Pulse 2 si quiere hacer una resta");
		System.out.println("Pulse 3 si quiere hacer una multipl");
		System.out.println("Pulse 4 si quiere hacer una division");
		System.out.println("Pulse 5 para salir");
		System.out.print("Introduzca opcion: ");
	  }

	public static void main (String[] args)
	{
		double num1, num2;
		int opcion;
	
		// Calculadora2 c = new Calculadora2 (3, 4,'*');
		Calculadora2 calc = new Calculadora2 ();
		Scanner sc = new Scanner(System.in);
		do {
			pintaMenu();
			opcion = sc.nextInt();
			while (opcion < 1 || opcion > 5) {
				System.out.print("Mal, repite: ");
				opcion = sc.nextInt();
			}
			if (opcion != 5) {
				System.out.print("Dame el primer operando: "); 
				num1 = sc.nextDouble();
				calc.setNum1(num1);
				System.out.print("Dame el segundo operando: "); 
				num2 = sc.nextDouble();
				calc.setNum2(num2);
				switch (opcion) {
					case 1:
						calc.setOperador('+');
						break;
					case 2:
						calc.setOperador('-');
						break;
					case 3:
						calc.setOperador('*');
						break;
					default:
						calc.setOperador('/');
				}
				System.out.println(calc.getResultado());
			}
		} 
	 	while (opcion != 5);
		System.out.println("Tay tay!");
	}
	
}
