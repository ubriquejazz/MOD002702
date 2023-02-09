/**
    File: factorial.java
    Date: 202205 (sesion 14)
    Author: 
 */
import java.util.Scanner;

public class factorial {
 
    public static void main(String[] args) {

        // Constantes


        // Variables de entrada
        int num;
        int factorial = 1;
        
        // Variables de salida

                
        // Variables auxiliares

        
        // Clase Scanner para peticin de datos de entrada
        Scanner teclado= new Scanner (System.in);
        System.out.println("Dame el termino para calcular su factorial: ");
        num = teclado.nextInt();
        while(num<=0){
            System.out.println("Error, repite: ");
            num = teclado.nextInt();
        }
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        for(int i=1; i<=num;i++){
            factorial = factorial*i;    
        }
        
        System.out.println("El factorial de " +
                num + " es igual a " + factorial);
    }    
}
