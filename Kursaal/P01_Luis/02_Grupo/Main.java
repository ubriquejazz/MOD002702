import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void test_Alumno() {
          // Prueba de las propiedades de acceso
          Alumno a = new Alumno("Luis", 16, 9.0);
          System.out.println(a);
          a.setNombre("");
          a.setEdad(101);
          a.setCalificacion(11);
          System.out.println(a);
    }

    public static void test01() {
        Grupo g = new Grupo();

        g.insertaAlumno(new Alumno("Juan", 20, 7.5));
        g.insertaAlumno(new Alumno("Ana", 19, 8.0));
        g.insertaAlumno("Pedro", 21, 6.5);
        System.out.println(g.toString());
        System.out.println("------------");
        g.escribeFicheroCSV("alumnos.csv");
        g.leeFicheroCSV("alumnos.csv");
        g.leeFicheroCSV("alumnos.csv");
        g.leeFicheroCSV("alumnos.csv");
        System.out.println(g);
    }

    public static void test02() {
        Grupo g = new Grupo();
        g.leeFicheroCSV("alumnos.csv");
        System.out.println(g);
    }

    public static void main(String[] args) {
        test01();
    }
}
