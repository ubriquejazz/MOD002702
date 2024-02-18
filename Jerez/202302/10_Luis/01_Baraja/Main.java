
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double puntosJugador = 0;
        double puntosCasa = 0;
        
        Carta as = new Carta("Oros", "As",0);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al juego del 7 y medio!");
        System.out.println("Tu primera carta es:");
        System.out.println(as);
        
    }
}