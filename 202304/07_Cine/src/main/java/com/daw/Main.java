package com.daw;

public class Main {

    float varGlobal = 0;

    public int suma(int a) {
        varGlobal += a;
    }

    public int resta(int a) {
        varGlobal -= a;
    }

    public void procesando(float valor) {

        varGlobal += suma(valor)
    }


    public static void main( String[] args )
    {
        CineDB_v01 db = new CineDB_v01("cine.db");
        
        // int id = db.insertaPelicula("Abierto hasta", 1999);
        // Pelicula nueva = db.datosPelicula(id);
        // System.out.println(nueva);
        System.out.println( "Pelis! ---------" );
        db.listadoPeliculas();

        // int id = db.insertaActor("Luis Fines", 1910);
        // Actor nuevo = db.datosActor(id);
        // System.out.println(nuevo);
        System.out.println( "Actores! -------" );
        db.listadoActor();

        // db.asociaPelicula(11, 3, true);
        // db.listadoActorPelicula();
        db.listadoPeliculasPorActor(11);
        CineDB_v01.closeDB();
    }
}
