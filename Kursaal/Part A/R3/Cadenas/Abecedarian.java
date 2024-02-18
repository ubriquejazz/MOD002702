public class Abecedarian {
    public static void main(String[] args) {
        String word1 = "abdest";
        String word2 = "acorsy";
        String word3 = "hello";

        System.out.println(word1 + " is abecedarian: " + isAbecedarian(word1));
        System.out.println(word2 + " is abecedarian: " + isAbecedarian(word2));
        System.out.println(word3 + " is abecedarian: " + isAbecedarian(word3));
    }

    public static boolean isAbecedarian(String word) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) > word.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
