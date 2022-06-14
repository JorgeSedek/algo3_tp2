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

    protected void recibePozo(ObjetoUrbano x) {
        int incremento = 3;
        this.incrementarMovimientos(incremento);
    }

    protected void recibePiquete(ObjetoUrbano x) {
        int incremento = 2;
        this.incrementarMovimientos(incremento);
    }

    protected void recibeFavorable(ObjetoUrbano x) {
        int movimientosReducidos = this.movimientos() / 5;
        this.disminuirMovimientos(movimientosReducidos);
    }

    protected void recibeDesfavorable(ObjetoUrbano x) {
        int movimientosAumentados = this.movimientos() / 4;
        this.incrementarMovimientos(movimientosAumentados);
    }

    protected void recibeCambioVehiculo(ObjetoUrbano x) {
        Vehiculo nuevoVehiculo = new Auto(this.obtenerUbicacion());
        //this.cambiarVehiculo(nuevoVehiculo);
    }
}
