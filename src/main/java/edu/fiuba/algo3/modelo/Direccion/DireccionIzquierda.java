package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.General.Ubicacion;

public class DireccionIzquierda implements Direccion{
    public void mover(Ubicacion ubicacion){
        if(ubicacion.voyAChocarBorde(this)) {
            ubicacion.mover(new DireccionDerecha());
        } else {
            ubicacion.mover(this);
        }
    }

    public Direccion direccionOpuesta(){
        return new DireccionDerecha();
    }
}
