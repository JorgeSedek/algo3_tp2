package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.General.Ubicacion;

public class DireccionIzquierda implements Direccion{
    public void mover(Ubicacion ubicacion){
        if(!ubicacion.voyAChocarBorde(this)) {
            ubicacion.mover(this);
        } else {
            ubicacion.mover(new DireccionDerecha());
        }
    }

    public Direccion direccionOpuesta(){
        return new DireccionDerecha();
    }
}
