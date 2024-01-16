import java.util.Arrays;

public class Ex2 {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(args));
        String hola = args[1];
        String que = args[0];
        int result = Integer.parseInt(que) * Integer.parseInt(hola);
        System.out.println("resultado es " + result);
    }

}