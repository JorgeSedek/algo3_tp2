package edu.fiuba.algo3.modelo.Direccion;


import edu.fiuba.algo3.modelo.General.Casillero;

public class DireccionArriba implements Direccion{
    public void mover(Casillero casillero){

        casillero.disminuirFila();
    }
}
