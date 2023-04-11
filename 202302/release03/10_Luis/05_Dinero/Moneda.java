public class Moneda {
    private TipoMoneda tMoneda;
    private int decimales;
    private String simbolo;
    private String codigo;
    private double cambioEuro;

    Moneda(TipoMoneda tMoneda, int num, String simbolo, String codigo, double cambio) {
        this.tMoneda = tMoneda;
        this.codigo = codigo;
        if (this.simbolo!="")
            this.simbolo = simbolo;
        else {
            this.simbolo = "£";
            System.out.println("Simbolo por defecto");
        }
        if ((num >0) && (num <5))
            this.decimales = num;
        else {
            this.decimales = 2;
            System.out.println("Numero de decimales por defecto");
        }
        if (cambio > 0)
            this.cambioEuro = cambio;
        else {
            this.cambioEuro = 1.0;
            System.out.println("Cambio a euro por defecto");
        }
    }

    public double getCambioEuro() {
        return cambioEuro;
    }

    public void setCambioEuro(double cambio) {
        if (cambio > 0)
            this.cambioEuro = cambio;
        else {
            this.cambioEuro = 1.0;
            System.out.println("Cambio a euro por defecto");
        }
    }

    public TipoMoneda gettMoneda() {
        return tMoneda;
    }

    public int getDecimales() {
        return decimales;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() { return "1"+simbolo+" = "+cambioEuro+"€";}
}