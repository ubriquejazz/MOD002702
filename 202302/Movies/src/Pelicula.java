package com.mycompany.movies;

public class Pelicula {
    public int id;
    public String titulo;
    public int anno;
    public boolean tieneOscar;
    public double valoracion;

    public Pelicula(int id, String titulo, int anno, boolean tieneOscar, double valoracion) {
        this.id = id;
        this.titulo = titulo;
        this.anno = anno;
        this.tieneOscar = tieneOscar;
        this.valoracion = valoracion;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnno() {
        return anno;
    }

    public boolean tieneOscar() {
        return tieneOscar;
    }

    public double getValoracion() {
        return valoracion;
    }
    
    @Override
    public String toString() {
        return "Peli " + id + " = " + valoracion + ", " + titulo + "(" + anno + ")";
    }  
}
