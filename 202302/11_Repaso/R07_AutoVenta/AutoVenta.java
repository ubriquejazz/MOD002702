import java.time.LocalDate;
import java.io.*;
import java.util.ArrayList;

public class AutoVenta {

    private ArrayList<Coche> l = null;

    public AutoVenta(String fichero) {
        l = new ArrayList<Coche>();
        leeCSV(fichero);
    }

    public void insertaCoche(Coche nuevo) {
        boolean found = false;
        for (Coche c : l) {
            if (c.equals(nuevo)) {
                found = true;
                System.out.println(nuevo + " already exists!");
            }
        }
        if (!found) 
            l.add(nuevo);
    }

    public void insertaCoche(String matricula, String marca, String modelo, LocalDate fMatricula, double precio) {
        Coche miCoche = new Coche(matricula, marca, modelo, fMatricula, precio); 
        if (miCoche.getMatricula().equals("invalid") == false)
            insertaCoche(miCoche);
    }

    Coche buscaCoche(String matricula) {
        Coche miCoche = null;
        for (Coche c : l) {
            if (matricula.equals(c.getMatricula()) == true) {
                miCoche = c;
            }
        }
        return miCoche;
    }

    // carga la lista desde un fichero CSV 
    public void leeCSV(String fichero){
        BufferedReader br = null;
        String line = "";
        try {
            FileReader fReader = new FileReader(fichero);
            br = new BufferedReader(fReader);
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String[] data = line.split(","); 
                LocalDate fMatricula = LocalDate.parse(data[3]);
                double precio = Double.parseDouble(data[4]);
                insertaCoche(data[0], data[1], data[2], fMatricula, precio);
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

    public void guardaCSV(String fichero) {
        try {
            FileWriter fWriter = new FileWriter(fichero);
            PrintWriter pw = new PrintWriter(fWriter);
            for (Coche c : l) {
                pw.println( c.getMatricula() + "," +
                            c.getMarca() + "," + 
                            c.getModelo() + "," + 
                            c.getFecha() + "," + 
                            c.getPrecio());
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo CSV.");
        }
    }
    public String toString() {
        String s="";
        for (Coche c : l) {
            s+=c.toString() + "\n";
        }
        return s;
    }

    public void imprimeListado() {
        System.out.println("fecha\t modelo \t precio");
        System.out.println(this.toString());
    }

}