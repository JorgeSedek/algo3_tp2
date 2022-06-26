package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.General.*;
import edu.fiuba.algo3.modelo.Meta.Meta;
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

    public void atravesar(Meta meta) {
        Efecto efectoAplicar = meta.atravesar(this);
        efectoAplicar.aplicar(this);
    }

    public abstract void atravesar(Obstaculo obstaculo, Jugador jugador) ;

    public abstract void atravesar(Sorpresa sorpresa, Jugador jugador) ;

    public abstract void atravesar(Obstaculo obstaculo) ;

    public abstract void atravesar(Sorpresa sorpresa) ;

    public void atravesar(Casillero casillero, Jugador jugador) {
        casillero.atravesar(this, jugador);
    }

    public void atravesar(Casillero casillero) {
        casillero.atravesar(this);
    }

    public double porcentajeMovimientos(double porcentaje) {
        return this.movimientos * porcentaje / 100;
    }

    public void mover(Direccion direccion, Jugador jugador) {
        this.movimientos++;
        int incremento = 1;
        jugador.incrementarMovimientos(incremento);
        direccion.mover(ubicacion);
        Casillero nuevoCasillero = Escenario.getInstance().buscarCasilleroEn(ubicacion);
        this.atravesar(nuevoCasillero, jugador);
        direccion.mover(ubicacion);
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

    public int obtenerMovimientos() {
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