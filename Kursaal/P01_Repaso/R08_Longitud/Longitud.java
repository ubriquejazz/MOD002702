public class Longitud {

    private Unidad unidad;
    private double cantidad;
    final static String[] lString = {"m", "yd", "ft", "in"};

    public Unidad getUnidad() {
        return unidad;
    }
    public double getCantidad() {
        return cantidad;
    }
    public Longitud(Unidad unidad, double cantidad) {
        this.unidad = unidad;
        this.cantidad = cantidad;
    }
    @Override
    public String toString() {
        return cantidad + " " + lString[unidad.ordinal()];
    }

    // Valor en metros de nuestra Longitud.
    public double valorEnMetros() {
        double retVal = 1.0;        // 
        switch (this.unidad) {
            case YARDS: 
                retVal = this.cantidad * 0.9144;
                break;
            case FOOTS: 
                retVal = this.cantidad * 0.3048;
                break;                
            case INCHES: 
                retVal = this.cantidad * 0.0254;
                break; 
            default:
                retVal = this.cantidad;
                break;
        }
        return retVal; 
    }

    @Override
    public boolean equals(Longitud other) {
        if (this.unidad == other.unidad) {
            // Si ambas unidades son iguales, se comparan las cantidades
            return (this.cantidad == that.cantidad);
        }
        else {
            // se compara el valor en metros de cada una.
            return (this.valorEnMetros() == other.valorEnMetros());
        }
    }

    // devuelve negativo si nuestra Longitud es más pequeña
    public double compareTo(Longitud other) {
        if (this.unidad == other.unidad) {
            // Si ambas unidades son iguales, se comparan las cantidades
            return (this.cantidad - that.cantidad);
        }
        else {
            // se compara el valor en metros de cada una.
            return (this.valorEnMetros() - other.valorEnMetros());
        }
    }

    public add(Longitud other) {
        // Si la unidad es la misma para ambas longitudes, 
        // se conserva la unidad y se suman las cantidades. 
        if (this.unidad == other.unidad) {
            this.cantidad += other.cantidad;
        }
        // Si la unidad es distinta, se pasa todo a metros 
        // y se devuelve el resultado en metros.
        else {
            double metros = this.valorEnMetros();
            this.unidad = Unidad.METERS;
            this.cantidad = metros + other.valorEnMetros();
        }
    }

    // La unidad se queda como está y se multiplican las cantidades.
    public multiply(int n) {
        this.cantidad *= n;
    }

}
