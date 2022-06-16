package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;

import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;


public abstract class Vehiculo {
    protected Casillero casillero;
    protected int movimientos;
    protected Vehiculo cambio;

    public Vehiculo(Casillero casillero) {
        this.casillero = casillero;
        this.movimientos = 0;
    }

    public abstract void recibe(Obstaculo obstaculo);

    public abstract void recibe(Sorpresa sorpresa);

    public int porcentajeMovimientos(int porcentajePedido) {
        return this.movimientos * porcentajePedido / 100;
    }

    public Casillero casillero() {
        return this.casillero;
    }

    public void mover(Direccion direccion) {
        direccion.mover(this.casillero);
    }

    public void incrementarMovimientos(int incremento){this.movimientos += incremento;}

    public void disminuirMovimientos(int disminucion){this.movimientos -= disminucion;}

    // Metodos para Tests
    public boolean verificarCasillero(Casillero nuevoCasillero) {
        return this.casillero.equals(nuevoCasillero);
    }

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