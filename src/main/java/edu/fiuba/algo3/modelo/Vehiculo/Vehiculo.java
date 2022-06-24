package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.General.Casillero;
import edu.fiuba.algo3.modelo.General.Escenario;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.Sorpresa;


public abstract class Vehiculo {
    protected Ubicacion ubicacion;
    protected int movimientos;
    protected Vehiculo cambio;

    public Vehiculo(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
        this.movimientos = 0;
    }

    public abstract void atravesar(Obstaculo obstaculo);

    public abstract void atravesar(Sorpresa sorpresa);

    public void atravesar(Casillero casillero){
        casillero.atravesar(this);
    }

    public double porcentajeMovimientos(double porcentaje) {
        return this.movimientos * porcentaje / 100;
    }

    public void mover(Direccion direccion) {
        this.movimientos++;
        direccion.mover(ubicacion);
        Casillero nuevoCasillero = Escenario.getInstance().buscarCasilleroEn(ubicacion);
        this.atravesar(nuevoCasillero);
        direccion.mover(ubicacion);
    }

    public void incrementarMovimientos(int incremento){this.movimientos += incremento;}

    public void reducirMovimientos(int disminucion){this.movimientos -= disminucion;}

    // Metodo para tests
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

    public Ubicacion ubicacion() {
        return this.ubicacion;
    }

    public boolean verificarUbicacion(Ubicacion ubicacion) {
        return this.ubicacion.equals(ubicacion);
    }

    public Casillero casillero(){
        return new Casillero(ubicacion);
    }
}