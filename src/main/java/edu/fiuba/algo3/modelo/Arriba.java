package edu.fiuba.algo3.modelo;


public class Arriba implements Direccion{
    public void mover( Ubicacion ubicacion){
        ubicacion.disminuirFila();
    }
}
