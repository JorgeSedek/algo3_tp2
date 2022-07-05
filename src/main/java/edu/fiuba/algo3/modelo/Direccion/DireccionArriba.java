package edu.fiuba.algo3.modelo.Direccion;


import edu.fiuba.algo3.modelo.General.Logger;
import edu.fiuba.algo3.modelo.General.Ubicacion;

public class DireccionArriba implements Direccion{
    public void mover(Ubicacion ubicacion){
        if(ubicacion.voyAChocarBorde(this)) {
            Logger.getInstance().imprimir("Chocaste contra el borde, vuelves a tu posición anterior");

            ubicacion.mover(new DireccionAbajo());
        } else {
            ubicacion.mover(this);
        }
    }
    /*
    public boolean ejemplo(Ubicacion ubicacion) {

    }
    */
    public Direccion direccionOpuesta(){
        return new DireccionAbajo();
    }

    @Override
    public String asString() {
        return "Arriba";
    }
}
