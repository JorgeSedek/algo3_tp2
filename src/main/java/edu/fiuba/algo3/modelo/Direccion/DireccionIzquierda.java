package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.General.Casillero;

public class DireccionIzquierda implements Direccion{
    public void mover(Casillero casillero){
        DireccionIzquierda direccion = this;
        casillero.mover(direccion);
    }

    public Direccion direccionOpuesta(){
        return new DireccionDerecha();
    }
}
