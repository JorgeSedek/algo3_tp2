package edu.fiuba.algo3.modelo;

public class MovimientoNormal extends Movimiento{

   public Ubicacion mover(Ubicacion ubicacion){
       this.direccion.mover(ubicacion);
       return ubicacion;
   }
}
