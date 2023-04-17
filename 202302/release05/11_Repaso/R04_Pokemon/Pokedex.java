import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Pokedex {

    private ArrayList<Pokemon> lista;

    // Constructor vacío
    public Pokedex() {
        lista = new ArrayList<Pokemon>();
    }

    public Pokedex(String fichero) {
        lista = new ArrayList<Pokemon>();
        leeCSV(fichero);
    }

    public Pokemon buscaPokemon(int id) {
        Pokemon b = null;
        for (Pokemon a : lista) {
            if (a.getId() == id) {
                b = a;
            }
        }
        return b;
    } 
    public Pokemon buscaPokemon(String nombre) {
        Pokemon b = null;
        for (Pokemon a : lista) {
            if (a.getNombre().equals(nombre)) {
                b = a;
            }
        }
        return b;
    } 

    public int capturaPokemon(String nombre) {
        int retVal = 0;
        for (Pokemon a : lista) {
            if (a.getNombre().equals(nombre)) {
                retVal = a.getId();
                a.setCapturado(true);
            }
        }
        return retVal;
    } 

    // Método para insertar un nuevo Pokemon a la lista
    public void insertaPokemon(Pokemon a) {
        lista.add(a);
    }

    // Método para insertar un nuevo Pokemon a la lista pasando los datos por parámetro
    public void insertaPokemon(int id, String nombre, String tipo1,  String tipo2, 
        int ataque, int ataqueespecial, int defensa, int defensaespecial, 
        int vida, int velocidad, boolean capturado) {
        Pokemon a = new Pokemon(id, nombre, 
                        tipo1, tipo2, 
                        ataque, ataqueespecial, 
                        defensa, defensaespecial, 
                        vida, velocidad, capturado);
        insertaPokemon(a);
    }

    // carga la lista desde un fichero CSV 
    public void leeCSV(String fichero){
        BufferedReader br = null;
        String line = "";
        try {
            FileReader fReader = new FileReader(fichero);
            br = new BufferedReader(fReader);
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); 
                int id = Integer.parseInt(data[0]);
                int num4 = Integer.parseInt(data[4]);
                int num5 = Integer.parseInt(data[5]);
                int num6 = Integer.parseInt(data[6]);
                int num7 = Integer.parseInt(data[7]);
                int num8 = Integer.parseInt(data[8]);
                int num9 = Integer.parseInt(data[9]);
                boolean captured = Boolean.parseBoolean(data[10]);
                insertaPokemon(id, data[1], data[2], data[3], num4, num5, num6, num7, num8, num9, captured);
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
    }
    
    // guarda en un fichero la lista de Pokémon. 
    // será igual que el fichero original, pero cambiará el último campo: capturado o no
    public void guardaCSV(String fichero) {
        try {
            FileWriter fWriter = new FileWriter(fichero);
            PrintWriter pw = new PrintWriter(fWriter);
            for (Pokemon a : lista) {
                pw.println(a.getId() + "," + a.getNombre() + "," + a.getTipo1() + "," + a.getTipo2() + "," + a.getCapturado());
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo CSV.");
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (Pokemon a : lista) {
            s += a.toString() + "\n";
        }
        return s; 
    }

    public String toStringCapturado() {
        String s = "";
        for (Pokemon a : lista) {
            if (a.getCapturado())
                s += a.toString() + "\n";
        }
        return s; 
    }
}