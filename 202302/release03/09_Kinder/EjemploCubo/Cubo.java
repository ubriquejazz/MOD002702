public class Cubo {

    int capacidad;  // atributo de objeto
    int contenido;  // contenido < capacidad

    public Cubo (int c) {
        this.capacidad = c;
    }

    // métodos getter  
    public int getCapacidad() {
        return this.capacidad;
    }

    public int getContenido() {
        return this.contenido;
    }

    // método setter
    public void setContenido(int litros) {
        this.contenido = litros;
    }

    // otros métodos
    public void vacia() {
        this.contenido = 0;
    }

    public void llena() {
        this.contenido = this.capacidad;
    }

    public void pinta() {
        for (int nivel = this.capacidad; nivel > 0; nivel--) {
            if (this.contenido >= nivel) {
                System.out.println("#~~~~#");
            } 
            else {
                System.out.println("#    #");
            }
        }
        System.out.println("######");
    }

    public void vuelcaEn(Cubo destino) {
        int libres = destino.getCapacidad() - destino.getContenido();
        
        if (libres > 0) {
        if (this.contenido <= libres) {
            destino.setContenido(destino.getContenido() + this.contenido);
            this.vacia();
        } else {
            this.contenido -= libres;
            destino.llena();
        }
        }
    }

}