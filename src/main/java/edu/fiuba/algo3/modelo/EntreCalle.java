package edu.fiuba.algo3.modelo;

public class EntreCalle {
    private Calle superior;
    private Calle inferior;
    private Calle izquierda;
    private Calle derecha;

    public EntreCalle () {
        this.superior = null;
        this.inferior = null;
        this.izquierda = null;
        this.derecha = null;
    }
    public void asignarCalleSuperior(Calle superior) {
        this.superior = superior;
    }
    public void asignarCalleInferior(Calle inferior) {
        this.inferior = inferior;
    }
    public void asignarCalleIzquierda(Calle izquierda) {
        this.izquierda = izquierda;
    }
    public void asignarCalleDerecha(Calle derecha) {
        this.derecha = derecha;
    }
    public void asignarCalles(Calle superior, Calle inferior, Calle izquierda, Calle derecha) {
        this.asignarCalleSuperior(superior);
        this.asignarCalleInferior(inferior);
        this.asignarCalleIzquierda(izquierda);
        this.asignarCalleDerecha(derecha);
    }
    public Calle obtenerCalleSuperior () {
        return this.superior;
    }
    public Calle obtenerCalleInferior () {
        return this.inferior;
    }
    public Calle obtenerCalleIzquierda () {
        return this.izquierda;
    }
    public Calle obtenerCalleDerecha () {
        return this.derecha;
    }

}