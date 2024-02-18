package com.mycompany.movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CineDB {
        
    private Connection connect = null;
    private Statement statement = null;

    /* Private Methods */
    
    private void openDB(String url){
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

    private void executeDB(String sentence) {
        try {
            this.statement.execute(sentence);
        } catch (SQLException ex) {
            System.err.println(sentence + "\n" + ex.getMessage());
        }
    }
    private void executeQueryDB(String consulta) {
        try {
            this.statement.executeQuery(consulta);
        } catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
    }

    public void closeDB(){
        try {
            connect.close();
            System.out.println("Closed");
        } catch (SQLException ex) {
            System.err.println("No se ha podido cerrar\n"+ex.getMessage());
        }
    }
    
    public CineDB(String url) {
        openDB(url);
    } 

    /*****************************************************/
    /* Public Methods - ACTOR */
    /*****************************************************/  
    
    // nos devuelve el id del actor
    public int insertaActor(String nombre, String pais) {
        int retVal = 0;
        String sentencia = 
                "INSERT INTO actores (nombre, pais) VALUES (\"" 
                + nombre + "\", \"" +  pais + "\")";
        executeDB(sentencia);
        
        String consulta = 
                "SELECT last_insert_rowid() FROM actores";
        try {
            ResultSet rs = this.statement.executeQuery(consulta);
            retVal = rs.getInt(1);
        } 
        catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
        return retVal;
    }
    
    public Actor datosActor(int idActor) {
        Actor retVal = null;
        String consulta = 
                "SELECT * FROM actores WHERE id =" + idActor;
        try {
            ResultSet rs = this.statement.executeQuery(consulta);
            if(rs.next())  {
                String nombre = rs.getString("nombre");
                String pais = rs.getString("pais");
                int id = rs.getInt("id");
                retVal = new Actor(id, nombre, pais);
            }
        } 
        catch (SQLException ex) {
            System.err.println("Statement \n" + ex.getMessage());
        }
        return retVal;
    }
    
    // listado de todos los actores
    public ArrayList<Actor> listadoActores() {        
        ArrayList<Actor> retVal = new ArrayList<Actor>();
        String consulta = "SELECT * FROM actores";
        try {
            ResultSet rs = this.statement.executeQuery(consulta);
            while(rs.next())  {
                Actor nuevo = new Actor(
                rs.getInt("id"),
             rs.getString("nombre"),
               rs.getString("pais"));
                retVal.add(nuevo);
            }
        } catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
        return retVal;
    }
    
    /*****************************************************/
    /* Public Methods - PELI */
    /*****************************************************/  
    
    // nos devuelve el id del actor
    public int insertaPelicula(String titulo, int anno){ //, boolean tieneOscar, double valoracion) {
        int retVal = 0;
        String sentencia = 
                "INSERT INTO peliculas (titulo, anno) VALUES (\"" 
                + titulo + "\", " +  anno + ")";
        executeDB(sentencia);
        
        String consulta = 
                "SELECT last_insert_rowid() FROM peliculas";
        try {
            ResultSet rs = this.statement.executeQuery(consulta);
            retVal = rs.getInt(1);
        } 
        catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
        return retVal;
    }
    
    public Pelicula datosPelicula(int idPeli) {
        Pelicula retVal = null;
        String consulta = 
                "SELECT * FROM peliculas WHERE id =" + idPeli;
        try {
            ResultSet rs = this.statement.executeQuery(consulta);
            if(rs.next())  {
                retVal = new Pelicula(
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
        return retVal;
    }
    
    // listado de todos los actores
    public ArrayList<Pelicula> listadoPeliculas() {        
        ArrayList<Pelicula> retVal = new ArrayList<Pelicula>();
        String consulta = "SELECT * FROM peliculas";
        try {
            ResultSet rs = this.statement.executeQuery(consulta);
            while(rs.next())  {
                Pelicula nuevo = new Pelicula(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getInt("anno"),
                    rs.getBoolean("tieneOscar"),
                    rs.getDouble("valoracion"));
                    retVal.add(nuevo);
            }
        } catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
        return retVal;
    }
    
    
    /*****************************************************/
    /* Public Methods - ActorPelicula */
    /*****************************************************/
    
    public void asociaPelicula(int idPeli, int idActor, boolean principal) {
        String sentencia = 
                "INSERT INTO actoresPelicula VALUES ("
                + idPeli + "," + idActor + "," + principal + ")";
        executeDB(sentencia);        
    }
    
    // listado de tabla actoresPelicula
    public ArrayList<ActorPelicula> listadoActorPelicula() {        
        ArrayList<ActorPelicula> retVal = new ArrayList<ActorPelicula>();
        String consulta = "SELECT * FROM actoresPelicula";
        try {
            ResultSet rs = this.statement.executeQuery(consulta);
            while(rs.next())  {
                ActorPelicula nuevo = new ActorPelicula(
                      rs.getInt("id_peli"),
                       rs.getInt("id_actor"),
                    rs.getBoolean("principal"));
                retVal.add(nuevo);
            }
        } catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
        return retVal;
    }    
    
    // el mas difcil
    public ArrayList<Pelicula> listadoPeliculaPorActor(int idActor) {        
        ArrayList<Pelicula> retVal = new ArrayList<Pelicula>();
        String consulta = "SELECT * FROM actoresPelicula WHERE id_actor =" + idActor;
        try {
            ResultSet rs = this.statement.executeQuery(consulta);
            while(rs.next())  {
                int idx = rs.getInt("id_peli");
                boolean pral = rs.getBoolean("principal");
                System.out.println("el actor " + idActor + " trabajo en la peli " + idx);
                Pelicula nuevo = datosPelicula(idx);
                retVal.add(nuevo);
            }
        } catch (SQLException ex) {
            System.err.println(consulta + "\n" + ex.getMessage());
        }
        return retVal;
    } 
     
}
