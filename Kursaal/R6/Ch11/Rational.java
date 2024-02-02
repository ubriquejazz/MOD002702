public class Rational {

    private int num;
    private int den;
    
    Rational() {
        this.num = 0;
        this.den = 1;
    }

    public String toString() {
        return this.num + "/" + this.den;
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

}
