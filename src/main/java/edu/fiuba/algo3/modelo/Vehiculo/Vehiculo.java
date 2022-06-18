package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Movimiento.MovimientoNormal;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;


public abstract class Vehiculo {
    protected Movimiento movimiento;
    protected Casillero casillero;
    protected int movimientos;
    protected Vehiculo cambio;

    public Vehiculo(Casillero casillero) {
        this.casillero = casillero;
        this.movimientos = 0;
        this.movimiento = new MovimientoNormal();
    }

    public abstract void recibe(Obstaculo obstaculo);

    public abstract void recibe(Sorpresa sorpresa);

    public int porcentajeMovimientos(int porcentaje) {
        return this.movimientos * porcentaje / 100;
    }

    public Casillero casillero() {
        return this.casillero;
    }

    public void mover(Direccion direccion) {
        direccion.mover(this.casillero);
    }

    public void incrementarMovimientos(int incremento){this.movimientos += incremento;}

    public void disminuirMovimientos(int disminucion){this.movimientos -= disminucion;}

    // Metodo para ests
    public boolean verificarCasillero(Casillero nuevoCasillero) {
        return this.casillero.equals(nuevoCasillero);
    }

    // Metodo para ests
    public boolean verificarMovimientos(int cantMovimientos){
        return (this.movimientos == cantMovimientos);
    }

    public void establecerCambio(Vehiculo vehiculo){
        this.cambio = vehiculo;
    }
    public Vehiculo cambio() {
        return this.cambio;
    }

    public int movimientos() {
        return this.movimientos;
    }
}