import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

class miCat {

    public static void main(String[] args) {
        BufferedReader bf;
        if (args.length != 1) {
            System.out.println("Usage: java miCat.java <file>");
            return;
        }
        String filename = args[0];
        try {
            bf = new BufferedReader(new FileReader(filename));
            String linea="";
            while (linea!=null) {
                System.out.println(linea);
                linea = bf.readLine();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error en " + filename);
        }
        catch (IOException a) {
            System.out.println("Otro error");
        }
    }
}