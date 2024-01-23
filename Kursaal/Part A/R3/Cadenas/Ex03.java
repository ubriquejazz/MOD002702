public class Ex03 {

    public static boolean esPalindromo(String s) {
        int l = s.length();
        char left, right;
        for (int i=0; i<l/2; i++) {
            left = s.charAt(i);
            right = s.charAt(l-1-i);
            if (left != right) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String myString = "A nut for a jar of tuna";
        System.out.println(myString + " is ");
    }    
}
