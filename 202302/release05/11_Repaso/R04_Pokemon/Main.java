import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void test00() {
          Pokemon a = new Pokemon(1, "Pikachu", 
                            "Electrico", "Tierra", 
                            1,2,
                            3,4,
                            5,6, false);
          System.out.println(a);
    }

    public static void test01() {
        String miPokemon = "";
        Pokemon obj = null;
        Pokedex g = new Pokedex("pokemon.csv");
        // System.out.println(g);
        
        miPokemon = "Bulbasaur";
        obj = g.buscaPokemon(miPokemon);
        if (obj != null) {
            g.capturaPokemon(miPokemon);
        }
        miPokemon = "Vulpix";
        obj = g.buscaPokemon(miPokemon);
        if (obj != null) {
            g.capturaPokemon(miPokemon);

        }
        System.out.println(g.toStringCapturado());
    }

    public static void test02() {
        Pokedex g = new Pokedex();
        System.out.println(g);
    }

    public static void main(String[] args) {
        test01();
    }
}
