package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;


public class Jugador {
    private Vehiculo vehiculo;
    private final String nombre;

    public Jugador(String nombreJugador, Vehiculo vehiculoElegido){
        this.vehiculo = vehiculoElegido;
        this.nombre = nombreJugador;
    }

    public void incrementarMovimientos(int incremento){this.vehiculo.incrementarMovimientos(incremento);}

    public void disminuirMovimientos(int disminucion){this.vehiculo.disminuirMovimientos(disminucion);}

    public String obtenerNombre(){return this.nombre;}

    public void moverVehiculo(Direccion direccion){
        int incremento = 1;
        this.vehiculo.mover(direccion);
        this.vehiculo.incrementarMovimientos(incremento);

    }

    // Se usa para tests
    public boolean verificarMovimiento(int cantMovimientos){
       return this.vehiculo.verificarMovimientos(cantMovimientos);
    }

    public void cambiarVehiculo(Vehiculo vehiculoNuevo){
        this.vehiculo = vehiculoNuevo;
    }

    // Se usa para tests
    public boolean mismoVehiculo(Vehiculo vehiculo) {
        // TODO cambiar la comparación
        return (this.vehiculo.getClass() == vehiculo.getClass() && this.vehiculo.verificarUbicacion(vehiculo.ubicacion()));
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

    public boolean equals(Jugador otroJugador){
        return (this.nombre == otroJugador.nombre() & this.vehiculo == otroJugador.vehiculo());
    }
}