package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class Jugador {

    private int movimientos;
    private Vehiculo vehiculo;
    private String nombre;

    public Jugador(String nombreJugador, Vehiculo vehiculoElegido){
        this.movimientos = 0;
        this.vehiculo = vehiculoElegido;
        this.nombre = nombreJugador;
    }

    /*
    public void tuTurno(Direccion direccion){
        this.vehiculo.mover(direccion);
    }
    */
    public int movimientos(){return this.movimientos;}

    public void incrementarMovimientos(int incremento){this.movimientos += incremento;}

    public void disminuirMovimientos(int disminucion){this.movimientos -= disminucion;}

    public String obtenerNombre(){return this.nombre;}

    public Ubicacion obtenerUbicacion() {
        return this.vehiculo.obtenerUbicacion();
    }

    public void moverVehiculo(Direccion direccion){
     
        this.vehiculo.mover(direccion);

        this.incrementarMovimientos(1);

    }


}

