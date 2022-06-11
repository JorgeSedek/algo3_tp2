package edu.fiuba.algo3.modelo;

public class CasilleroProhibido extends Casillero{
    public CasilleroProhibido(int fila, int columna) {
        // uso del constructor de la clase abstracta
        super(fila, columna);
    }
    public Movimiento devolverMovimiento(){
        return (new MovimientoProhibido());
    }
}
