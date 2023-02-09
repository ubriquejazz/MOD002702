import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Random;
import java.util.Collections;

public class Baraja {

    private ArrayList<Carta> lista = new ArrayList<Carta>();
    private int top; 

    public Baraja() {
        for(int i=0; i<40; i++) {
            lista.add(new Carta(i));
        }
        this.top = 40;
    }
    
    public Baraja(int tipoBaraja, boolean barajar) {
        if (tipoBaraja == 1) {
            this.top = 80;
            for(int i=0; i<80; i++) {
                lista.add(new Carta(i));
            }            
        }
        else {
            this.top = 40;    
            for(int i=0; i<40; i++) {
                lista.add(new Carta(i));
            }            
        }
        if (barajar) 
            this.barajar();
    }

    public void barajar() {

        // Desordeno el indice de 0..40
        Integer[] indicesAux = new Integer[40];
        for(int i=0; i<lista.size(); i++) {
            indicesAux[i] = i;
        }
        Collections.shuffle(Arrays.asList(indicesAux));

        // Creo un array de cartas desordenadas
        ArrayList<Carta> cartasAux = new ArrayList<Carta>();
        for(int i=0; i<lista.size(); i++) {
            cartasAux.add(this.lista.get(indicesAux[i]));
        }

        // lo paso al array original
        for(int i=0; i<lista.size(); i++) {
            this.lista.set(i, cartasAux.get(i));
        }
    }

    public void historia()  {
        for (int i=0; i<lista.size(); i++) {
            Carta aux = this.lista.get(i);
            if (aux.getUsed() == true) {
                // robadas[i] = i;
                System.out.println(aux);
            }
        }
    }

    public boolean vacia() {
        return lista.isEmpty();
    }

    public Carta robar() {
        Carta aux = this.lista.get(--this.top);
        aux.use(); // reference to the list element
        return aux;
    }

}