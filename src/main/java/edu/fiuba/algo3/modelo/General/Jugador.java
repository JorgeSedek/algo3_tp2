package edu.fiuba.algo3.modelo.General;

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
    DE MOMENTO NO SE UTILIZA

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
        int incremento = 1;
        this.vehiculo.mover(direccion);
        this.incrementarMovimientos(incremento);

    }

   public int obtenerMovimiento(){
        return this.movimientos;
    }

    public void sumarMovimientos(Vehiculo vehiculo){
        this.movimientos += vehiculo.movimientos();
    }

    // Se usa para tests
    public boolean verificarMovimiento(int cantMovimientos){
        if(this.movimientos == cantMovimientos){
            return true;
        }
        return false;
    }

    public void cambiarVehiculo(Vehiculo vehiculoNuevo){
        this.vehiculo = vehiculoNuevo;
    }

    /*
    No se utiliza de momento
    public boolean verificarVehiculoDatos(Ubicacion ubicacion){
        if(this.vehiculo.obtenerUbicacion() == ubicacion){
            return true;
        }
        return false;
    }
    */

    public boolean mismoVehiculo(Vehiculo vehiculo) {
        // TODO cambiar la comparación
        return (this.vehiculo.getClass() == vehiculo.getClass() && this.vehiculo.verificarUbicacion(vehiculo.obtenerUbicacion()));
    }

    public Vehiculo obtenerVehiculo(){
        return this.vehiculo;
    }
}