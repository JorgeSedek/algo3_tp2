package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

import java.util.HashMap;

public abstract class ObjetoUrbano {
    // Un Objeto Urbano es una sosrpresa o un obstaculo (elementos que pueden existir en una calle)
    protected HashMap<Class, UrbanoHandler> urbanoMap;


    protected abstract void initUrbanoMap();
    public ObjetoUrbano() {
        this.initUrbanoMap();

    }



    public void recibe(ObjetoUrbano otroObjeto) {
        UrbanoHandler handler = this.urbanoMap.get(otroObjeto.getClass());
        handler.recibe(otroObjeto);
    }

    public interface UrbanoHandler {
        void recibe(ObjetoUrbano OtroObjeto);
    }
}