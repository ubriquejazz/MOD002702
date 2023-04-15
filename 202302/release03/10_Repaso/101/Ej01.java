import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * leeLista que va leyendo enteros que se encuentran en un fichero
 * desde el teclado y los va metiendo en una lista
 * El nombre del fichero se pasa como argumento en la línea de comandos.
 * 
 */
public class Ej01 {

    private static ArrayList<Double> l = new ArrayList<>();

    public static void help() {
		System.out.println("Lee numeros y los va metiendo en una lista");
		System.out.println("Uso del programa: leeLista FICHERO");
		System.exit(-1); // sale del programa
	}

    // va metiendo datos en la lista l
    public static void leeLista(double value) {
        l.add(value);
    }

    // pinta l
    public static void pintaLista() {
        System.out.println(l);
    }

    public static void main(String[] args) {
        if (args.length != 1) help();
        
        try {		
			BufferedReader bf = new BufferedReader(new FileReader(args[0]));			
			String linea = "0";			
			while (linea != null) {
				leeLista(Double.parseDouble(linea));
				linea = bf.readLine();					
			}
			bf.close();
            pintaLista();
            System.out.println("Done!"); 
		} 
        catch (IOException e) {
			System.out.println(e.getMessage());
		}
    }
}