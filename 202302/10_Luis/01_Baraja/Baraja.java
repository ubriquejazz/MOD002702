
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baraja {
    private List<Carta> cartas;
    private int cartaActual;

    public Baraja() {
        cartas = new ArrayList<Carta>();
        String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
        String[] nombres = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Sota", "Caballo", "Rey"};
        double[] valores = {1, 2, 3, 4, 5, 6, 7, 0.5, 0.5, 0.5};

        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < nombres.length; j++) {
                Carta carta = new Carta(palos[i], nombres[j], valores[j]);
                cartas.add(carta);
            }
        }

        cartaActual = 0;
    }

    public void barajar() {
        Collections.shuffle(cartas);
        cartaActual = 0;
    }

    public Carta tomarCarta() {
        if (cartaActual >= cartas.size()) {
            return null;
        }

        Carta carta = cartas.get(cartaActual);
        cartaActual++;
        return carta;
    }
}
