package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;


public class Jugador {
    private Vehiculo vehiculo;
    private final String nombre;

    private int movimientos;

    public Jugador(String nombreJugador, Vehiculo vehiculoElegido){
        this.vehiculo = vehiculoElegido;
        this.nombre = nombreJugador;
    }

    public void incrementarMovimientos(int incremento){
        this.vehiculo.incrementarMovimientos(incremento);
        this.movimientos += incremento;
    }

    public void disminuirMovimientos(int disminucion){
        this.vehiculo.reducirMovimientos(disminucion);
        this.movimientos -= disminucion;
    }

    public String obtenerNombre(){return this.nombre;}

    public void moverVehiculo(Direccion direccion){
        Jugador jugador = this;
        this.vehiculo.mover(direccion, jugador);

    }



    // Se usa para tests
    public boolean verificarMovimiento(int cantMovimientos){
       return (this.movimientos == cantMovimientos);
    }

    public double porcentajeMovimientos(double porcentaje) {
        return this.movimientos * porcentaje / 100;
    }

    public void cambiarVehiculo(Vehiculo vehiculoNuevo){
        this.vehiculo = vehiculoNuevo;
    }

    public void reducirMovimientos(int disminucion){this.movimientos -= disminucion;}

    // Se usa para tests
    public boolean mismoVehiculo(Vehiculo vehiculo) {
        // TODO cambiar la comparación
        return (this.vehiculo.getClass() == vehiculo.getClass() && this.vehiculo.verificarUbicacion(vehiculo.ubicacion()));
    }

    public Puntaje obtenerPuntaje() {
        return new Puntaje(this);
    }

    public Vehiculo obtenerVehiculo(){
        return this.vehiculo;
    }

    private String nombre(){
       return this.nombre;
    }

    private Vehiculo vehiculo(){
        return this.vehiculo;
    }

    // Se usa para tests
    public boolean equals(Jugador otroJugador){
        return (this.nombre == otroJugador.nombre() & this.vehiculo == otroJugador.vehiculo());
    }

    public int obtenerMovimientos() {
        return this.vehiculo.obtenerMovimientos();
    }
}