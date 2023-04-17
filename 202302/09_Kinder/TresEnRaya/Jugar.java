import java.util.Scanner;

public class Jugar {

    // constantes
    static final String nombreFila = "cba";

    public static int[] generaCoordenadas(int jugador, TresEnRaya j) {
        int[] coord = new int[2];
        do {
            System.out.print("Jugador " + jugador + " introduce las coordenadas: ");
            String coordenadas = System.console().readLine();
            coord[0] = nombreFila.indexOf(coordenadas.charAt(0));
            coord[1] = coordenadas.charAt(1) - 1 - 48;            
        } while (j.movimientoValido(coord[0], coord[1]) == false); // blocking
        return coord;
    }    

    public static void main(String[] args) {

        TresEnRaya juego = new TresEnRaya();
        Scanner sc = new Scanner(System.in);
        int[] coord = new int[2];
        boolean jugador1Gana = false;
        boolean jugador2Gana = false;        
        System.out.print("Configuracion del juego: ");
        int opcion = sc.nextInt();

        // jugar
        while (juego.quedanMovimientos() == true) {

            if (opcion == 0) {
                juego.mueveOrdenador1();
                if (juego.ganaJugador1() == true) {
                    jugador1Gana = true;
                    break;
                }     
                juego.mueveOrdenador2();
                if (juego.ganaJugador2() == true) {
                    jugador2Gana = true;
                    break;
                } 
            }
            else if (opcion == 1) {
                coord = generaCoordenadas(1, juego);
                juego.mueveJugador1(coord[0], coord[1]);
                if (juego.ganaJugador1() == true) {
                    jugador1Gana = true;
                    break;
                }
                juego.mueveOrdenador2();
                if (juego.ganaJugador2() == true) {
                    jugador2Gana = true;
                    break;
                } 
            }                  
            else if (opcion == 2) {
                coord = generaCoordenadas(1, juego);
                juego.mueveJugador1(coord[0], coord[1]);
                if (juego.ganaJugador1() == true) {
                    jugador1Gana = true;
                    break;
                }
                coord = generaCoordenadas(2, juego);
                juego.mueveJugador2(coord[0], coord[1]);
                if (juego.ganaJugador2() == true) {
                    jugador2Gana = true;
                    break;
                }                
            }
            else {
                System.out.println("Opcion no valida");
            }                
            juego.dibujaTablero();       
        }

        // comprueba
        if (jugador1Gana) {
            System.out.println("Gana el jugador 1.");
        }
        else if (jugador2Gana) {
            System.out.println("Gana el jugador 2.");
        }
        else {
            System.out.println("Empate. No gana nadie.");
        }
        juego.dibujaTablero();
      }
}
