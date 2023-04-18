import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class Tribunal {

    private ArrayList<Profesor> l = new ArrayList<Profesor>();
    private int tamano;

    public Tribunal(String fichero) {
        BufferedReader br = null;
        String line = "";
        try {
            FileReader fReader = new FileReader(fichero);
            br = new BufferedReader(fReader);
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" - "); 
                int genero = Integer.parseInt(data[2]);
                //System.out.println(data[0] + genero);
                l.add(new Profesor(data[0], data[1], genero));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado " + fichero);
        } catch (IOException e) {
            System.err.println("Error: Fallo de lectura del archivo " + fichero);
        } catch (NumberFormatException e) {
            System.err.println("Error: Archivo CSV mal formateado " + fichero);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Archivo CSV mal formateado " + fichero);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Error: Fallo al cerrar el archivo " + fichero);
                }
            }
        }    
        this.tamano = l.size();    
    }

    public int getTamano() {
        return tamano;
    }

    public String toString() {
        String s = "";
        for (Profesor a : l) {
            s += a.toString() + "\n";
        }
        return s;
    }

    // hace el sorteo del tribunal de entre los profesores que hay en la lista
    public void EligeTribunalSinGenero() {
        // Random sc = new Random(tamano);
        int presi = (int)(Math.random()*tamano + 1); 
        System.out.println(l.get(presi));
        int vocal = presi%tamano + 1;
        System.out.println(l.get(vocal));        
    }

    public void EligeTribunalConGenero() {
        int genero_vocal = 1;
        int presi, vocal;
        
        presi = (int)(Math.random()*tamano); 
        System.out.println(l.get(presi));

        // actualiza genero del vocal
        if (l.get(presi).getGenero() == 1) {
            genero_vocal = 0;
        }
        
        // indice del vocal
        vocal = (presi + 1) %tamano;
        while (l.get(vocal).getGenero() != genero_vocal) {
            vocal = (vocal + 1) %tamano; 
            // System.out.println(vocal);
        }
        System.out.println(l.get(vocal));
    }
    
    private boolean existe(int historia[], int nuevo) {
        boolean retVal = false;
        for (int i=0; i<historia.length; i++) {
            if (historia[i] == nuevo)
                retVal = true;
        }
        return retVal;
    }

    public void EligeTribunal() {
        // Contadores para hombres y mujeres seleccionados
        int maleCnt = 0;
        int femesCnt = 0;

        // Profesor seleccionado
        int aleatorio;
        Profesor profeSeleccionado;

        // Arraylist para almacenar los profes seleccionadas
        ArrayList<Profesor> seleccionadas = new ArrayList<>();

        // contador de coincidencias
        int historia[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int cnt = 0; 

        // Generador de números aleatorios
        Random random = new Random();

        // Iterar sobre el ArrayList de personas hasta seleccionar 2 hombres y 2 mujeres
        while (maleCnt < 2 || femesCnt < 2) {
            do {
                aleatorio = random.nextInt(tamano);
            } while (existe(historia, aleatorio));
            historia[cnt++]=aleatorio;
            profeSeleccionado = l.get(aleatorio);
            if (profeSeleccionado.getGenero() == 1 && maleCnt < 2) {
                seleccionadas.add(profeSeleccionado);
                maleCnt++;
            }
            else if (profeSeleccionado.getGenero() == 0 && femesCnt < 2) {
                seleccionadas.add(profeSeleccionado);
                femesCnt++;
            }
        }
        System.out.println(seleccionadas);
    }

}