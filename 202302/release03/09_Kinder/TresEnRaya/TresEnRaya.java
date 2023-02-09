public class TresEnRaya {

    // constantes
    static final String nombreFila = "cba";
    static final String jugadores =" XO";

    // casilla tendrá un valor de 0 si no hay nada, 1 si
    // hay una X (jugador 1) y 2 si hay una O (jugador 2)
    private int[][] tablero = new int[3][3];
    private int movimientos = 0;

    public TresEnRaya() {
        iniciaTablero();
        dibujaTablero();
    }

    public void iniciaTablero() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                tablero[i][j] = 0;
            }
        }
        this.movimientos = 0;
    }

    public void dibujaTablero() {
        int i, j;
        System.out.println("  ---------------");
        for(i = 0; i < 3; i++) {
            System.out.print(nombreFila.charAt(i)+ " |");
            for(j = 0; j < 3; j++) {
                System.out.print("| " + jugadores.charAt(tablero[i][j]) + " ");
            }
            System.out.println("||");
            System.out.println("  ---------------");
        }
        System.out.println("     1   2   3\n");
    }        

    // pondrá una X en esa posición si es posible.
    public void mueveJugador1(int fila, int columna) {
        tablero[fila][columna] = 1;
        this.movimientos++;
    }

    // pondrá una O en esa posición si es posible.
    public void mueveJugador2(int fila, int columna) {
        tablero[fila][columna] = 2;
        this.movimientos++;
    }

    public void mueveOrdenador(int jugador) {
        int[] coord = new int[2];
        do {
          coord[0] = (int)(Math.random() * 3);
          coord[1] = (int)(Math.random() * 3);
        } while (this.movimientoValido(coord[0], coord[1]) == false);
        tablero[coord[0]] [coord[1]] = jugador;
        movimientos++;        
    }    

    public void mueveOrdenador1() {
        mueveOrdenador(1);
    }
    
    public void mueveOrdenador2() {
        mueveOrdenador(2);
    }

    // devolverá true si el movimiento es válido y false si 
    // no se puede realizar (la casilla ya está ocupada).
    public boolean movimientoValido(int fila, int columna) {
        boolean retVal = true;
        if (tablero[fila][columna] != 0) 
            retVal = false;
        return retVal;
    }

    // dice si todavía quedan casillas libres para seguir jugando
    public boolean quedanMovimientos() {
        if (this.movimientos < 9)
            return true;
        return false;
    }

    private boolean ganaJugador(int jugador) {
        boolean jugadorGana = (
        (tablero[0][0] == jugador) && (tablero[0][1] == jugador) && (tablero[0][2] == jugador) ||
        (tablero[1][0] == jugador) && (tablero[1][1] == jugador) && (tablero[1][2] == jugador) ||
        (tablero[2][0] == jugador) && (tablero[2][1] == jugador) && (tablero[2][2] == jugador) ||
        (tablero[0][0] == jugador) && (tablero[1][0] == jugador) && (tablero[2][0] == jugador) ||
        (tablero[0][1] == jugador) && (tablero[1][1] == jugador) && (tablero[2][1] == jugador) ||
        (tablero[0][2] == jugador) && (tablero[1][2] == jugador) && (tablero[2][2] == jugador) ||
        (tablero[0][0] == jugador) && (tablero[1][1] == jugador) && (tablero[2][2] == jugador) ||
        (tablero[0][2] == jugador) && (tablero[1][1] == jugador) && (tablero[2][0] == jugador)
      );
      return jugadorGana;
    }

    // nos devuelve true si hay tres X en línea
    public boolean ganaJugador1() {        
        return ganaJugador(1);
    }

    // nos devuelve true si hay tres O en línea
    public boolean ganaJugador2() {
        return ganaJugador(2);
    }

}