import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Grupo {

    private ArrayList<Alumno> lista;

    // Constructor vacío
    public Grupo() {
        lista = new ArrayList<Alumno>();
    }

    // Método para insertar un nuevo alumno a la lista
    public void insertaAlumno(Alumno a) {
        lista.add(a);
    }

    // Método para insertar un nuevo alumno a la lista pasando los datos por parámetro
    public void insertaAlumno(String nombre, int edad, double calificacion) {
        Alumno a = new Alumno(nombre, edad, calificacion);
        insertaAlumno(a);
    }

    // Método para obtener una representación en String del grupo
    public String toString() {
        String s = "";
        for (Alumno a : lista) {
            s += a.toString() + "\n";
        }
        return s;
    }

    // Método para escribir los datos del grupo en un archivo CSV
    public void escribeFicheroCSV(String fichero) {
        try {
            FileWriter fWriter = new FileWriter(fichero);
            PrintWriter pw = new PrintWriter(fWriter);
            for (Alumno a : lista) {
                pw.println(a.getNombre() + "," + a.getEdad() + "," + a.getCalificacion());
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo CSV.");
        }
    }

    // Método para leer los datos del grupo desde un archivo CSV
    public void leeFicheroCSV(String fichero) {
        BufferedReader br = null;
        String line = "";
        try {
            FileReader fReader = new FileReader(fichero);
            br = new BufferedReader(fReader);
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); 
                int edad = Integer.parseInt(data[1]);
                double nota = Double.parseDouble(data[2]);
                insertaAlumno(data[0], edad, nota);
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

}
