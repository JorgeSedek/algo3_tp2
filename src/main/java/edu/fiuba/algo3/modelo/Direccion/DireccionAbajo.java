package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.General.Logger;
import edu.fiuba.algo3.modelo.General.Ubicacion;

public class DireccionAbajo implements Direccion{
    public void mover(Ubicacion ubicacion){
        if(ubicacion.voyAChocarBorde(this)) {
            Logger.getInstance().imprimir("Chocaste contra el borde, vuelves a tu posición anterior");
            ubicacion.mover(new DireccionArriba());
        } else {
            ubicacion.mover(this);
        }
    }

    public Direccion direccionOpuesta(){
        return new DireccionArriba();
    }

    @Override
    public String asString() {
        return "Abajo";
    }

}
