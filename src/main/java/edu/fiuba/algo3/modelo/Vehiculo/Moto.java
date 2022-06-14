package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.General.ObjetoUrbano;
import edu.fiuba.algo3.modelo.General.Ubicacion;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;

import java.util.HashMap;

public class Moto extends Vehiculo {
    public Moto(Ubicacion ubicacion) {
        super(ubicacion);
    }

    protected Vehiculo recibePozo(ObjetoUrbano x) {
        int incremento = 3;
        this.incrementarMovimientos(incremento);
        return this;
    }

    protected Vehiculo recibePiquete(ObjetoUrbano x) {
        int incremento = 2;
        this.incrementarMovimientos(incremento);
        return this;
    }

    protected Vehiculo recibeFavorable(ObjetoUrbano x) {
        int movimientosReducidos = this.movimientos() / 5;
        this.disminuirMovimientos(movimientosReducidos);
        return this;
    }

    protected Vehiculo  recibeDesfavorable(ObjetoUrbano x) {
        int movimientosAumentados = this.movimientos() / 4;
        this.incrementarMovimientos(movimientosAumentados);
        return this;
    }

    protected Vehiculo  recibeCambioVehiculo(ObjetoUrbano x) {
        Vehiculo nuevoVehiculo = new Auto(this.obtenerUbicacion());
        //this.cambiarVehiculo(nuevoVehiculo);
        nuevoVehiculo.asignarMovimientos(this.movimientos());
        return (nuevoVehiculo);

    }

}
