public class Rational {

    private int num;
    private int den;
    private double result;

    public double getResult() {
        return this.result;
    }
    
    Rational() {
        this.num = 10;
        this.den = 20;
        this.result = toDouble();
    }

    Rational(int a, int b) {
        this.num = a;
        this.den = b;
    }

    public String toString() {
        return this.num + "/" + this.den;
    }

    public double toDouble() {
        return this.num / (double)this.den;
    }

    // modifier
    public void negate() {
        this.num = -this.num;
    }
    // modifier
    public void reverse() {
        int tmp = this.num;
        this.num = this.den;
        this.den = tmp;
    }

    public Rational reduce() {
        int gcd = 10;
        Rational aux = new Rational(this.num/gcd, this.den/gcd);
        return aux;
    }
}
