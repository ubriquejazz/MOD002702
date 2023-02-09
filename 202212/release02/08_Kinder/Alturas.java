public class Alturas {

    public static void main(String[] args) {
        String[] pais = {"C.Rica", "Francia", "Japon", "Noruega"};
        int[][] estaturas = new int[4][10];

        // Generar el array
        for (int i=0; i<4; i++) {
            for (int j=0; j<10; j++) {
                estaturas[i][j] = (int) (Math.random() * (210 - 140 + 1)) + 140;
            }
        }
        System.out.printf("%61s\n", "MED MIN MAX");

        // Calculo de la media, min y max
        for (int i=0; i<4; i++) {
            System.out.printf("%9s", pais[i]);
            int max, min, suma;
            max = 140;
            min = 210;
            suma = 0;
            for (int estatura : estaturas[i])    // for (int j=0; j<10; j++) 
            {
                System.out.printf("%4d", estatura);
                // max = estatura > max ? estatura : max;
                // min = estatura < min ? estatura : min;
                if (estatura>max) max = estatura;
                if (estatura<min) min = estatura;
                suma += estatura;
            }
            System.out.printf("%4d%4d%4d\n", suma/10, min, max);
        }

    }
}