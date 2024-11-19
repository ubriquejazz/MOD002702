/**
    File: dias.java
    Date: 202205 (sesion 14)
    Author: 
 */
import java.util.Scanner;

public class DiaSemana {
    
    public static void main(String[] args) {

        // Constantes

        
        // Variables de entrada
        int num;
        String dia;
        
        // Variables de salida

        
        // Variables auxiliares

        
        // Clase Scanner para petici�n de datos de entrada
        Scanner sc= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.print("Dame un numero entre 1 y 7: ");
        num = sc.nextInt();
        
        while(num<1 || num>7){
            System.out.print("Error, repite: ");
            num = sc.nextInt();
        }

        switch(num){
            case 1:
                dia = "Lunes";
                break;
            case 2:
                dia = "Martes";
                break;
            case 3:
                dia = "Miercoles";
                break;
            case 4:
                dia = "Jueves";
                break;
            case 5: 
                dia = "Viernes";
                break;
            case 6:
                dia = "Sabado";
                break;
            default:
                dia = "Domingo";
        }
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("El dia asociado al numero " + num + " es el " + dia);
    }    
}
