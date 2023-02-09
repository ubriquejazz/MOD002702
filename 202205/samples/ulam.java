/**
    File: ulam.java
    Date: 202205 (sesion 14)
    Author: 
 */
import java.util.Scanner;

public class ulam {
 
    public static void main(String[] args) {

        // Constantes


        // Variables de entrada
        int num;
        String sucesion="";
        
        // Variables de salida

                
        // Variables auxiliares

        
        // Clase Scanner para peticion de datos de entrada
        Scanner teclado = new Scanner (System.in);
        System.out.println("Dame el primer termino de la sucesion ULAM: ");
        num = teclado.nextInt();
        while(num<=0){
            System.out.println("Error, repite: ");
            num = teclado.nextInt();
        }
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        sucesion = sucesion + num + ", ";
        
        while(num != 1) {
        	if(num%2 == 0)
        		num = num/2;
        	else
        		num = num * 3 + 1;
        	if(num!=1)
        		sucesion = sucesion + num + ", ";
        	else
        		sucesion = sucesion + num + ".";
        }
        System.out.println(sucesion);
    }    
}
