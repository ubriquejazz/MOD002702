import java.util.ArrayList;

public class Discoteca {
    ArrayList<Disco> album = new ArrayList<Disco>();

    public boolean existe(String c) {
        if (album.contains(new Disco(c,"", "", "", 0))) 
          return false;
        else 
          return true;
    }

    public void create (String c, String a, String t, String g, int d) {
        album.add(new Disco(c, a, t, g, d));
    }

    public Disco read(String c) {
        int i = 0;
        Disco aux = new Disco(c,"", "", "", 0);
        if (album.contains(aux)) 
          i = album.indexOf(aux);
        return album.get(i);
    }
    
    public void listarG(String genero) {
        for(Disco d : album) {
          if(d.getGenero().equals(genero)) 
            System.out.println(d);
        }         
    }

    public void listar() {
        for(Disco d : album) {
            System.out.println(d);
        }         
    }   

    public void listar(String autor) {
        for(Disco d : album) {
          if(d.getAutor().equals(autor)) 
            System.out.println(d);
        }         
    }

    public void listar(int down, int up) {
        for(Disco d : album) {
          if((d.getDuracion() <= up) && (d.getDuracion() >= down)) 
            System.out.println(d);
        }         
    }  
      
}