package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.Direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.Direccion.DireccionIzquierda;

public class Casillero {
    private int fila;
    private int columna;

    public Casillero(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public boolean equals(Casillero casillero) {
        return (casillero.fila == this.fila & casillero.columna == this.columna);
    }

    public void mover(DireccionAbajo direccion) {
        this.fila += 1;
    }

    public void mover(DireccionDerecha direccion) {
        this.columna += 1;
    }

    public void mover(DireccionArriba direccion) {
        this.fila -= 1;
    }

    public void  mover(DireccionIzquierda direccion) {
        this.columna -= 1;
    }

}
