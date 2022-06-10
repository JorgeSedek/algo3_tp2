package edu.fiuba.algo3.modelo;

public class Izquierda implements Direccion{
    public void mover( Ubicacion ubicacion){
        ubicacion.disminuirColumna();
    }
}
