package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.General.Ubicacion;

public class DireccionDerecha implements Direccion{
    public void mover( Ubicacion ubicacion){
        ubicacion.incrementarColumna();
    }
}
