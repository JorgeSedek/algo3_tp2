package edu.fiuba.algo3.modelo;

public class Abajo implements Direccion{
    public void mover( Ubicacion ubicacion){
        ubicacion.incrementarFila();
    }
}
