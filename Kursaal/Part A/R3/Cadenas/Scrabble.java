import java.util.HashMap;
import java.util.Map;

public class Scrabble {

     public static boolean canSpell(String tileSet, String word) {
        Map<Character, Integer> tileCount = new HashMap<>();

        // Count the frequency of each letter in the tile set
        for (char tile : tileSet.toCharArray()) {
            tileCount.put(tile, tileCount.getOrDefault(tile, 0) + 1);
        }

        // Check if the word can be spelled using the available tiles
        for (char letter : word.toCharArray()) {
            if (!tileCount.containsKey(letter) || tileCount.get(letter) == 0) {
                return false;
            } else {
                tileCount.put(letter, tileCount.get(letter) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String tiles = "jxyzuwb";
        String wordToTest = "jib";
        if (canSpell(tiles, wordToTest)) {
            System.out.printf("Yes, \"%s\" can be spelled using the tiles \"%s\".%n", wordToTest, tiles);
        } else {
            System.out.printf("No, \"%s\" cannot be spelled using the tiles \"%s\".%n", wordToTest, tiles);
        }
    }
}
