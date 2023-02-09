/**
    File: calculadora.java
    Date: 202205 (sesion 14)
    Author: 
 */
import java.util.Scanner;

class Calculadora {
  	
    /**
     * Metodo que suma dos numeros
     */
    public static double sumar(double num1,double num2) {
        return num1+num2;
    }

    /**
     * Metodo que resta dos numeros
     */
    public static double restar(double num1,double num2) {
        return num1-num2;
    }

    /**
     * Metodo que multiplica dos numeros
     */
    public static double multiplicar(double num1,double num2) {
        return num1*num2;
    }

    /**
     * Metodo que divide dos numeros
     */
    public static double dividir(double num1,double num2) {
        if (num2 == 0) {
            return -1;
        } else {
            return num1/num2;
        }
    }


  public static void pintaMenu() {
    System.out.println("PRUEBA DE IMPLEMENTACION DE UNA CALCULADORA");
    System.out.println("Pulse 1 si quiere hacer una suma");
    System.out.println("Pulse 2 si quiere hacer una resta");
    System.out.println("Pulse 3 si quiere hacer una multipl");
    System.out.println("Pulse 4 si quiere hacer una division");
    System.out.println("Pulse 5 para salir");
    System.out.print("Introduzca opcion: ");
  }
  
  public static void main(java.lang.String[] args) 
  {
    double num1, num2,result;
    char operacion = ' ';
    String resultado;
    int opcion;

    Calculadora calc = new Calculadora();
    Scanner sc = new Scanner(System.in);
    
    do {
      pintaMenu();
      opcion = sc.nextInt();
      while (opcion < 1 || opcion > 5) {
          System.out.print("Mal, repite: ");
          opcion = sc.nextInt();
      }
      if (opcion != 5) {
          System.out.print("Dame el primer operando: "); num1 = sc.nextDouble();
          System.out.print("Dame el segundo operando: "); num2 = sc.nextDouble();
          switch (opcion) {
              case 1:
                  operacion = '+';
                  result=calc.sumar(num1,num2);
                  break;
              case 2:
                  operacion = '-';
                  result=calc.restar(num1,num2);
                  break;
              case 3:
                  operacion = '*';
                  result=calc.multiplicar(num1,num2);
                  break;
              default:
                  operacion = '/';
                  result = calc.dividir(num1,num2);
          }      
          resultado = num1 + " "+operacion+" "+num2+" = "+result;
          System.out.println(resultado+"\n\n");
      } 
    } while (opcion != 5);
    System.out.println("Tay tay!");
  }
}
