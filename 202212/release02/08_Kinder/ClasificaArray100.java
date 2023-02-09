// Escribe una función que recibe un array que contiene 20 enteros aleatorios entre 1 y 100. 
// La función escribirá por pantalla cuántos elementos se encuentran entre el 1 y el 10, entre el 11 y el 20, etc.

import java.util.Arrays;

public class ClasificaArray100 {

    static int[] clasifica(int[] arr) {  
        int[] cont = new int[10];   // cont[0] entre el 1 y el 10
                                    // cont[1] entre el 10 y el 20
        for (int j=0; j < cont.length; j++) {
            cont[j] = 0;
        }
        for (int i=0; i < arr.length; i++) {
            int sample = arr[i];
            if (sample < 10) cont[0]++;
            else if (sample < 20) cont[1]++;
            else if (sample < 30) cont[2]++;
            else if (sample < 40) cont[3]++;
            else if (sample < 50) cont[4]++;
            else if (sample < 60) cont[5]++;
            else if (sample < 70) cont[6]++;
            else if (sample < 80) cont[7]++;
            else if (sample < 90) cont[8]++;
            else cont[9]++;
        }
        return cont;
    }

    public static void main(String[] args) {
        int[] n = new int[20];
        int i;
        for (i = 0; i < 20; i++) {
            n[i] = (int)(Math.random() * 101);
        }
        // first order using bubble algorithm
        Bubble.bubbleSort(n);
        System.out.println(Arrays.toString(n));
        System.out.println(Arrays.toString(clasifica(n)));
    }
}