package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.ObjetoUrbano;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Sorpresas.CambioVehiculo;
import edu.fiuba.algo3.modelo.Sorpresas.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresas.Favorable;

import java.util.HashMap;

public class Auto extends Vehiculo {
    public Auto(Ubicacion ubicacion) {
        super(ubicacion);
    }

    protected Vehiculo recibePozo(ObjetoUrbano x) {
        int incremento = 3;
        this.incrementarMovimientos(incremento);
        return this;
    }

    protected Vehiculo recibePiquete(ObjetoUrbano x) {
        return this;
    }

    protected Vehiculo recibeFavorable(ObjetoUrbano x) {
        int movimientosReducidos = this.movimientos() / 5;
        this.disminuirMovimientos(movimientosReducidos);
        return this;
    }

    protected Vehiculo recibeDesfavorable(ObjetoUrbano x) {
        int movimientosAumentados = this.movimientos() / 4;
        this.incrementarMovimientos(movimientosAumentados);
        return this;
    }

    protected Vehiculo recibeCambioVehiculo(ObjetoUrbano x) {
        Vehiculo nuevoVehiculo = new Camioneta(this.obtenerUbicacion());
        //this.cambiarVehiculo(nuevoVehiculo);
        nuevoVehiculo.asignarMovimientos(this.movimientos());
        return (nuevoVehiculo);
    }
}

