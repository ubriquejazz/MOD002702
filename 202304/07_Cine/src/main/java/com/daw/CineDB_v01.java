package com.daw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CineDB_v01
{
    private static Connection connect = null;
    private static Statement statement = null;

    public CineDB_v01(String url) {
        openDB(url);
    }

    public void asociaPelicula(int idActor, int idPeli, boolean principal) {
        String sentencia = 
        "INSERT INTO actoresPeliculas VALUES ("+ idActor + "," + idPeli + "," + principal + ")";
        executeDB(sentencia);        
    }

    public void listadoActorPelicula() {        
        String consulta = "SELECT * FROM actoresPeliculas";
        try {
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next())  {
                ActorPeli nuevo = new ActorPeli(
                    rs.getInt("idActor"),
                    rs.getInt("idPelicula"),
                    rs.getBoolean("principal"));
                System.out.println(nuevo);
            }
        } catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
    }

    /* Database Methods */
    
    public static void openDB(String url){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            if (connect!=null) {
                statement = connect.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec
                System.out.println("Statement ready...");
            }
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar\n" + ex.getMessage());
        }
    }

    public static void executeDB(String sentence) {
        try {
            statement.execute(sentence);
        } catch (SQLException ex) {
            System.err.println(sentence + "\n" + ex.getMessage());
        }
    }

    public static void executeQueryDB(String consulta) {
        try {
            statement.executeQuery(consulta);
        } catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
    }

    public static void closeDB(){
        try {
            connect.close();
            System.out.println("Closed");
        } catch (SQLException ex) {
            System.err.println("No se ha podido cerrar\n"+ex.getMessage());
        }
    }

    /* Actor Methods */

    public void listadoActor() {
        String consulta = "SELECT * FROM actores";
        try {
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next())  {
                Actor nuevo = new Actor(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("fechaNacimiento"));
                System.out.println(nuevo);
            }
        } catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
    }
    
    public Actor datosActor(int idActor) {
        Actor nuevo = null;
        String consulta = 
        "SELECT * FROM actores WHERE id =" + idActor;
        try {
            ResultSet rs = statement.executeQuery(consulta);
            if(rs.next())  {
                nuevo = new Actor(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("fechaNacimiento"));
            }
        } 
        catch (SQLException ex) {
            System.err.println("Statement \n" + ex.getMessage());
        }
        return nuevo;
    }

    public int insertaActor(String nombre, int anno) {
        String sentencia = 
        "INSERT INTO actores (nombre, fechaNacimiento) VALUES (\"" + nombre + "\", \"" +  anno + "\")";
        executeDB(sentencia);
        String consulta = 
        "SELECT last_insert_rowid() FROM actores";
        int retVal = 0;
        try {
            ResultSet rs = statement.executeQuery(consulta);
            retVal = rs.getInt(1);
        } 
        catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
        return retVal;
    }

    /* Peli Methods */

    public void listadoPeliculas() {        
        String consulta = "SELECT * FROM peliculas";
        try {
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next())  {
                Pelicula nuevo = new Pelicula(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getInt("anno"),
                    rs.getBoolean("tieneOscar"),
                    rs.getDouble("valoracion"));
                System.out.println(nuevo);
            }
        } catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
    }

    public Pelicula datosPelicula(int idPeli) {
        Pelicula nueva = null;
        String consulta = 
        "SELECT * FROM peliculas WHERE id =" + idPeli;
        try {
            ResultSet rs = statement.executeQuery(consulta);
            if(rs.next())  {
                nueva = new Pelicula(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getInt("anno"),
                    rs.getBoolean("tieneOscar"),
                    rs.getDouble("valoracion"));
            }
        } 
        catch (SQLException ex) {
            System.err.println("Statement \n" + ex.getMessage());
        }
        return nueva;
    }

    public int insertaPelicula(String titulo, int anno){ //, boolean tieneOscar, double valoracion) {
        String sentencia = 
        "INSERT INTO peliculas (titulo, anno, tieneOscar) VALUES (\"" + titulo + "\", " +  anno + ", false)";
        executeDB(sentencia);
        String consulta = "SELECT last_insert_rowid() FROM peliculas";
        int retVal = 0;
        try {
            ResultSet rs = statement.executeQuery(consulta);
            retVal = rs.getInt(1);
        } 
        catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
        return retVal;
    }

    public void listadoPeliculasPorActor(int idActor) {
        String consulta = 
        "SELECT * FROM actoresPeliculas WHERE idActor =" + idActor;
        try {
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next())  {
                int idx = rs.getInt("idPelicula");
                //boolean pral = rs.getBoolean("principal");
                System.out.println("el actor " + idActor + " trabajo en la peli " + idx);
                Pelicula nuevo = datosPelicula(idx);
                System.out.println(nuevo);
            }
        } catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
    }
}
