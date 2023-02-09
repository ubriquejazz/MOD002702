import java.time.LocalDate;

public class Actor_Main {

    public static void main(String[] args) {
        CineDB cine = new CineDB("cine.db");
        LocalDate dia = LocalDate.of(1950, 1, 13);
        Actor tony = new Actor (0, "Tom Hanks", dia);
        //cine.insertaActor(tony);
        System.out.println(tony);
        cine.listadoActores();
        cine.closeDB();
    }
}