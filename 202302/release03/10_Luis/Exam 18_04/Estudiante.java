class Estudiante {
    private String nombre;
    private int eval1, eval2;

    public Estudiante(String nombre, int eval1, int eval2) {
        this.nombre = nombre;
        this.eval1 = eval1;
        this.eval2 = eval2;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEvaluacion1() {
        return eval1;
    }

    public int getEvaluacion2() {
        return eval2;
    }
}
