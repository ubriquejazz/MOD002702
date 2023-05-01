package com.mycompany.movies;

import java.util.ArrayList;
import java.util.Arrays;

public class Sqliteapp02 {

    public static void test_actor() {
        CineDB cine = new CineDB("cine.db");
        int value = cine.insertaActor("Felipe", "US");
        Actor nuevo = cine.datosActor(value);
        System.out.println(nuevo);

        ArrayList<Actor> myList = cine.listadoActores();
        System.out.println(myList.toString());

        cine.closeDB();
    }
    
    public static void test_pelis() {
        CineDB cine = new CineDB("cine.db");

//        int value = cine.insertaPelicula("Amanece", 1989);
//        Pelicula nuevo = cine.datosPelicula(value);
//        System.out.println(nuevo);

        ArrayList<Pelicula> myList = cine.listadoPeliculas();
        System.out.println(myList.toString());
        
        cine.closeDB();
    }
    
    public static void test_apelis() {
        CineDB cine = new CineDB("cine.db");

//        cine.asociaPelicula(1, 1, true);
//        cine.asociaPelicula(1, 2, false);
//        cine.asociaPelicula(5, 1, false);
//        cine.asociaPelicula(3, 1, false);

        ArrayList<ActorPelicula> myList = cine.listadoActorPelicula();
        System.out.println(myList.toString());
        
        ArrayList<Pelicula> myList2 = cine.listadoPeliculaPorActor(1);
        System.out.println(myList2.toString());
        
        
        cine.closeDB();
    }
    
    public static void main(String[] args) {
        System.out.println("Bienvenido al cine!");
        test_apelis();

    }
}
