package com.mycompany.movies;

public class ActorPelicula {
    public int idPeli;
    public int idActor;
    public boolean principal;

    public ActorPelicula(int idPeli, int idAct, boolean principal) {
        this.idPeli = idPeli;
        this.idActor = idAct;
        this.principal = principal;
    }

    public void setIdPeli(int idPeli) {
        this.idPeli = idPeli;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "Peli " + idPeli + ", Act " + idActor + "(" + principal + ")";
    } 
    
}
