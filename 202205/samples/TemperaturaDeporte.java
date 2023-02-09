/**
    File: temperatura.java
    Date: 202205 (sesion 14)
    Author: 
 */
import java.util.Scanner;
import java.io.*;

public class TemperaturaDeporte {
    
    // Definition del enum

    
    // Programa principal
    public static void main(String[] args) {
             
        double temp;
        String deporte="";
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Dime la temperatura (entre -10 y 40C): ");
        temp = sc.nextInt();
        
        while(temp<-10 || temp>40){
            System.out.print("Error, repite: ");
            temp = sc.nextInt();
        }
        
        if(temp<=0)
            deporte = "Esqui";
        else{
            if(temp<=10)
                deporte = "Atletismo";
            else{ 
                if(temp<=20)
                    deporte = "Futbol";
                else{
                    if(temp<=30)
                        deporte = "Balonmano";
                    else
                        deporte = "B�dminton";
                }
            }
        }
        System.out.println("El deporte asociado a la temperatura de "+temp+"C es "+deporte);
    }    
}
