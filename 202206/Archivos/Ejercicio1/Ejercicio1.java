import java.io.*;

/**
 * Programa para trabajar con archivos de texto.
 * @profesorado
 */
public class Ejercicio1 {
    
    /**
    * Método principal.
    */
    public static void main(String args[]){

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes

        // Variables de entrada
        //String rutaCoeficientres = System.getProperty("user.dir") + "/recursos/coeficientes.txt";
		String rutaCoeficientes = "coeficientes.txt";
        File fCoef = new File(rutaCoeficientes);
        //String rutaListado = System.getProperty("user.dir") + "/recursos/listadoAlumnos.txt";
		String rutaListado = "listadoAlumnos.txt";
        File fListado = new File(rutaListado);
        
        // Variables de salida
        //String rutaActa = System.getProperty("user.dir") + "/recursos/acta.txt";
		String rutaActa = "acta.txt";
        File fActa = new File(rutaActa);

        // Variables auxiliares
        String cadena, nombre, dni, notaActa;
        double coefTeoria=0, coefPractica=0,aprobado=0,notable=0,sobresaliente=0, notaTeoria, notaPractica, notaFinal;
        String[] cadenaSeparada;
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Abriendo el archivo "+fCoef.getName());
        try ( 
            BufferedReader brCoef = new BufferedReader(new FileReader(fCoef));){
            cadena = brCoef.readLine();
            System.out.println("Leyendo el archivo "+fCoef.getName());
            cadenaSeparada = cadena.split(";");
            coefTeoria=Double.parseDouble(cadenaSeparada[0]);
            coefPractica=Double.parseDouble(cadenaSeparada[1]);
            aprobado=Double.parseDouble(cadenaSeparada[2]);
            notable=Double.parseDouble(cadenaSeparada[3]);
            sobresaliente=Double.parseDouble(cadenaSeparada[4]);
        }catch (FileNotFoundException e) {
            System.out.println("Error: archivo " + rutaCoeficientes + " no encontrado.");
        } catch(IOException e){
            System.err.printf("Error de entrada/salida: %s\n",e.getMessage());
        }
        System.out.println("Cerrando el archivo "+fCoef.getName());

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        System.out.println("Abriendo los archivos "+fListado.getName()+" y "+fActa.getName());
        try ( 
            BufferedReader brListado = new BufferedReader(new FileReader(fListado));
            PrintWriter pwActa = new PrintWriter(new FileWriter(fActa));){
            pwActa.printf(" %-30s \t %-10s \t %-10s \t %-10s \t %-10s\t %-10s\n","Nombre y apellidos","DNI","Nota teoría","Nota práct.","Nota final","Nota acta");
            
            while((cadena = brListado.readLine()) != null){
                cadenaSeparada = cadena.split(";");
                nombre = cadenaSeparada[0];
                dni = cadenaSeparada[1];
                notaTeoria = Double.parseDouble(cadenaSeparada[2]);
                notaPractica = Double.parseDouble(cadenaSeparada[3]);
                notaFinal = calcularNotaFinal(notaTeoria,notaPractica,coefTeoria, coefPractica);
                notaActa=calcularNotaActa(notaFinal,aprobado,notable,sobresaliente);
                pwActa.printf(" %-30s \t %-10s \t %-10.2f \t %-10.2f \t %-10.2f\t %-10s\n",nombre,dni,notaTeoria,notaPractica,notaFinal,notaActa);
            }
            
        }catch (FileNotFoundException e) {
            System.out.println("Error: archivo " + rutaListado + "·no encontrado.");
        } catch(IOException e){
            System.err.printf("Error de entrada/salida: %s\n",e.getMessage());
        }
        System.out.println("Cerrando los archivos "+fListado.getName()+" y "+fActa.getName());

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
		System.out.println ("Archivos cerrados y procesamento finalizado");
		System.out.println ("---------");
        System.out.println ();
		System.out.println ("Fin del programa.");
    }
    
    /**
     * 
     * @param notaT Nota de teoría que ha obtenido el alumno.
     * @param notaP Nota de las prácicas del alumno.
     * @param cT Coeficiente de lo que puntúa la teoría.
     * @param cP Coeficiente de lo que puntúan las prácticas.
     * @return Nota final del alumno.
     */
    public static double calcularNotaFinal(double notaT, double notaP, double cT, double cP){
        return (notaT*cT)/100 + (notaP*cP)/100;
    }
    
    /**
     * 
     * @param nota Nota final de un alumno.
     * @param aprobado Valor umbral entre el suspenso y el aprobado.
     * @param notable Valor umbral entre el aprobado y el notable.
     * @param sobresaliente Valor umbral entre el notable y el sobresaliente.
     * @return Nota del acta (Suspenso, Aprobado, Notable o Sobresaliente).
     */
    public static String calcularNotaActa(double nota, double aprobado, double notable, double sobresaliente){
        if(nota<aprobado)
            return "Suspenso";
        else if(nota<notable)
            return "Aprobado";
        else if(nota<sobresaliente)
            return "Notable";
        else
            return "Sobresaliente";        
    }
}
