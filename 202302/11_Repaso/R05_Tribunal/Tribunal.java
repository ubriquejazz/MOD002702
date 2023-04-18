import java.io.*;
import java.util.ArrayList;

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

    public void EligeTribunal() {
        int genero_vocal = 1;
        int vocal;
        int presi = (int)(Math.random()*tamano + 1); 
        System.out.println(l.get(presi));
        if (l.get(presi).getGenero() == 1) {
            genero_vocal = 0;
        }
        int vocal = (presi + 1) %tamano;
        while (l.get(vocal).getGenero() != genero_vocal) {
            vocal = presi%tamano + 1;
        }
        System.out.println(l.get(vocal));
    }

}