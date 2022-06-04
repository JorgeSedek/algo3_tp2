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
    public void AsignarCalleSuperior (Calle superior) {
        this.superior = superior;
    }
    public void AsignarCalleInferior (Calle inferior) {
        this.inferior = inferior;
    }
    public void AsignarCalleIzquierda (Calle izquierda) {
        this.izquierda = izquierda;
    }
    public void AsignarCalleDerecha (Calle derecha) {
        this.derecha = derecha;
    }

}
