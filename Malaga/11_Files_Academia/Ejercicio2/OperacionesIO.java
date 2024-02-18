import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OperacionesIO{

    /**
     * Ruta del archivo donde se lee y escribe la colección de objetos ChipBici
     */
    private String rutaArchivo;

    /**
     * Método constructor
     * @param archivo Ruta del archivo donde se lee y escribe la colección de objetos ChipBici
     */
    public OperacionesIO(String archivo) {
        this.rutaArchivo = archivo;
    }
 
    /**
     * Método que lee, desde un archivo binario, una colección de objetos ChipBici serializados.
     * @return Lista de objetos ChipBici que estaba almacenada en el archivo binario.
     */
    public List leer() {
        List listado = null;
        try ( ObjectInputStream oisLista = new ObjectInputStream(new FileInputStream(rutaArchivo));) {

            listado = (List<Alumno>) oisLista.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo " + rutaArchivo + "·no encontrado.");
        } catch (IOException e) {
            System.out.println("Error: fallo en el acceso al archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: el contenido del archivo no se corresponde con lo que esperaba.");
        } catch (ClassCastException e) {
            System.out.println("Error: el archivo no contiene una lista de productos.");
        }
        return listado;
    }

    /**
     * Método que escribe, en un archivo binario, una colección de objetos ChipBici serializables.
     * @param bicis Lista de objetos ChipBici serializables para almacenar en el archivo binario.
     */
    public void escribir(List listado) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));) {
            
            oos.writeObject(listado);

        }catch (IOException e) {
            System.out.println("Error: fallo en el acceso al archivo: " + e.getMessage());
        }
    }

}
