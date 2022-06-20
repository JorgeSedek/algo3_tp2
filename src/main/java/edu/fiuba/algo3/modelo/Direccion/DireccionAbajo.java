package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.General.Ubicacion;

public class DireccionAbajo implements Direccion{


    public void mover(Ubicacion ubicacion){
        DireccionAbajo direccion = this;
        ubicacion.mover(direccion);


    }

    public Direccion direccionOpuesta(){
        return new DireccionArriba();
    }
}
