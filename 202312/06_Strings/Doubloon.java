public class Doubloon {

    public static boolean isDoubloon(String s) {
        boolean retVal = false;
        int len = s.length();
        int count = 0;
        for (int i=0; i<len; i++) {
            char c = s.charAt(i);
            int j = s.indexOf(c, i+1);
            if (j>0) count++;
            System.out.println(j + " - " + c);
        }
        if (count == len/2) retVal = true;
        return retVal;
    }

    public static void main(String[] args) {
        String str = "Shanghaiings";
        if (str.length() % 2 != 0)
            System.out.println("The length should be even");
        else if (isDoubloon(str.toLowerCase()))
            System.out.println(str + " is a doublon");
        else
            System.out.println(str + " is not a doublon");
    }
}