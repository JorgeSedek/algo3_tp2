package edu.fiuba.algo3.modelo;

public class EntreCalle {
    private Calle arriba;
    private Calle izquierda;
    private Calle derecha;
    private Calle abajo;
    public EntreCalle () {
        this.arriba = null;
        this.abajo = null;
        this.izquierda = null;
        this.derecha = null;
    }
    public void AsignarCalleSuperior (Calle superior) {
        this.arriba = superior;
    }
    public void AsignarCalleInferior (Calle inferior) {
        this.abajo = inferior;
    }
    public void AsignarCalleIzquierda (Calle izquierda) {
        this.izquierda = izquierda;
    }
    public void AsignarCalleDerecha (Calle derecha) {
        this.derecha = derecha;
    }

}
