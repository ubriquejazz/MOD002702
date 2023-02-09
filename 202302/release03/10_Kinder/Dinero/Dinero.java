import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Dinero {
    // Atributos de Clase
    static int cont = 0;
    static ArrayList<Moneda> lista = new ArrayList<Moneda>();

    // Atributos de Objeto
    private double cantidad;
    private TipoMoneda tMoneda;

    public Dinero(double cant, TipoMoneda tMoneda) {
        if (this.cont == 0) {
            lista.add(new Moneda(TipoMoneda.euro, 2, "€", "EUR", 1));
            lista.add(new Moneda(TipoMoneda.pound, 2, "£", "GBP", 1.14));
            lista.add(new Moneda(TipoMoneda.dollar, 2, "$", "USD", 0.98));
        }
        this.cantidad = cant;
        this.tMoneda = tMoneda;
    }

    public void actualizaListaInternet() {
        for (TipoMoneda currency: TipoMoneda.values() ) {
            System.out.println("\t" + currency + " updated!");
        }
    }

    public Moneda buscaMoneda(TipoMoneda t) {
        Moneda aux = null;
        for (int i=0; i< lista.size(); i++) {
            aux = lista.get(i);
            if (aux.gettMoneda().equals(t))
                break;
        }
        return aux;
    }

    public double getCantidad() {
        return cantidad;
    }

    public TipoMoneda gettMoneda() {
        return tMoneda;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void settMoneda(TipoMoneda t) {
        this.tMoneda = t;
    }

    @Override
    public String toString() {
        int decimales = buscaMoneda(this.tMoneda).getDecimales();
        double divisor = Math.pow(10, decimales); // 100
        double redondeo =  Math.round(this.cantidad * divisor);
        return redondeo/divisor + " " + buscaMoneda(this.tMoneda).getCodigo();
    }

    public double valorEn(TipoMoneda t) {
        Moneda nuevaDivisa = buscaMoneda(t);
        double newCantidad = this.cantidad * nuevaDivisa.getCambioEuro();
        int decimales = nuevaDivisa.getDecimales();
        double divisor = Math.pow(10, decimales);
        double redondeo =  Math.round(newCantidad * divisor);
        return redondeo/divisor;
    }

    public Dinero convertirEn(TipoMoneda t) {
        Moneda nuevaDivisa = buscaMoneda(t);
        double newCantidad = this.cantidad * nuevaDivisa.getCambioEuro();
        return new Dinero(newCantidad, t);
    }

    public String toString(TipoMoneda t) {
        return convertirEn(t).toString();
    }

}
