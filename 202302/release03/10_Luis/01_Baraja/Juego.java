
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        baraja.barajar();

        double puntosJugador = 0;
        double puntosCasa = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al juego del 7 y medio!");
        System.out.println("Tu primera carta es:");

        Carta carta = baraja.tomarCarta();
        System.out.println(carta);
        puntosJugador += carta.getValor();
        System.out.println("Tienes " + puntosJugador + " puntos");

        while (puntosJugador < 7.5) {
            System.out.println("¿Quieres otra carta? (s/n)");
            String respuesta = scanner.nextLine();

            if (respuesta.equals("s")) {
                carta = baraja.tomarCarta();

                if (carta == null) {
                    System.out.println("No hay más cartas en la baraja");
                    break;
                }

                System.out.println("Tu siguiente carta es: " + carta);

                if (carta.getValor() > 7) {
                    puntosJugador += 0.5;
                } else {
                    puntosJugador += carta.getValor();
                }
    
                System.out.println("Tienes " + puntosJugador + " puntos");
            } else {
                break;
            }
        }
    
        if (puntosJugador > 7.5) {
            System.out.println("Te pasaste de 7 y medio, pierdes");
        } else {
            System.out.println("Turno de la casa:");
    
            while (puntosCasa < 6) {
                carta = baraja.tomarCarta();
    
                if (carta == null) {
                    System.out.println("No hay más cartas en la baraja");
                    break;
                }
    
                System.out.println("La casa toma una carta: " + carta);
    
                if (carta.getValor() > 7) {
                    puntosCasa += 0.5;
                } else {
                    puntosCasa += carta.getValor();
                }
    
                System.out.println("La casa tiene " + puntosCasa + " puntos");
            }
    
            if (puntosCasa > 7.5) {
                System.out.println("La casa se pasó de 7 y medio, ganas");
            } else if (puntosJugador > puntosCasa) {
                System.out.println("Ganaste con " + puntosJugador + " puntos contra los " + puntosCasa + " puntos de la casa");
            } else if (puntosJugador == puntosCasa) {
                System.out.println("Empate con " + puntosJugador + " puntos");
            } else {
                System.out.println("Perdiste con " + puntosJugador + " puntos contra los " + puntosCasa + " puntos de la casa");
            }
        }
    }
}