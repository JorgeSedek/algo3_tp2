package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.General.Casillero;

public class DireccionDerecha implements Direccion{
    public void mover(Casillero casillero){
        DireccionDerecha direccion = this;
        casillero.mover(direccion);
    }
    public Direccion direccionOpuesta(){
        return new DireccionIzquierda();
    }
}
