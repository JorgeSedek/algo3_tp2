package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.General.Ubicacion;

public class DireccionDerecha implements Direccion{
    public void mover(Ubicacion ubicacion){
        if(!ubicacion.voyAChocarBorde(this)) {
            ubicacion.mover(this);
        } else {
            ubicacion.mover(new DireccionIzquierda());
        }
    }

    public Direccion direccionOpuesta(){
        return new DireccionIzquierda();
    }
}
