package edu.fiuba.algo3.modelo.General;

import java.util.ArrayList;

public class Casillero {
    private Ubicacion ubicacion;

    public Casillero(Ubicacion ubicacion){
        this.ubicacion = ubicacion;
    }

    public Ubicacion ubicacion() {
        return this.ubicacion;
    }

    public boolean equals(Casillero otroCasillero) {
        return this.ubicacion.equals(otroCasillero.ubicacion());
    }
}
