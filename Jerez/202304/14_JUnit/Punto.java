public class Punto {

    private double x;
    private double y;

    public Punto (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }

    public double distancia(Punto p){
        double diffx = p.x - this.x;
        double diffy = p.y - this.y
        return Math.sqrt( Math.pow(diffx, 2) + Math.pow(diffy, 2) );
    }

    public boolean compara(Punto p) {
        if (p.x == x && p.y == y)
            return true;
        else   
            return false;
    }
}
