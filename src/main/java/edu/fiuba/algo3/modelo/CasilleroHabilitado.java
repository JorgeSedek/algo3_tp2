package edu.fiuba.algo3.modelo;

public class CasilleroHabilitado extends Casillero{

    public CasilleroHabilitado(int fila, int columna) {
        // uso del constructor de la clase abstracta
        super(fila, columna);
    }
    public Movimiento devolverMovimiento(){
        return (new MovimientoNormal());
    }
}
