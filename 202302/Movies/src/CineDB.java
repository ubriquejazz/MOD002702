import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CineDB {

    private Connection connect = null;
    private Statement statement = null;

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

    private void writeIntoDB(String sentence) {
        try {
            this.statement.executeQuery(sentence);
        } catch (SQLException ex) {
            System.err.println("Statement \n" + ex.getMessage());
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

    public void listadoActores() {
        String selectQuery = "SELECT * FROM actores";
        try {
            ResultSet rs = this.statement.executeQuery(selectQuery);
            while(rs.next())  {
                String linea = rs.getString("nombre") +
                        ", id = " + rs.getInt("id");
                System.out.println(linea);
            }
        } catch (SQLException ex) {
            System.err.println("Statement \n" + ex.getMessage());
        }
    }

    public int insertaActor(Actor a) {
        int retVal = 0;
        String insertQuery = "INSERT INTO actores (nombre, fechaNacimiento) VALUES (\""
                + a.getNombre() + "\", " + a.getfNac() + ")";
        //System.out.println(insertQuery);
        writeIntoDB(insertQuery);
        String consulta = "SELECT Max(id) FROM actores";
        //System.out.println(consulta);
        try {
            ResultSet rs = this.statement.executeQuery(consulta);
            retVal = rs.getInt(1);
        } catch (SQLException ex) {
            System.err.println("Statement \n" + ex.getMessage());
        }
        a.setId(retVal);
        return retVal;
    }


}
