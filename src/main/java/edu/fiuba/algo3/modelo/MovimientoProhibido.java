package edu.fiuba.algo3.modelo;

public class MovimientoProhibido extends Movimiento{
    public Ubicacion mover(Ubicacion ubicacion){
       //se queda en el mismo lugar
        return ubicacion;
    }
}
