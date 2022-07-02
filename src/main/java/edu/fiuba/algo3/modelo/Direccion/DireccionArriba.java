package edu.fiuba.algo3.modelo.Direccion;


import edu.fiuba.algo3.modelo.General.Ubicacion;

public class DireccionArriba implements Direccion{
    public void mover(Ubicacion ubicacion){
        if(ubicacion.voyAChocarBorde(this)) {
            ubicacion.mover(new DireccionAbajo());
        } else {
            ubicacion.mover(this);
        }
    }

    public Direccion direccionOpuesta(){
        return new DireccionAbajo();
    }
}
