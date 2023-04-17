import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creamos un ArrayList para almacenar los datos de los estudiantes
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        // Leemos los datos del fichero CSV y los almacenamos en el ArrayList
        try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] fila = linea.split(",");
                String nombre = fila[0];
                int eval1 = Integer.parseInt(fila[1]);
                int eval2 = Integer.parseInt(fila[2]);
                Estudiante estudiante = new Estudiante(nombre, eval1, eval2);
                estudiantes.add(estudiante);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Hacemos algún procesamiento con los datos de los estudiantes
        // ...

        // Escribimos los datos procesados en un nuevo fichero CSV
        try (FileWriter fw = new FileWriter("datos_procesados.csv")) {
            for (Estudiante stdent : estudiantes) {
                float media = stdent.getEvaluacion1() + stdent.getEvaluacion2();
                String linea = stdent.getNombre() + "," + media/2;
                fw.write(linea + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

