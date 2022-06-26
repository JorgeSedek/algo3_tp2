package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Efecto.Efecto;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;


public class Jugador {
    private Vehiculo vehiculo;
    private final String nombre;
    private int movimientos;

    public Jugador(String nombreJugador, Vehiculo vehiculoElegido){
        this.vehiculo = vehiculoElegido;
        this.nombre = nombreJugador;
        this.movimientos = 0;
    }

    public void incrementarMovimientos(int incremento){this.movimientos += incremento;}

    public void reducirMovimientos(int disminucion){this.movimientos -= disminucion;}

    public void moverVehiculo(Direccion direccion){
        this.movimientos++;
        Efecto efecto = this.vehiculo.mover(direccion);
        efecto.aplicar(this);
    }

    // Se usa para tests
    public boolean verificarMovimientos(int cantMovimientos){
       return this.movimientos == cantMovimientos;
    }

    public void cambiarVehiculo(Vehiculo vehiculoNuevo){
        this.vehiculo = vehiculoNuevo;
    }

    // Se usa para tests
    public boolean mismoVehiculo(Vehiculo vehiculo) {
        // TODO cambiar la comparación
        return (this.vehiculo.getClass() == vehiculo.getClass() && this.vehiculo.verificarUbicacion(vehiculo.ubicacion()));
    }

    public Puntaje obtenerPuntaje() {
        return new Puntaje(this);
    }

    public double porcentajeMovimientos(double porcentajeIncremento) {
        return this.movimientos * porcentajeIncremento / 100;
    }

    public String nombre() {
        return this.nombre;
    }

    public int movimientos() {
        return this.movimientos;
    }
}