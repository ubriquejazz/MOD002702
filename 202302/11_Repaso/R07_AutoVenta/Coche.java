import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Coche implements Comparable<Coche> {

    String matricula;
    String marca;
    String modelo;
    LocalDate fMatricula;
    double precio;

    public Coche(String matricula, String marca, String modelo, LocalDate fMatricula, double precio) {
        boolean error = false;
        error |= setMatricula(matricula);
        error |= setFecha(fMatricula);
        error |= setPrecio(precio);
        if (!error) {
            this.marca = marca;
            this.modelo = modelo;            
        }
        else {
            this.matricula = "invalid";
            System.out.println("El coche con matricula " + matricula + " es invalido");
        }
    }

    @Override    
    public String toString() {
        return fMatricula + " ; " + marca + " ; " + precio + " euros";
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDate getFecha() {
        return fMatricula;
    }
    
    public double getPrecio() {
        return precio;
    }

    public boolean setMatricula(String matricula) {
        boolean error = false;
        char[] array = matricula.toCharArray();
        for (int i=0; i<4; i++) {
            if (Character.isDigit(array[i]) == false)
                error = true;
        }
        for (int i=0; i<3; i++) {
            if (Character.isLetter(array[i+4]) == false)
                error = true;
        }
        if (!error) this.matricula = matricula;
        return error;
    }

    public boolean setFecha(LocalDate fMatricula) {
        boolean error = false;
        LocalDate ahora = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(fMatricula, ahora);
        if (daysBetween > 900)
            error = true;
        if (!error) this.fMatricula = fMatricula;
        return error;
    }

    public boolean setPrecio(double precio) {
        boolean error = false;
        if (precio < 500) error = true;
        if (!error) this.precio = precio;
        return error;
    }    

    @Override    
    public boolean equals(Object o) {
        Coche miCoche = (Coche)o;
        String s1 = miCoche.getMatricula();
        if (matricula.equals(s1))
            return true;
        return false;
    }

    @Override
    public int compareTo(Coche otro){
        String s1 = otro.getMatricula();
        if (matricula.equals(s1))
            return 0;
        return 1;
    }

}