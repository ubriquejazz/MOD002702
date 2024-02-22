/*
 * The goal of this exercise is to implement the sorting algorithms 
 * from this chapter. 
 */
public class Ex3 {

    public static void main(String[] args) {
        Deck d1 = new Deck();
        d1.shuffle();
        System.out.println(d1);

        d1.selectionSort();
        System.out.println(d1);
    }
    
}
