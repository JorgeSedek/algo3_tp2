package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.General.Logger;
import edu.fiuba.algo3.modelo.General.Ubicacion;

public class DireccionDerecha implements Direccion{
    public void mover(Ubicacion ubicacion){
        if(ubicacion.voyAChocarBorde(this)) {
            Logger.getInstance().imprimir("Chocaste contra el borde, vuelves a tu posición anterior");
            ubicacion.mover(new DireccionIzquierda());
        } else {
            ubicacion.mover(this);
        }
    }

    public Direccion direccionOpuesta(){
        return new DireccionIzquierda();
    }

    @Override
    public String asString() {
        return "la Derecha";
    }
}
