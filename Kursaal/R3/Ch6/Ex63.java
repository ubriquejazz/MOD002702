public class Ex63 {
    
    public static double miPow(double base, int exponente) {
        return Math.pow(base, exponente);
    }

    public static double miPow2(double base, int exponente) {
        double prod = 1.0;
        if (exponente>=0)
            for (int i=0; i<exponente; i++) {
                prod *= base;
            }        
        else 
            for (int i=exponente; i<0; i++){
                prod /= base;
            }            
        return prod;
    }

    public static int miFact(int n) { 
        if (n == 0)    
          return 1;    
        else    
          return(n * miFact(n-1));    
    }  

    public static double gauss(double x, int n){
        double sum = 0.0; // calculo del sumatorio con un loop
    
        
        for (int i = 0; i < n; i++) {
            double term = Math.pow(-1, i) * Math.pow(x, 2 * i) / miFact(i);
            sum += term;
        }
        return sum;
    }

    public static void main(String args[]) {
        double x = -1.5;
        // "Si es menor que 2 no converge";
        double tmp = -x*x;
        System.out.printf("Para x = " + x + " la solucion es %.2f\n",  Math.exp(tmp));
        for (int n=1; n<200; n++) {
            System.out.printf("Gauss para n=" + n + " devuelve %.2f\n", gauss(x, n));
        }
    }
}
