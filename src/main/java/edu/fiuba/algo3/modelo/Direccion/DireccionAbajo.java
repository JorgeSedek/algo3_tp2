package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.General.Casillero;

public class DireccionAbajo implements Direccion{
    public void mover(Casillero casillero){
        DireccionAbajo direccion = this;
        casillero.mover(direccion);

    }

    public Direccion direccionOpuesta(){
        return new DireccionArriba();
    }
}
