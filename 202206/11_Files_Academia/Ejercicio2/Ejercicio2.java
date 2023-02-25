import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Programa para trabajar con archivos binarios y objetos serializables.
 * @profesorado
 */
public class Ejercicio2 {
    
    /**
    * Método principal.
    */
    public static void main(String args[]){
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes

        // Variables de entrada
        //String ruta = System.getProperty("user.dir") + "/recursos/BDBicis.dat";
        String ruta = "BDAlumnos.dat";
        List<Alumno> misAlumnos=null;
        OperacionesIO bd = null;
        List alumnosBD = null;
        
        // Variables de salida

        // Variables auxiliares
        
        //----------------------------------------------
        // Entrada de datos + Procesamiento + Salida 
        //----------------------------------------------
        misAlumnos = new ArrayList<>();
        misAlumnos.add(new Alumno("Fran","Martínez",40));
        misAlumnos.add(new Alumno("Paco","de Haro",45));
        misAlumnos.add(new Alumno("Luismi", "Morales",33));
        
        bd = new OperacionesIO(ruta);
        
        System.out.printf("He creado y almaceno en el archivo %d alumnos.\n",misAlumnos.size());
        System.out.println("LISTADO DE ALUMNOS GUARDADOS EN FICHERO:");
        System.out.println(misAlumnos.toString());
        
        bd.escribir(misAlumnos);
          
        misAlumnos.add(new Alumno("Ángel", "Valverde",35));
        misAlumnos.add(new Alumno("Mila", "Pérez",37));
        
        System.out.printf("Ahora inserto 2 alumnos más. Tengo ahora %d alumnos.\n",misAlumnos.size());
        System.out.println("LISTADO DE ALUMNOS GUARDADOS EN EL ARRAYLIST:");
        System.out.println(misAlumnos.toString());
        
        alumnosBD = bd.leer();
        System.out.printf("Leo del archivo %d alumnos.\n",alumnosBD.size());
        System.out.println("LISTADO DE ALUMNOS GUARDADOS EN FICHERO:");
        System.out.println(alumnosBD.toString());      
    }
}
