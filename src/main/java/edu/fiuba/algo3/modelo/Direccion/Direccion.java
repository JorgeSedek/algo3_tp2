package edu.fiuba.algo3.modelo.Direccion;

import edu.fiuba.algo3.modelo.General.Casillero;


public interface Direccion {
    public void mover(Casillero casillero);

    public Direccion direccionOpuesta();
}
