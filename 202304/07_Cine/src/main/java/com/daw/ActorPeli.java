package com.daw;

public class ActorPeli {
    public int idPeli;
    public int idActor;
    public boolean principal;

    public ActorPeli(int idActor, int idPelicula, boolean principal) {
        this.idActor = idActor;
        this.idPeli = idPelicula;
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
        return "Peli " + idPeli + "\t Act " + idActor + " (" + principal + ")";
    } 
}
