import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {

    // private final static String url = "C:/sqlite/db/cine2.db";
    private CineDB kino = null;

    public static void connect(String url) {
        Connection conn = null;
        try {			
            conn = DriverManager.getConnection("jdbc:sqlite:"+url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void test_actor(CineDB cine) {
        // insert into actores
        int value = cine.insertaActor("Felipe Reyes", "US");
        Actor nuevo = cine.datosActor(value);
        System.out.println(nuevo);
        
        // select * from actores
        ArrayList<Actor> myList = cine.listadoActores();
        System.out.println(myList.toString());        
    }

    public static void test_pelis(CineDB cine) {
        // insert into peliculas
        int value = cine.insertaPelicula("Amanece", 1989);
        Pelicula nuevo = cine.datosPelicula(value);
        System.out.println(nuevo);

        // select * from peliculas
        ArrayList<Pelicula> myList = cine.listadoPeliculas();
        System.out.println(myList.toString()); 
    }
    
    public static void test_apelis(CineDB cine) {
        // insert into actorPelicula
        cine.asociaPelicula(1, 1, true);
        cine.asociaPelicula(1, 2, false);
        //cine.asociaPelicula(5, 1, false);
        //cine.asociaPelicula(3, 1, false);

        // select * from actorPelicula
        ArrayList<ActorPelicula> myList = cine.listadoActorPelicula();
        System.out.println(myList.toString());
        
        // select * from actorPelicula where id_actor == 1
        ArrayList<Pelicula> myList2 = cine.listadoPeliculaPorActor(1);
        System.out.println(myList2.toString());         
    }
    
    
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Uso del programa: java -jar pelis.jar FICHERO");
            System.exit(-1); // sale del programa
        }
        
        System.out.println("Bienvenido al cine " + args[0]);
        //connect(args[0]);        
        CineDB kino = new CineDB(args[0]);
        test_apelis(kino);
        kino.closeDB();
        
    }
}
