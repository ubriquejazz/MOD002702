import java.util.Arrays;

public class Ex64 {

    public static boolean isDouble(String s) {
        boolean retVal = false;
        char c;
        int repes[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i=0; i<s.length()-1; i++) {
            c = s.charAt(i);
            repes[i] = s.indexOf(c, i+1);
        }
        System.out.println(Arrays.toString(repes));
        return retVal;
    }

    public static void main(String[] args) {
        String str = "murmur";
        if (isDouble(str.toLowerCase()))
            System.out.println(str + " is a doublon");
        else
            System.out.println(str + " is not a doublon");
    }
}