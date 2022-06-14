package edu.fiuba.algo3.modelo.General;

import edu.fiuba.algo3.modelo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.Vehiculo.Vehiculo;

public class Jugador {
    private Vehiculo vehiculo;
    private String nombre;

    public Jugador(String nombreJugador, Vehiculo vehiculoElegido){
        this.vehiculo = vehiculoElegido;
        this.nombre = nombreJugador;
    }

    /*
    DE MOMENTO NO SE UTILIZA

    public void tuTurno(Direccion direccion){
        this.vehiculo.mover(direccion);
    }
    */

    public int movimientos() {return this.vehiculo.movimientos();}

    public void incrementarMovimientos(int incremento){this.vehiculo.incrementarMovimientos(incremento);}

    public void disminuirMovimientos(int disminucion){this.vehiculo.disminuirMovimientos(disminucion);}

    public String obtenerNombre(){return this.nombre;}

    public Ubicacion obtenerUbicacion() {
        return this.vehiculo.obtenerUbicacion();
    }

    public void moverVehiculo(Direccion direccion){
        int incremento = 1;
        this.vehiculo.mover(direccion);
        this.vehiculo.incrementarMovimientos(incremento);

    }

    // Se usa para tests
    public boolean verificarMovimiento(int cantMovimientos){
        if(this.vehiculo.movimientos() == cantMovimientos){
            return true;
        }
        return false;
    }

    public void cambiarVehiculo(Vehiculo vehiculoNuevo){
        this.vehiculo = vehiculoNuevo;
    }

    public boolean mismoVehiculo(Vehiculo vehiculo) {
        // TODO cambiar la comparación
        return (this.vehiculo.getClass() == vehiculo.getClass() && this.vehiculo.verificarCasillero(vehiculo.casillero()));
    }

    public Vehiculo obtenerVehiculo(){
        return this.vehiculo;
    }
}