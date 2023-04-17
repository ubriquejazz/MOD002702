package com.daw;

public class Actor {
  
    private int id;
    private String nombre;
    private int anno;

    public Actor (int id, String nombre, int anno) {
        this.anno = anno;
        this.id = id;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\t " + nombre + " (" + anno + ")";
    }   
}
