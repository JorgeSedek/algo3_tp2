package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.Ubicacion;

public class DireccionIzquierda implements Direccion{
    public void mover( Ubicacion ubicacion){
        ubicacion.disminuirColumna();
    }
}
